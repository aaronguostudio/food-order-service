package com.aaronguostudio.foodorderservice.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
public class ProductInfo {

  @Id
  private String productId;
  private String productName;
  private BigDecimal productPrice;
  private Integer productStock;
  private String productDescription;
  private String productIcon;

  // 0 normal, 1 is not in stock
  private Integer productStatus;
  private Integer categoryType;
}
