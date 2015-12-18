<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>摩托配件信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
   });

  	function uploadFile(data){
  		$("#tMotoProductId").val(data.obj.id);
  		if($(".uploadify-queue-item").length>0){
  			upload();
  		}else{
  			frameElement.api.opener.reloadTable();
  			frameElement.api.close();
  		}
  	}
  	
  	function close(){
  		frameElement.api.close();
  	}
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="@Override uploadFile" tiptype="1" action="tMotoProductController.do?doAdd">
					<input id="id" name="id" type="hidden" value="${tMotoProductPage.id }">
					<input id="type" name="type" type="hidden" value="${type }">
					<input id="imgUrl" name="imgUrl" type="hidden" value="${tMotoProductPage.imgUrl }">
					<input id="createName" name="createName" type="hidden" value="${tMotoProductPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${tMotoProductPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${tMotoProductPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${tMotoProductPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${tMotoProductPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${tMotoProductPage.updateDate }">
		<table cellpadding="0" cellspacing="1" class="formtable">
			<tr>
				<td align="right"><label class="Validform_label">蓝帆编码:</label></td>
				<td class="value"><input id="partNo" name="partNo" type="text" readOnly="true"
					style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.partNo}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">蓝帆编码</label></td>
				
				
				<td align="right"><label class="Validform_label">OEM编码</label></td>
				<td class="value"><input id="oemCode" name="oemCode"
					type="text" style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.oemCode}"> <span
					class="Validform_checktip"><label class="Validform_label"
					style="display: none;">OEM编码</label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">中文名称:</label></td>
				<td class="value"><input id="partsNameCh" name="partsNameCh"
					type="text" style="width: 150px" class="inputxt" datatype="*" errormsg="该字段不为空"
					value="${tMotoProductPage.partsNameCh}"> <span
					class="Validform_checktip"><font color="red">*</font></span> <label class="Validform_label"
					style="display: none;">中文名称</label></td>
					
				
				<td align="right"><label class="Validform_label">英语名称:</label>
				</td>
				<td class="value"><input id="partsNameEn" name="partsNameEn" type="text"
					style="width: 150px" class="inputxt" datatype="*" errormsg="该字段不为空"
					value="${tMotoProductPage.partsNameEn}"> <span
					class="Validform_checktip"><font color="red">*</font></span> <label class="Validform_label"
					style="display: none;">英语名称</label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">西语名称:</label>
				</td>
				<td class="value"><input id="partsNameEspana" name="partsNameEspana" type="text"
					style="width: 150px" class="inputxt" datatype="*" errormsg="该字段不为空"
					value="${tMotoProductPage.partsNameEspana}"> <span
					class="Validform_checktip"><font color="red">*</font></span> <label class="Validform_label"
					style="display: none;">西语名称</label></td>
				
				
				<td align="right"><label class="Validform_label">俄语名称:</label>
				</td>
				<td class="value"><input id="partsNameRussian" name="partsNameRussian" type="text"
					style="width: 150px" class="inputxt" datatype="*" errormsg="该字段不为空"
					value="${tMotoProductPage.partsNameRussian}"> <span
					class="Validform_checktip"><font color="red">*</font></span> <label class="Validform_label"
					style="display: none;">俄语名称</label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">适用型号:</label>
				</td>
				<td class="value"><input id="model" name="model" type="text"
					style="width: 150px" class="inputxt" datatype="*" errormsg="该字段不为空"
					value="${tMotoProductPage.model}"> <span
					class="Validform_checktip"><font color="red">*</font></span> <label class="Validform_label"
					style="display: none;">适用型号</label></td>
				
				
<%-- 				<td align="right"><label class="Validform_label">尺寸:</label>
				</td>
				<td class="value"><input id="size" name="size" type="text"
					style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.size}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">尺寸</label></td> --%>
					
				<td align="right"><label class="Validform_label">颜色:</label>
				</td>
				<td class="value"><input id="color" name="color" type="text"
					style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.color}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">颜色</label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">材料:</label>
				</td>
				<td class="value"><input id="material" name="material" type="text"
					style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.material}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">材料</label></td>
				
				
				<td align="right"><label class="Validform_label">销售国家:</label>
				</td>
				<td class="value"><input id="sellTo" name="sellTo" type="text"
					style="width: 150px" class="inputxt" datatype="*" errormsg="该字段不为空" 
					value="${tMotoProductPage.sellTo}"> <span
					class="Validform_checktip"><font color="red">*</font></span> <label class="Validform_label"
					style="display: none;">销售国家</label></td>
				
			</tr>
			<tr>
<%-- 				<td align="right"><label class="Validform_label">单位:</label>
				</td>
				<td class="value"><input id="unit" name="unit" type="text"
					style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.unit}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">单位</label></td> --%>

				<td align="right"><label class="Validform_label">单位:</label>
				</td>
				<td class="value"><t:dictSelect field="unit" typeGroupCode="unit"
						hasLabel="false" defaultVal="${tMotoProductPage.unit}" extendJson='{datatype:"*"}'></t:dictSelect> <span
					class="Validform_checktip"><font color="red">*</font></span>
				</td>
				

				<td align="right"><label class="Validform_label">FOB价格:</label>
				</td>
				<td class="value"><input id="price" name="price" type="text"
					style="width: 150px" class="inputxt" datatype="d" errormsg="FOB价格非法!" ignore="ignore"
					value="${tMotoProductPage.price}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">FOB价格 </label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">订单序号:</label>
				</td>
				<td class="value"><input id="orderNo" name="orderNo" type="text"
					style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.orderNo}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">订单序号</label></td>
				


				<td align="right"><label class="Validform_label">供应商:</label>
				</td>
				<td class="value"><input id="producer" name="producer" type="text"
					style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.producer}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">供应商</label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">出厂价:</label>
				</td>
				<td class="value"><input id="exw" name="exw" type="text"
					style="width: 150px" class="inputxt" datatype="d" errormsg="出厂价非法!" ignore="ignore"
					value="${tMotoProductPage.exw}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">出厂价</label></td>
				


<%-- 				<td align="right"><label class="Validform_label">利润比率(%):</label>
				</td>
				<td class="value"><input id="profitRatio" name="profitRatio" type="text" readOnly="true"
					style="width: 150px" class="inputxt" ignore="ignore"
					value="${tMotoProductPage.profitRatio}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">利润比率(%)</label></td> --%>
					
				<td align="right"><label class="Validform_label">库存数量:</label>
				</td>
				<td class="value"><input id="stock" name="stock" type="text"
					style="width: 150px" class="inputxt" datatype="n" errormsg="库存数量非法!"
					value="${tMotoProductPage.stock}"> <span
					class="Validform_checktip"><font color="red">*</font></span> <label class="Validform_label"
					style="display: none;">库存数量</label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">已售数量:</label>
				</td>
				<td class="value"><input id="selled" name="selled" type="text"
					style="width: 150px" class="inputxt"  datatype="n" errormsg="已售数量非法!"
					value="${tMotoProductPage.selled}"> <span
					class="Validform_checktip"><font color="red">*</font></span> <label class="Validform_label"
					style="display: none;">已售数量</label></td>
				
					
				<td align="right"><label class="Validform_label">包装方式:</label>
				</td>
				<td class="value"><t:dictSelect field="wrapType" typeGroupCode="wrapType"
						hasLabel="false" defaultVal="${tMotoProductPage.wrapType}" extendJson='{datatype:"*"}'></t:dictSelect> <span
					class="Validform_checktip"><font color="red">*</font></span>
				</td>	
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">产品长度(MM):</label>
				</td>
				<td class="value"><input id="productLength" name="productLength" type="text"
					style="width: 150px" class="inputxt" datatype="n" errormsg="产品长度非法!" ignore="ignore"
					value="${tMotoProductPage.productLength}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">产品长度(MM)</label></td>
				
					
				<td align="right"><label class="Validform_label">产品宽度(MM):</label>
				</td>
				<td class="value"><input id="productWidth" name="productWidth" type="text"
					style="width: 150px" class="inputxt" datatype="n" errormsg="产品宽度非法!" ignore="ignore"
					value="${tMotoProductPage.productWidth}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">产品宽度(MM)</label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">产品高度(MM):</label>
				</td>
				<td class="value"><input id="productHigh" name="productHigh" type="text"
					style="width: 150px" class="inputxt" datatype="n" errormsg="产品高度非法!" ignore="ignore"
					value="${tMotoProductPage.productHigh}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">产品高度(MM)</label></td>
				
					
				<td align="right"><label class="Validform_label">产品重量(KGS):</label>
				</td>
				<td class="value"><input id="productNet" name=productNet type="text"
					style="width: 150px" class="inputxt" datatype="d" errormsg="产品重量非法!" ignore="ignore"
					value="${tMotoProductPage.productNet}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">产品重量(KGS)</label></td>	
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">装箱数量:</label>
				</td>
				<td class="value"><input id="packingQuantity" name="packingQuantity" type="text"
					style="width: 150px" class="inputxt" datatype="n" errormsg="装箱数量非法!" ignore="ignore"
					value="${tMotoProductPage.packingQuantity}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">装箱数量</label></td>
				
					
				<td align="right"><label class="Validform_label">箱规长度(MM):</label>
				</td>
				<td class="value"><input id="boxLength" name=boxLength type="text"
					style="width: 150px" class="inputxt" datatype="n" errormsg="箱规长度非法!" ignore="ignore"
					value="${tMotoProductPage.boxLength}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">箱规长度(MM)</label></td>	
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">箱规宽度(MM):</label>
				</td>
				<td class="value"><input id="boxWidth" name="boxWidth" type="text"
					style="width: 150px" class="inputxt" datatype="n" errormsg="箱规宽度非法!" ignore="ignore"
					value="${tMotoProductPage.boxWidth}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">箱规宽度(MM)</label></td>
				
					
				<td align="right"><label class="Validform_label">箱规高度(MM):</label>
				</td>
				<td class="value"><input id="boxHigh" name=boxHigh type="text"
					style="width: 150px" class="inputxt" datatype="n" errormsg="箱规高度非法!" ignore="ignore"
					value="${tMotoProductPage.boxHigh}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">箱规高度(MM)</label></td>	
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">每箱重量(KGS):</label>
				</td>
				<td class="value" colspan="3"><input id="boxNet" name="boxNet" type="text"
					style="width: 150px" class="inputxt" datatype="d" errormsg="每箱重量非法!" ignore="ignore"
					value="${tMotoProductPage.boxNet}"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">每箱重量(KGS)</label></td>
				
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">
						备注: </label></td>
				<td class="value" colspan="3"><textarea id="remark"
						style="width:300px;" class="inputxt" rows="6" name="remark">${tMotoProductPage.remark}</textarea>
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">备注</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label">附件:</label>
				</td>
				<td colspan="3" class="value"><input type="hidden"
					value="${tMotoProductPage.id}" id="tMotoProductId"
					name="tMotoProductId" />
					<table>
						<c:forEach items="${tMotoProductPage.motoProductAttach}"
							var="motoProductAttach">
							<tr style="height: 34px;">
								<td>${motoProductAttach.attachmenttitle}</td>
								<td><a
									href="commonController.do?viewFile&fileid=${motoProductAttach.id}&subclassname=com.buss.fujitsu.entity.TMotoProductAttachEntity"
									title="下载">下载</a>
								</td>
								<td><a href="javascript:void(0);"
									onclick="openwindow('预览','commonController.do?openViewFile&fileid=${motoProductAttach.id}&subclassname=com.buss.fujitsu.entity.TMotoProductAttachEntity','fList','800','700')">预览</a>
								</td>
								<td><a href="javascript:void(0)" class="jeecgDetail"
									onclick="del('tMotoProductController.do?delFile&id=${motoProductAttach.id}&mainId=${tMotoProductPage.id}',this)">删除</a>
								</td>
							</tr>
						</c:forEach>
					</table></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="3" class="value"><script type="text/javascript">
					$.dialog.setting.zIndex = 1990;
					function del(url, obj) {
						$.dialog.confirm("确认删除该条记录?", function() {
							$.ajax({
								async : false,
								cache : false,
								type : 'POST',
								url : url,// 请求的action路径
								error : function() {// 请求失败处理函数
								},
								success : function(data) {
									var d = $.parseJSON(data);
									if (d.success) {
										var msg = d.msg;
										tip(msg);
										$(obj).closest("tr").hide("slow");
									}
								}
							});
						}, function() {
						});
					}
				</script>
					<div class="form" id="filediv"></div>
					<div class="form jeecgDetail">
						<t:upload name="files" id="file_upload"
							extend="pic"
							buttonText="添加文件" formId="formobj"
							uploader="tMotoProductController.do?saveFiles"
							multi="true">
						</t:upload>
					</div></td>
			</tr>
		</table>
		<%-- 	<div style="width: auto;height: 200px;">
				增加一个div，用于调节页面大小，否则默认太小
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="tMotoProductController.do?tMotoProductAttachList&id=${tMotoProductPage.id}" icon="icon-search" title="摩托配件附件表" id="tMotoProductAttach"></t:tab>
				</t:tabs>
			</div> --%>
			</t:formvalid>
 </body>
 <script src = "webpage/com/buss/fujitsu/tMotoProduct.js"></script>	