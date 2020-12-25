package com.aaronguostudio.foodorderservice.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
  UP(0, "In stock"),
  DOWN(1, "Not in stock")
  ;

  private Integer code;
  private String message;

  ProductStatusEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}