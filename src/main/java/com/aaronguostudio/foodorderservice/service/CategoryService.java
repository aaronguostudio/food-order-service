package com.aaronguostudio.foodorderservice.service;
import com.aaronguostudio.foodorderservice.dataobject.ProductCategory;
import java.util.List;

public interface CategoryService extends BaseService<ProductCategory, Integer> {
  List<ProductCategory> findByCategoryByTypeIn(List<Integer> categoryTypeList);
}
