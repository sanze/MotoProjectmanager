package com.buss.fujitsu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.web.system.pojo.base.TSAttachment;

/**   
 * @Title: Entity
 * @Description: 摩托配件附件表
 * @author onlineGenerator
 * @date 2015-11-09 11:53:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_moto_product_attach", schema = "")
@PrimaryKeyJoinColumn(name = "id")
@SuppressWarnings("serial")
public class TMotoProductAttachEntity extends TSAttachment implements java.io.Serializable {
	
	private TMotoProductEntity motoProduct;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinColumn(name = "t_moto_product_id")
	public TMotoProductEntity getMotoProduct() {
		return motoProduct;
	}

	public void setMotoProduct(TMotoProductEntity motoProduct) {
		this.motoProduct = motoProduct;
	}
	
	
}
