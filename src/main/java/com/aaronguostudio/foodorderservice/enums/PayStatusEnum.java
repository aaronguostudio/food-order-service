package com.aaronguostudio.foodorderservice.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
  UNPAID(0, "unpaid"),
  SUCCESS(1, "paid")
  ;

  private Integer code;
  private String message;

  PayStatusEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
