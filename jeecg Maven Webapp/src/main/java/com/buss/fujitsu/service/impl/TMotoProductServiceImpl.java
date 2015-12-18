package com.buss.fujitsu.service.impl;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.fujitsu.entity.TMotoProductAttachEntity;
import com.buss.fujitsu.entity.TMotoProductEntity;
import com.buss.fujitsu.service.TMotoProductServiceI;


@Service("tMotoProductService")
@Transactional
public class TMotoProductServiceImpl extends CommonServiceImpl implements TMotoProductServiceI {
	

	public void delMain(TMotoProductEntity tMotoProduct) {
		//删除主表信息
		this.delete(tMotoProduct);
		//===================================================================================
		//获取参数
		Object id0 = tMotoProduct.getId();
		//===================================================================================
		//删除-摩托配件附件表
	    String hql0 = "from TMotoProductAttachEntity where 1 = 1 AND t_MOTO_PRODUCT_ID = ? ";
	    List<TMotoProductAttachEntity> tMotoProductAttachOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(tMotoProductAttachOldList);
	}
 	
	/**
	 * 附件删除
	 */
	public void deleteFile(TMotoProductAttachEntity file) {
		
		//[1].删除附件
		String sql = "select * from t_s_attachment where id = ?";
		Map<String, Object> attachmentMap = commonDao.findOneForJdbc(sql, file.getId());
		//附件相对路径
		String realpath = (String) attachmentMap.get("realpath");
		String fileName = FileUtils.getFilePrefix2(realpath);
		
		//获取部署项目绝对地址
		String realPath = ContextHolderUtils.getSession().getServletContext().getRealPath("/");
		FileUtils.delete(realPath+realpath);
		FileUtils.delete(realPath+fileName+".pdf");
		FileUtils.delete(realPath+fileName+".swf");
		//[2].删除数据
		commonDao.delete(file);
	}
}