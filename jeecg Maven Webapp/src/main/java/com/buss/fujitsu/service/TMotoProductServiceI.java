package com.buss.fujitsu.service;
import org.jeecgframework.core.common.service.CommonService;

import com.buss.fujitsu.entity.TMotoProductAttachEntity;
import com.buss.fujitsu.entity.TMotoProductEntity;

public interface TMotoProductServiceI extends CommonService{
	

	public void delMain (TMotoProductEntity tMotoProduct);
	
 	
 	public void deleteFile(TMotoProductAttachEntity file);
 	
 	
}
