package com.aaronguostudio.foodorderservice.repository;

import com.aaronguostudio.foodorderservice.dataobject.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OrderMasterRepositoryTest {

  @Autowired
  private OrderMasterRepository repo;

  private final String OPENID = "123456";

  @Test
  public void save() {
    OrderMaster orderMaster = new OrderMaster();
    orderMaster.setOrderId("123456");
    orderMaster.setBuyerName("Aaron");
    orderMaster.setBuyerPhone("131213");
    orderMaster.setBuyerOpenid(OPENID);
    orderMaster.setBuyerAddress("Test");
    orderMaster.setOrderAmount(new BigDecimal(11.22));
    OrderMaster result = repo.save(orderMaster);
    assertTrue(result != null);
  }

  @Test
  public void findByBuyerOpenid() {
    Page<OrderMaster> result = repo.findByBuyerOpenid(OPENID, PageRequest.of(0, 1));
    System.out.println(result.getContent());
    assertTrue(result.hasContent());
  }
}