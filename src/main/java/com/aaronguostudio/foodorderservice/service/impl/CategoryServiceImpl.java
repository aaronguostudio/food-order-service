package com.aaronguostudio.foodorderservice.service.impl;

import com.aaronguostudio.foodorderservice.dataobject.ProductCategory;
import com.aaronguostudio.foodorderservice.repository.ProductCategoryRepository;
import com.aaronguostudio.foodorderservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private ProductCategoryRepository repository;

  @Override
  public ProductCategory findOne(Integer categoryId) {
    Optional<ProductCategory> p = repository.findById(categoryId);
    if (p.isPresent()) {
      return p.get();
    }
    return null;
  }

  @Override
  public List<ProductCategory> findAll() {
    return repository.findAll();
  }

  @Override
  public List<ProductCategory> findByCategoryByTypeIn(List<Integer> categoryTypeList) {
    return repository.findByCategoryTypeIn(categoryTypeList);
  }

  @Override
  public ProductCategory save(ProductCategory productCategory) {
    return repository.save(productCategory);
  }
}
