<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="tMotoProductList" checkbox="true" pageSize="50" fitColumns="false" title="摩托配件信息表" actionUrl="tMotoProductController.do?datagrid&type=${type}" idField="id" fit="true" queryMode="group" extendParams="nowrap:false,">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  hidden="true"  queryMode="single"  width="120" ></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="蓝帆编码"  field="partNo"    queryMode="single"  width="120" query="true" frozenColumn="true"></t:dgCol>
   <t:dgCol title="图片预览" image="true" imageSize="100,100" field="imgUrl" frozenColumn="true"></t:dgCol>
   <t:dgCol title="OEM编码"  field="oemCode"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="中文名称"  field="partsNameCh"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="英语名称"  field="partsNameEn"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="西语名称"  field="partsNameEspana"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="俄语名称"  field="partsNameRussian"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="适用型号"  field="model"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="颜色"  field="color"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="材料"  field="material"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="销售国家"  field="sellTo"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="单位"  field="unit"   dictionary="unit" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="FOB价格"  field="price"    queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="订单序号"  field="orderNo"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="供应商"  field="producer"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="出厂价"  field="exw"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="利润比率(%)"  field="profitRatio"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="库存数量"  field="stock"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="已售数量"  field="selled"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="包装方式"  field="wrapType"  dictionary="wrapType"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="产品长度(MM)"  field="productLength"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产品宽度(MM)"  field="productWidth"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产品高度(MM)"  field="productHigh"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产品重量(KGS)"  field="productNet"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装箱数量"  field="packingQuantity"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="箱规长度(MM)"  field="boxLength"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="箱规宽度(MM)"  field="boxWidth"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="箱规高度(MM)"  field="boxHigh"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="每箱重量(KGS)"  field="boxNet"    queryMode="single"  width="120"></t:dgCol>
   
   
   <t:dgCol title="备注"  field="remark"    queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tMotoProductController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="tMotoProductController.do?addorupdate&type=${type}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tMotoProductController.do?addorupdate&type=${type}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tMotoProductController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tMotoProductController.do?addorupdate&type=${type}" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%-- <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/fujitsu/tMotoProductList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#tMotoProductListtb").find("input[name='createDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#tMotoProductListtb").find("input[name='updateDate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tMotoProductController.do?upload&type=${type}', "tMotoProductList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tMotoProductController.do?exportXls&type=${type}","tMotoProductList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tMotoProductController.do?exportXlsByT","tMotoProductList");
}
 </script>