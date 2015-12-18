package com.buss.fujitsu.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

/**   
 * @Title: Entity
 * @Description: 摩托配件信息表
 * @author onlineGenerator
 * @date 2015-11-09 11:53:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_moto_product", schema = "")
@SuppressWarnings("serial")
@ExcelTarget("tMotoProductEntity")
public class TMotoProductEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**TYPE*/
	private java.lang.String type;
	/**PART NO.*/
	@Excel(name="蓝帆编码")
	private java.lang.String partNo;
	/**OEM CODE*/
	@Excel(name="OEM编码")
	private java.lang.String oemCode;
	/**PARTS NAME CH*/
	@Excel(name="中文名称")
	private java.lang.String partsNameCh;
	/**PARTS NAME EN*/
	@Excel(name="英语名称")
	private java.lang.String partsNameEn;
	/**PARTS NAME Espana*/
	@Excel(name="西语名称")
	private java.lang.String partsNameEspana;
	/**PARTS NAME Russian*/
	@Excel(name="俄语名称")
	private java.lang.String partsNameRussian;
	/**MODEL*/
	@Excel(name="适用车型")
	private java.lang.String model;
	/**SIZE*/
/*	@Excel(name="尺寸")
	private java.lang.String size;*/
	/**SIZE*/
	@Excel(name="颜色")
	private java.lang.String color;
	/**Material*/
	@Excel(name="材料")
	private java.lang.String material;
	/**sellTo*/
	@Excel(name="销售国家")
	private java.lang.String sellTo;
	/**UNIT*/
	@Excel(name="单位",replace = {"PCS_PCS","SET_SET","PAIR_PAIR"})
	private java.lang.String unit;
	/**PRICE*/
	@Excel(name="FOB价格")
	private java.lang.Double price;
	/**ORDER_NO*/
	@Excel(name="订单序号")
	private java.lang.String orderNo;
	/**PRODUCER*/
	@Excel(name="供应商")
	private java.lang.String producer;
	/**EXW*/
	@Excel(name="出厂价")
	private java.lang.Double exw;
	/**PROFIT_RATIO*/
	@Excel(name="利润比率(%)")
	private java.lang.Double profitRatio;
	/**STOCK*/
	@Excel(name="库存数量")
	private java.lang.Integer stock;
	/**SELLED*/
	@Excel(name="已售数量")
	private java.lang.Integer selled;
	/**WRAP_TYPE*/
	@Excel(name="包装方式",replace = {"彩盒_1","中性盒_2","彩袋_3","中性袋_4","气泡袋_5","吸卡_6","吸塑_7","其他_8"})
	private java.lang.String wrapType;
	/**PRODUCT_LENGTH*/
	@Excel(name="产品长度")
	private java.lang.Integer productLength;
	/**PRODUCT_WIDTH*/
	@Excel(name="产品宽度")
	private java.lang.Integer productWidth;
	/**PRODUCT_HIGH*/
	@Excel(name="产品高度")
	private java.lang.Integer productHigh;
	/**PRODUCT_NET*/
	@Excel(name="产品重量")
	private java.lang.Integer productNet;
	/**PACKING_QUANTITY*/
	@Excel(name="装箱数量")
	private java.lang.Integer packingQuantity;
	/**BOX_LENGTH*/
	@Excel(name="箱规长度")
	private java.lang.Integer boxLength;
	/**BOX_WIDTH*/
	@Excel(name="箱规宽度")
	private java.lang.Integer boxWidth;
	/**BOX_HIGH*/
	@Excel(name="箱规高度")
	private java.lang.Integer boxHigh;
	/**BOX_NET*/
	@Excel(name="每箱重量")
	private java.lang.Integer boxNet;
	/**IMG_URL*/
	private java.lang.String imgUrl;
	
	/**REMARK*/
	@Excel(name="备注")
	private java.lang.String remark;
	
	/*@ExcelCollection(name="附件")*/
	private List<TMotoProductAttachEntity> motoProductAttach;
	
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */
	
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */
	
	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	
	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */
	
	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */
	
	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */
	
	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  PART NO.
	 */
	
	@Column(name ="PART_NO",nullable=true,length=128)
	public java.lang.String getPartNo(){
		return this.partNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  PART NO.
	 */
	public void setPartNo(java.lang.String partNo){
		this.partNo = partNo;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  OEM CODE
	 */
	
	@Column(name ="OEM_CODE",nullable=true,length=128)
	public java.lang.String getOemCode(){
		return this.oemCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  OEM CODE
	 */
	public void setOemCode(java.lang.String oemCode){
		this.oemCode = oemCode;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  PARTS NAME
	 */
	
	@Column(name ="PARTS_NAME_CH",nullable=true,length=128)
	public java.lang.String getPartsNameCh(){
		return this.partsNameCh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  PARTS_NAME_CH
	 */
	public void setPartsNameCh(java.lang.String partsNameCh){
		this.partsNameCh = partsNameCh;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  UNIT
	 */
	
	@Column(name ="UNIT",nullable=true,length=128)
	public java.lang.String getUnit(){
		return this.unit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  UNIT
	 */
	public void setUnit(java.lang.String unit){
		this.unit = unit;
	}
	
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  PRICE
	 */
	
	@Column(name ="PRICE",nullable=true,length=128)
	public java.lang.Double getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  PRICE
	 */
	public void setPrice(java.lang.Double price){
		this.price = price;
	}
	
	/**
	 *方法: 取得javax.xml.soap.Text
	 *@return: javax.xml.soap.Text  REMARK
	 */
	
	@Column(name ="REMARK",nullable=true,length=1000)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  REMARK
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  MODEL
	 */
	
	@Column(name ="MODEL",nullable=true,length=128)
	public java.lang.String getModel(){
		return this.model;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  MODEL
	 */
	public void setModel(java.lang.String model){
		this.model = model;
	}
	
	@Column(name ="PARTS_NAME_EN",nullable=true,length=128)
	public java.lang.String getPartsNameEn() {
		return partsNameEn;
	}

	public void setPartsNameEn(java.lang.String partsNameEn) {
		this.partsNameEn = partsNameEn;
	}

	@Column(name ="PARTS_NAME_ESPANA",nullable=true,length=128)
	public java.lang.String getPartsNameEspana() {
		return partsNameEspana;
	}

	public void setPartsNameEspana(java.lang.String partsNameEspana) {
		this.partsNameEspana = partsNameEspana;
	}

	@Column(name ="PARTS_NAME_RUSSIAN",nullable=true,length=128)
	public java.lang.String getPartsNameRussian() {
		return partsNameRussian;
	}

	public void setPartsNameRussian(java.lang.String partsNameRussian) {
		this.partsNameRussian = partsNameRussian;
	}

	@Column(name ="COLOR",nullable=true,length=128)
	public java.lang.String getColor() {
		return color;
	}

	public void setColor(java.lang.String color) {
		this.color = color;
	}

	@Column(name ="MATERIAL",nullable=true,length=128)
	public java.lang.String getMaterial() {
		return material;
	}

	public void setMaterial(java.lang.String material) {
		this.material = material;
	}

	@Column(name ="SELL_TO",nullable=true,length=128)
	public java.lang.String getSellTo() {
		return sellTo;
	}

	public void setSellTo(java.lang.String sellTo) {
		this.sellTo = sellTo;
	}
	
	@Column(name ="ORDER_NO",nullable=true,length=128)
	public java.lang.String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}

	@Column(name ="PRODUCER",nullable=true,length=128)
	public java.lang.String getProducer() {
		return producer;
	}

	public void setProducer(java.lang.String producer) {
		this.producer = producer;
	}

	@Column(name ="EXW",nullable=true,length=128)	
	public java.lang.Double getExw() {
		return exw;
	}

	public void setExw(java.lang.Double exw) {
		this.exw = exw;
	}

	@Column(name ="PROFIT_RATIO",nullable=true,length=128)
	public java.lang.Double getProfitRatio() {
		return profitRatio;
	}

	public void setProfitRatio(java.lang.Double profitRatio) {
		this.profitRatio = profitRatio;
	}

	@Column(name ="STOCK",nullable=true,length=128)
	public java.lang.Integer getStock() {
		return stock;
	}

	public void setStock(java.lang.Integer stock) {
		this.stock = stock;
	}

	@Column(name ="SELLED",nullable=true,length=128)
	public java.lang.Integer getSelled() {
		return selled;
	}

	public void setSelled(java.lang.Integer selled) {
		this.selled = selled;
	}

	@Column(name ="WRAP_TYPE",nullable=true,length=128)
	public java.lang.String getWrapType() {
		return wrapType;
	}

	public void setWrapType(java.lang.String wrapType) {
		this.wrapType = wrapType;
	}

	@Column(name ="PRODUCT_LENGTH",nullable=true,length=128)
	public java.lang.Integer getProductLength() {
		return productLength;
	}

	public void setProductLength(java.lang.Integer productLength) {
		this.productLength = productLength;
	}

	@Column(name ="PRODUCT_WIDTH",nullable=true,length=128)
	public java.lang.Integer getProductWidth() {
		return productWidth;
	}

	
	public void setProductWidth(java.lang.Integer productWidth) {
		this.productWidth = productWidth;
	}

	@Column(name ="PRODUCT_HIGH",nullable=true,length=128)
	public java.lang.Integer getProductHigh() {
		return productHigh;
	}

	public void setProductHigh(java.lang.Integer productHigh) {
		this.productHigh = productHigh;
	}

	@Column(name ="PRODUCT_NET",nullable=true,length=32)
	public java.lang.Integer getProductNet() {
		return productNet;
	}

	public void setProductNet(java.lang.Integer productNet) {
		this.productNet = productNet;
	}

	@Column(name ="PACKING_QUANTITY",nullable=true,length=128)
	public java.lang.Integer getPackingQuantity() {
		return packingQuantity;
	}

	public void setPackingQuantity(java.lang.Integer packingQuantity) {
		this.packingQuantity = packingQuantity;
	}

	@Column(name ="BOX_LENGTH",nullable=true,length=128)
	public java.lang.Integer getBoxLength() {
		return boxLength;
	}

	public void setBoxLength(java.lang.Integer boxLength) {
		this.boxLength = boxLength;
	}

	@Column(name ="BOX_WIDTH",nullable=true,length=128)
	public java.lang.Integer getBoxWidth() {
		return boxWidth;
	}

	public void setBoxWidth(java.lang.Integer boxWidth) {
		this.boxWidth = boxWidth;
	}

	@Column(name ="BOX_HIGH",nullable=true,length=128)
	public java.lang.Integer getBoxHigh() {
		return boxHigh;
	}

	public void setBoxHigh(java.lang.Integer boxHigh) {
		this.boxHigh = boxHigh;
	}

	@Column(name ="BOX_NET",nullable=true,length=32)
	public java.lang.Integer getBoxNet() {
		return boxNet;
	}

	public void setBoxNet(java.lang.Integer boxNet) {
		this.boxNet = boxNet;
	}
	
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	@Column(name ="IMG_URL",nullable=true,length=128)
	public java.lang.String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(java.lang.String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@OneToMany(mappedBy="motoProduct",cascade={CascadeType.REMOVE})
	public List<TMotoProductAttachEntity> getMotoProductAttach() {
		return motoProductAttach;
	}

	public void setMotoProductAttach(
			List<TMotoProductAttachEntity> motoProductAttach) {
		this.motoProductAttach = motoProductAttach;
	}
	
	
	
}
