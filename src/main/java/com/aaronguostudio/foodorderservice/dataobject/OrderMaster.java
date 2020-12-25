package com.aaronguostudio.foodorderservice.dataobject;

import com.aaronguostudio.foodorderservice.enums.OrderStatusEnum;
import com.aaronguostudio.foodorderservice.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class OrderMaster {

  @Id
  private String orderId;
  private String buyerName;
  private String buyerPhone;
  private String buyerAddress;
  private String buyerOpenid;
  private BigDecimal orderAmount;

  // default is new
  private Integer orderStatus = OrderStatusEnum.NEW.getCode();

  // default is 0 unpaid
  private Integer payStatus = PayStatusEnum.UNPAID.getCode();

  private Date createTime;
  private Date updateTime;
}
