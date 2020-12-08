package com.aaronguostudio.foodorderservice.service;
import com.aaronguostudio.foodorderservice.dataobject.ProductCategory;
import java.util.List;

public interface CategoryService {
  ProductCategory findOne(Integer categoryId);

  List<ProductCategory> findAll();

  List<ProductCategory> findByCategoryByTypeIn(List<Integer> categoryTypeList);

  ProductCategory save(ProductCategory productCategory);
}
