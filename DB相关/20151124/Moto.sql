/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/11/24 15:00:52                          */
/*==============================================================*/


drop table if exists T_MOTO_PRODUCT;

drop table if exists T_MOTO_PRODUCT_ATTACH;

/*==============================================================*/
/* Table: T_MOTO_PRODUCT                                        */
/*==============================================================*/
create table T_MOTO_PRODUCT
(
   ID                   varchar(36) not null,
   CREATE_NAME          varchar(50) default NULL comment '创建人名称',
   CREATE_BY            varchar(50) default NULL comment '创建人登录名称',
   CREATE_DATE          datetime default NULL comment '创建日期',
   UPDATE_NAME          varchar(50) default NULL comment '更新人名称',
   UPDATE_BY            varchar(50) default NULL comment '更新人登录名称',
   UPDATE_DATE          datetime default NULL comment '更新日期',
   TYPE                 varchar(128) comment '1.摩托车 2.汽车 3.园林机械 4.智能产品 5.其他产品',
   PART_NO              varchar(128) not null comment '蓝帆编码唯一，系统自动生成，',
   OEM_CODE             varchar(128) default NULL comment 'OEM编码',
   PARTS_NAME_CH        varchar(128) default NULL comment '中文名称',
   UNIT                 varchar(128) default NULL comment '单位（1）PCS（2）SET（3）PAIR',
   PRICE                double default NULL comment 'FOB价格',
   REMARK               longtext comment '备注',
   MODEL                varchar(128) default NULL comment '适用车型',
   PARTS_NAME_EN        varchar(128) default NULL comment '英语名称',
   PARTS_NAME_ESPANA    varchar(128) default NULL comment '西语名称',
   PARTS_NAME_RUSSIAN   varchar(128) default NULL comment '俄语名称',
   SIZE                 varchar(128) default NULL comment '尺寸',
   COLOR                varchar(128) default NULL comment '颜色',
   MATERIAL             varchar(128) default NULL comment '材料',
   SELL_TO              varchar(128) default NULL comment '销售国家',
   ORDER_NO             varchar(128) default NULL comment '订单序号',
   PRODUCER             varchar(128) default NULL comment '供应商',
   EXW                  double default NULL comment '出厂价',
   PROFIT_RATIO         double default NULL comment '利润比率(%)',
   STOCK                int default NULL comment '库存数量',
   SELLED               int default NULL comment '已售数量',
   WRAP_TYPE            varchar(128) default NULL comment '包装方式（1）彩盒（2）中性盒（3）彩袋（4）中性袋(5)气泡袋（6）吸卡（7）吸塑（8）其他',
   PRODUCT_LENGTH       int default NULL comment '产品长度(MM)',
   PRODUCT_WIDTH        int default NULL comment '产品宽度(MM)',
   PRODUCT_HIGH         int default NULL comment '产品高度(MM)',
   PRODUCT_NET          int default NULL comment '产品重量(KGS)',
   PACKING_QUANTITY     int default NULL comment '装箱数量',
   BOX_LENGTH           int default NULL comment '箱规长度(MM)',
   BOX_WIDTH            int default NULL comment '箱规宽度(MM)',
   BOX_HIGH             int default NULL comment '箱规高度(MM)',
   BOX_NET              int default NULL comment '每箱重量(KGS)',
   primary key (ID),
   unique key unique_part_no (PART_NO, TYPE)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: T_MOTO_PRODUCT_ATTACH                                 */
/*==============================================================*/
create table T_MOTO_PRODUCT_ATTACH
(
   ID                   varchar(36) not null,
   T_MOTO_PRODUCT_ID    varchar(32) default NULL comment '主表id',
   primary key (ID),
   key t_moto_product_id (T_MOTO_PRODUCT_ID)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table T_MOTO_PRODUCT_ATTACH add constraint t_moto_product_attach_ibfk_1 foreign key (T_MOTO_PRODUCT_ID)
      references T_MOTO_PRODUCT (ID) on delete cascade;

