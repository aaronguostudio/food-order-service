package com.aaronguostudio.foodorderservice.service.impl;

import com.aaronguostudio.foodorderservice.dataobject.ProductInfo;
import com.aaronguostudio.foodorderservice.enums.ProductStatusEnum;
import com.aaronguostudio.foodorderservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

  @Autowired
  private ProductService service;

  @Test
  void findAllInStock() {
    List<ProductInfo> result = service.findAllInStock();
    assertTrue(result.size() > 0, "Product info should exist");
  }

  @Test
  void findAllByPage() {
    PageRequest req = PageRequest.of(0, 1);
    Page<ProductInfo> result = service.findAll(req);
    System.out.println(result.getContent());
    assertTrue(result.getContent().size() > 0, "Product info should exist");
  }

  @Test
  void findOne() {
    ProductInfo p = service.findOne("test-1");
    assertTrue(p != null, "Product Info should exist");
  }

  @Test
  void findAll() {
    List<ProductInfo> result = service.findAll();
    assertTrue(result.size() > 0, "Product info should exist");
  }

  @Test
  void save() {
    ProductInfo productInfo = new ProductInfo();
    productInfo.setProductId("test-2");
    productInfo.setProductName("Test-2");
    productInfo.setProductPrice(new BigDecimal(1.2));
    productInfo.setProductStock(99);
    productInfo.setProductDescription("Test-desc");
    productInfo.setProductIcon("https://xxx.png");
    productInfo.setProductStatus(0);
    productInfo.setCategoryType(2);

    service.save(productInfo);
  }
}