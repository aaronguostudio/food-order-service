package com.aaronguostudio.foodorderservice.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

  NEW(0, "new"),
  FINISHED(1, "finsihed"),
  CANCEL(2, "canceled")
  ;

  private Integer code;
  private String message;

  OrderStatusEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
