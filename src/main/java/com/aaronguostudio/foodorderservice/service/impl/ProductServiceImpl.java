package com.aaronguostudio.foodorderservice.service.impl;

import com.aaronguostudio.foodorderservice.dataobject.ProductInfo;
import com.aaronguostudio.foodorderservice.enums.ProductStatusEnum;
import com.aaronguostudio.foodorderservice.repository.ProductInfoRepository;
import com.aaronguostudio.foodorderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductInfoRepository repo;


  @Override
  public List<ProductInfo> findAllInStock() {
    return repo.findByProductStatus(ProductStatusEnum.UP.getCode());
  }

  @Override
  public Page<ProductInfo> findAll(Pageable pageable) {
    return repo.findAll(pageable);
  }

  @Override
  public ProductInfo findOne(String productId) {
    Optional<ProductInfo> p = repo.findById(productId);
    if (p.isPresent()) {
      return p.get();
    }
    return null;
  }

  @Override
  public List<ProductInfo> findAll() {
    return repo.findAll();
  }

  @Override
  public ProductInfo save(ProductInfo entity) {
    return repo.save(entity);
  }
}
