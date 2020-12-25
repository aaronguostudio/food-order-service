package com.aaronguostudio.foodorderservice.service;

import com.aaronguostudio.foodorderservice.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService extends BaseService<ProductInfo, String> {
  List<ProductInfo> findAllInStock();
  Page<ProductInfo> findAll(Pageable pageable);

  // add stock

  // remove stock
}
