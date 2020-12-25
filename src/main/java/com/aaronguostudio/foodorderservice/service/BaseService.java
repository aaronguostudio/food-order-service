package com.aaronguostudio.foodorderservice.service;

import java.util.List;

public interface BaseService<T, IDType> {
  T findOne(IDType id);
  List<T> findAll();
  T save(T entity);
}
