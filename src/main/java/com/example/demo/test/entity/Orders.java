package com.example.demo.test.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* 
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@Data
@TableName("orders")
public class Orders{
    /**
    * ID
    */
    @TableId
    private Long id;

    /**
    * 订单系统id
    */
    @TableField("order_id")
    private Long orderId;

    /**
    * 创建日期
    */
    @TableField("createdDate")
    private Date createddate;

    /**
    * 最后修改日期
    */
    @TableField("lastModifiedDate")
    private Date lastmodifieddate;

    /**
    * 版本
    */
    @TableField("version")
    private Long version;

    /**
    * 地址
    */
    @TableField("address")
    private String address;

    /**
    * 订单金额
    */
    @TableField("amount")
    private BigDecimal amount;

    /**
    * 已付金额
    */
    @TableField("amountPaid")
    private BigDecimal amountpaid;

    /**
    * 地区名称
    */
    @TableField("areaName")
    private String areaname;

    /**
    * 完成日期
    */
    @TableField("completeDate")
    private Date completedate;

    /**
    * 收货人
    */
    @TableField("consignee")
    private String consignee;

    /**
    * 优惠券折扣
    */
    @TableField("couponDiscount")
    private BigDecimal coupondiscount;

    /**
    * 兑换积分
    */
    @TableField("exchangePoint")
    private Long exchangepoint;

    /**
    * 过期时间
    */
    @TableField("expire")
    private Date expire;

    /**
    * 支付手续费
    */
    @TableField("fee")
    private BigDecimal fee;

    /**
    * 运费
    */
    @TableField("freight")
    private BigDecimal freight;

    /**
    * 内容
    */
    @TableField("invoiceContent")
    private String invoicecontent;

    /**
    * 税号
    */
    @TableField("invoiceTaxNumber")
    private String invoicetaxnumber;

    /**
    * 抬头
    */
    @TableField("invoiceTitle")
    private String invoicetitle;

    /**
    * 是否已分配库存
    */
    @TableField("isAllocatedStock")
    private Boolean isallocatedstock;

    /**
    * 是否已兑换积分
    */
    @TableField("isExchangePoint")
    private Boolean isexchangepoint;

    /**
    * 是否已评论
    */
    @TableField("isReviewed")
    private Boolean isreviewed;

    /**
    * 是否已使用优惠码
    */
    @TableField("isUseCouponCode")
    private Boolean isusecouponcode;

    /**
    * 附言
    */
    @TableField("memo")
    private String memo;

    /**
    * 调整金额
    */
    @TableField("offsetAmount")
    private BigDecimal offsetamount;

    /**
    * 支付方式名称
    */
    @TableField("paymentMethodName")
    private String paymentmethodname;

    /**
    * 支付方式类型
    */
    @TableField("paymentMethodType")
    private Integer paymentmethodtype;

    /**
    * 电话
    */
    @TableField("phone")
    private String phone;

    /**
    * 价格
    */
    @TableField("price")
    private BigDecimal price;

    /**
    * 促销折扣
    */
    @TableField("promotionDiscount")
    private BigDecimal promotiondiscount;

    /**
    * 促销名称
    */
    @TableField("promotionNames")
    private String promotionnames;

    /**
    * 数量
    */
    @TableField("quantity")
    private Integer quantity;

    /**
    * 退款金额
    */
    @TableField("refundAmount")
    private BigDecimal refundamount;

    /**
    * 已退货数量
    */
    @TableField("returnedQuantity")
    private Integer returnedquantity;

    /**
    * 赠送积分
    */
    @TableField("rewardPoint")
    private Long rewardpoint;

    /**
    * 已发货数量
    */
    @TableField("shippedQuantity")
    private Integer shippedquantity;

    /**
    * 配送方式名称
    */
    @TableField("shippingMethodName")
    private String shippingmethodname;

    /**
    * 编号
    */
    @TableField("sn")
    private String sn;

    /**
    * 状态
    */
    @TableField("status")
    private Integer status;

    /**
    * 税金
    */
    @TableField("tax")
    private BigDecimal tax;

    /**
    * 类型
    */
    @TableField("type")
    private Integer type;

    /**
    * 重量
    */
    @TableField("weight")
    private Integer weight;

    /**
    * 邮编
    */
    @TableField("zipCode")
    private String zipcode;

    /**
    * 地区
    */
    @TableField("area_id")
    private Long areaId;

    /**
    * 优惠码
    */
    @TableField("couponCode_id")
    private Long couponcodeId;

    /**
    * 会员
    */
    @TableField("member_id")
    private Long memberId;

    /**
    * 支付方式
    */
    @TableField("paymentMethod_id")
    private Long paymentmethodId;

    /**
    * 配送方式
    */
    @TableField("shippingMethod_id")
    private Long shippingmethodId;

    /**
    * 店铺
    */
    @TableField("store_id")
    private Long storeId;

    /**
    * 欠款金额
    */
    @TableField("arrears")
    private BigDecimal arrears;

    /**
    * 退款金额
    */
    @TableField("refund")
    private BigDecimal refund;

    /**
    * 包装物押金
    */
    @TableField("packing_deposit")
    private BigDecimal packingDeposit;

    /**
    * 退还包装物押金
    */
    @TableField("return_packing_deposit")
    private BigDecimal returnPackingDeposit;

    /**
    * 包装物押金状态，0未退还,1已退还,2部分退还，3押金已退
    */
    @TableField("packing_deposit_status")
    private String packingDepositStatus;

    /**
    * 开票状态，0未开票，1申报中，2已开票，9过期
    */
    @TableField("invoice_status")
    private Integer invoiceStatus;

    /**
    * 送货时间
    */
    @TableField("delivery_time")
    private Date deliveryTime;

    /**
    * 退补金额(差价)
    */
    @TableField("price_difference")
    private BigDecimal priceDifference;

    /**
    * 差异处理状态:0待处理，1待支付，2已支付，3无需要处理
    */
    @TableField("difference_status")
    private Integer differenceStatus;

    /**
    * 收货人id
    */
    @TableField("receiver_id")
    private Long receiverId;

    /**
    * 线路号
    */
    @TableField("line_number")
    private String lineNumber;

    /**
    * 门店名称
    */
    @TableField("shop_name")
    private String shopName;

    /**
    * 会员账号
    */
    @TableField("username")
    private String username;

    /**
    * 专属销售ID
    */
    @TableField("saleman_id")
    private Long salemanId;

    /**
    * 专属销售名称
    */
    @TableField("saleman_name")
    private String salemanName;

    /**
    * 赠送优惠券名称
    */
    @TableField("couponNames")
    private String couponnames;

    /**
    * 生鲜金额
    */
    @TableField("fresh_amount")
    private BigDecimal freshAmount;

    /**
    * 销售生鲜金额
    */
    @TableField("fresh_saleman_amount")
    private BigDecimal freshSalemanAmount;

    /**
    * 是否首单
    */
    @TableField("is_first")
    private Boolean isFirst;

    /**
    * 用户下单日期
    */
    @TableField("order_user_date")
    private String orderUserDate;

    /**
    * 当天下单序号
    */
    @TableField("order_sequence")
    private Integer orderSequence;

    /**
    * 附言(配送)
    */
    @TableField("delivery_memo")
    private String deliveryMemo;

}