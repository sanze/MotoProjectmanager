package com.buss.fujitsu.controller;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.UploadFile;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.buss.fujitsu.entity.TMotoProductAttachEntity;
import com.buss.fujitsu.entity.TMotoProductEntity;
import com.buss.fujitsu.service.TMotoProductServiceI;


/**   
 * @Title: Controller
 * @Description: 摩托配件信息表
 * @author onlineGenerator
 * @date 2015-11-09 11:53:29
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/tMotoProductController")
public class TMotoProductController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TMotoProductController.class);

	@Autowired
	private TMotoProductServiceI tMotoProductService;
	@Autowired
	private SystemService systemService;
	
	private String noMeaningValue = "-999999";
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 摩托配件信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tMotoProduct")
	public ModelAndView tMotoProduct(HttpServletRequest request) {
		//添加类型参数
		request.setAttribute("type", request.getParameter("type"));
		return new ModelAndView("com/buss/fujitsu/tMotoProductList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TMotoProductEntity tMotoProduct,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TMotoProductEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tMotoProduct);
		try{
			
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tMotoProductService.getDataGridReturn(cq, true);
		
		//设置显示图片地址
		for(Object obj:dataGrid.getResults()){
			TMotoProductEntity entity = (TMotoProductEntity)obj;
			if(entity.getMotoProductAttach().size()>0){
				entity.setImgUrl(entity.getMotoProductAttach().get(0).getRealpath());
			}else{
				entity.setImgUrl(null);
			}
			entity.setProfitRatio(calculateProfitRatio(entity));
		}
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 保存文件
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TMotoProductAttachEntity motoProductAttach) {
		AjaxJson j = new AjaxJson();
		Map<String, Object> attributes = new HashMap<String, Object>();
		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
		
		String tMotoProductId = oConvertUtils.getString(request.getParameter("tMotoProductId"));//主表ID
		
		if (StringUtil.isNotEmpty(fileKey)) {
			motoProductAttach.setId(fileKey);
			motoProductAttach = systemService.getEntity(TMotoProductAttachEntity.class, fileKey);

		}
		TMotoProductEntity motoProduct = systemService.getEntity(TMotoProductEntity.class, tMotoProductId);
		motoProductAttach.setMotoProduct(motoProduct);
		//坑爹啊 不加这个保存就失败
		motoProductAttach.setId(null);
		UploadFile uploadFile = new UploadFile(request, motoProductAttach);
		uploadFile.setCusPath("files");
		uploadFile.setSwfpath("swfpath");
		uploadFile.setByteField(null);//不存二进制内容
		motoProductAttach = systemService.uploadFile(uploadFile,true,700d,700d);
		attributes.put("fileKey", motoProductAttach.getId());
		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + motoProductAttach.getId());
		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + motoProductAttach.getId());
		j.setMsg("文件添加成功");
		j.setAttributes(attributes);
		return j;
	}

	/**
	 * 删除摩托配件信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TMotoProductEntity tMotoProduct, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		tMotoProduct = systemService.getEntity(TMotoProductEntity.class, tMotoProduct.getId());
		String message = "摩托配件信息表删除成功";
		try{
			tMotoProductService.delMain(tMotoProduct);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "摩托配件信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除摩托配件信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "摩托配件信息表删除成功";
		try{
			for(String id:ids.split(",")){
				TMotoProductEntity tMotoProduct = systemService.getEntity(TMotoProductEntity.class,
				id
				);
				tMotoProductService.delMain(tMotoProduct);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "摩托配件信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加摩托配件信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TMotoProductEntity tMotoProduct,HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tMotoProduct.getId())) {
			message = "更新成功";
//			TMotoProductEntity t = tMotoProductService.get(TMotoProductEntity.class, tMotoProduct.getId());
			try {
//				MyBeanUtils.copyBean2Bean(tMotoProduct, t);
				
//				//计算利润比率
//				Double profitRatio = calculateProfitRatio(tMotoProduct);
//				
//				tMotoProduct.setProfitRatio(profitRatio);
				
				tMotoProductService.saveOrUpdate(tMotoProduct);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			message = "添加成功";
			
//			//计算利润比率
//			Double profitRatio = calculateProfitRatio(tMotoProduct);
//			
//			tMotoProduct.setProfitRatio(profitRatio);
			
			tMotoProduct.setPartNo(generatePartNo(tMotoProduct.getType()));
			
			tMotoProductService.save(tMotoProduct);
		
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setObj(tMotoProduct);
		return j;
		
	}

	
	/**
	 * 删除文档
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "delFile")
	@ResponseBody
	public AjaxJson delFile( HttpServletRequest request) {
		AjaxJson j = new AjaxJson();

		String id  = request.getParameter("id");
		TMotoProductAttachEntity file = systemService.getEntity(TMotoProductAttachEntity.class, id);
		message = "" + file.getAttachmenttitle() + "被删除成功";
		tMotoProductService.deleteFile(file);

		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
		j.setSuccess(true);
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 配件管理添加更新页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TMotoProductEntity tMotoProduct, HttpServletRequest req) {
		//添加类型参数
		req.setAttribute("type", req.getParameter("type"));
		if (StringUtil.isNotEmpty(tMotoProduct.getId())) {
			tMotoProduct = tMotoProductService.getEntity(TMotoProductEntity.class, tMotoProduct.getId());
			tMotoProduct.setType(req.getParameter("type"));
			req.setAttribute("tMotoProductPage", tMotoProduct);
		}
		return new ModelAndView("com/buss/fujitsu/tMotoProduct");
	}
	
	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TMotoProductEntity tMotoProduct,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap map) {

        CriteriaQuery cq = new CriteriaQuery(TMotoProductEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tMotoProduct, request.getParameterMap());
        List<TMotoProductEntity> motoProducts = this.tMotoProductService.getListByCriteriaQuery(cq,false);

        map.put(NormalExcelConstants.FILE_NAME,"摩托配件信息");
        map.put(NormalExcelConstants.CLASS,TMotoProductEntity.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("摩托配件列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
                "导出信息"));
        
        for(TMotoProductEntity entity:motoProducts){
        	entity.setProfitRatio(calculateProfitRatio(entity));
        }
        
        map.put(NormalExcelConstants.DATA_LIST,motoProducts);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;

	}
	
	/**
	 * 学生列表
	 *
	 * @return
	 */
	@RequestMapping(params = "upload")
	public String upload(HttpServletRequest req) {
		//添加类型参数
		req.setAttribute("type", req.getParameter("type"));
		return "com/buss/fujitsu/tMotoPruductUpload";
	}
	
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request,
			HttpServletResponse response) {
		AjaxJson j = new AjaxJson();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<TMotoProductEntity> listProducts = ExcelImportUtil
						.importExcel(convertExcelData(file.getInputStream()),
								TMotoProductEntity.class, params);

				//需要导入的数据
				List<TMotoProductEntity> listProductsImport = new ArrayList<TMotoProductEntity>();

				String partNo = checkUniquePartNo(listProducts);

				if (partNo.isEmpty()) {
					for (TMotoProductEntity product : listProducts) {
						// 获取所有属性值
						Field[] fields = product.getClass().getDeclaredFields();
						for (Field field : fields) {
							PropertyDescriptor pd = new PropertyDescriptor(
									field.getName(), product.getClass());

							// 获得get方法
							Method get = pd.getReadMethod();
							// 获得set方法
							Method set = pd.getWriteMethod();
							// get属性值
							Object getValue = get.invoke(product,
									new Object[] {});
							// 设置null
							if (getValue != null) {
								if (Integer.class.isInstance(getValue)
										&& Integer.valueOf(noMeaningValue).intValue() == Integer
												.valueOf(getValue.toString()).intValue()) {
									set.invoke(product, new Object[]{null});
								}else if (Double.class.isInstance(getValue)
										&& Double.valueOf(noMeaningValue).doubleValue() == Double
												.valueOf(getValue.toString()).doubleValue()) {
									set.invoke(product, new Object[]{null});
								}else if (String.class.isInstance(getValue)
										&& noMeaningValue.equals(getValue.toString())) {
									set.invoke(product, "");
								}
							}
						}
						// 保存数据
						if (product.getPartNo() != null) {
							product.setType(request.getParameter("type"));
							listProductsImport.add(product);
//							tMotoProductService.save(product);
						}
					}
					//批量保存数据
					tMotoProductService.batchSave(listProductsImport);
					
					j.setMsg("文件导入成功！");
				} else {
					j.setMsg("文件导入失败！存在重复的蓝帆编码：" + partNo);
				}

			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			} finally {
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	//读取excel数据
	private synchronized InputStream convertExcelData(InputStream fis) throws IOException {

		POIFSFileSystem ts= new POIFSFileSystem(fis);
		HSSFWorkbook wb=new HSSFWorkbook(ts);
        HSSFSheet sh= wb.getSheetAt(0);
        HSSFRow ro=null;
        for (int i = 0; sh.getRow(i)!=null; i++) {
            ro=sh.getRow(i);
            for (int k = 0; ro.getCell(k)!=null; k++) {
            	if((ro.getCell(k)+"").isEmpty()){
            		ro.getCell(k).setCellValue(noMeaningValue);
            	}
            }
        }
        String filePath = System.getProperty("java.io.tmpdir") + "/temp.xls";
        
        FileOutputStream fos = new FileOutputStream(filePath);
        
        wb.write(fos);  
        fis.close();  
        fos.close();
        
		return new FileInputStream(new File(filePath));
	}
	
	//检查导入文件中是否含有重复的partNo
	private String checkUniquePartNo(List<TMotoProductEntity> importProduct){
		
		String partNo = "";
		
		CriteriaQuery cq = new CriteriaQuery(TMotoProductEntity.class);
		
		List productListInDB = this.tMotoProductService.getListByCriteriaQuery(cq, false);
		for(TMotoProductEntity product:importProduct){
			String partNoImport = product.getPartNo();
			for(Object obj:productListInDB){
				TMotoProductEntity productInDB = (TMotoProductEntity)obj;
				if(partNoImport.equals(productInDB.getPartNo())){
					partNo = partNo+partNoImport+",";
				}
			}
				
		}
		if(!partNo.isEmpty()){
			partNo = partNo.substring(0, partNo.length()-1);
		}
		return partNo;
	}
	
	
	/**
	 * 计算利润比率
	 * @param tMotoProduct
	 * @return
	 */
	private Double calculateProfitRatio(TMotoProductEntity tMotoProduct) {
		// fob价格
		Double price = (tMotoProduct.getPrice() == null)?null:Double.valueOf(tMotoProduct.getPrice());
		// 出厂价格
		Double exw = (tMotoProduct.getExw() == null)?null:Double.valueOf(tMotoProduct.getExw());

		Double profitRatio = null;

		if (price != null && exw != null) {
			profitRatio = (price*6.1 - exw) / (price*6.1)*100;
			BigDecimal b = new BigDecimal(profitRatio);
			profitRatio = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
		
		return profitRatio;
	}
	
	/**
	 * 生成part_no
	 * @return
	 */
	private synchronized String generatePartNo(String type){
		
		String prifix = "SC"+type;
		
		CriteriaQuery cq = new CriteriaQuery(TMotoProductEntity.class);
		cq.add(Restrictions.eq("type", type));
		cq.addOrder("createDate",SortDirection.desc);
		
		List list = this.tMotoProductService.getListByCriteriaQuery(cq, true);

		String sequence = "000000";
		
		if(list!=null&&list.size()>0){
			sequence = ((TMotoProductEntity)list.get(0)).getPartNo().split(prifix)[1];
		}
		String maxId = prifix+String.format("%06d", Integer.valueOf(sequence)+1);
		return maxId;
	}
	
}
