package com.aaronguostudio.foodorderservice.repository;

import com.aaronguostudio.foodorderservice.dataobject.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductInfoRepositoryTest {
  @Autowired
  private ProductInfoRepository repo;

  @Test
  public void saveTest() {
    ProductInfo productInfo = new ProductInfo();
    productInfo.setProductId("test-1");
    productInfo.setProductName("Test-1");
    productInfo.setProductPrice(new BigDecimal(3.2));
    productInfo.setProductStock(199);
    productInfo.setProductDescription("Test-desc");
    productInfo.setProductIcon("https://xxx.png");
    productInfo.setProductStatus(0);
    productInfo.setCategoryType(2);

    repo.save(productInfo);
  }

  @Test
  public void findByProductTypeTest() {
    List<ProductInfo> result = repo.findByProductStatus(0);
    Assert.isTrue(result.size() == 1, "Found at least 1 item");
  }
}