package com.aaronguostudio.foodorderservice.service.impl;

import com.aaronguostudio.foodorderservice.dataobject.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CategoryServiceImplTest {

  @Autowired
  private CategoryServiceImpl categoryService;

  @Test
  public void findOneTest () {
    ProductCategory p = categoryService.findOne(2);
    System.out.println(p.toString());
    Assert.notNull(p, "is not null");
  }

  @Test
  public void findAllTest () {
    List<ProductCategory> result = categoryService.findAll();
    System.out.println(result.size());
    Assert.isTrue(result.size() > 0, "size is larger than 0");
  }

  @Test
  public void findByCategoryByTypeInTest () {
    List<Integer> list = Arrays.asList(1, 2, 3);
    List<ProductCategory> result = categoryService.findByCategoryByTypeIn(list);
    System.out.println(result.size());
    Assert.isTrue(result.size() > 0, "size is larger than 0");
  }

  @Test
  @Transactional
  public void saveTest () {
    ProductCategory p = categoryService.findOne(6);
    if (p != null) {
      p.setCategoryName("Test Save");
      categoryService.save(p);
    }
  }
}