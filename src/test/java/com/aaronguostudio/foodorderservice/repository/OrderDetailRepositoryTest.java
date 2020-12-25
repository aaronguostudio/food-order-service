package com.aaronguostudio.foodorderservice.repository;

import com.aaronguostudio.foodorderservice.dataobject.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDetailRepositoryTest {

  @Autowired
  private OrderDetailRepository repo;

  @Test
  void save() {
    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setOrderId("123456");
    orderDetail.setDetailId("123456");
    orderDetail.setProductId("test-1");
    orderDetail.setProductName("Test-1");
    orderDetail.setProductIcon("http://xxxx.png");
    orderDetail.setProductPrice(new BigDecimal(23.43));
    orderDetail.setProductQuantity(2);

    OrderDetail result = repo.save(orderDetail);
    assertTrue(result != null);
  }

  @Test
  void findByOrderId() {
    List<OrderDetail> result = repo.findByOrderId("123456");
    assertTrue(result.size() > 0);
  }
}