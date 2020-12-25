package com.aaronguostudio.foodorderservice.controller;

import com.aaronguostudio.foodorderservice.dataobject.ProductCategory;
import com.aaronguostudio.foodorderservice.dataobject.ProductInfo;
import com.aaronguostudio.foodorderservice.service.CategoryService;
import com.aaronguostudio.foodorderservice.service.ProductService;
import com.aaronguostudio.foodorderservice.utils.ResultVOUtil;
import com.aaronguostudio.foodorderservice.vo.ProductInfoVO;
import com.aaronguostudio.foodorderservice.vo.ProductVO;
import com.aaronguostudio.foodorderservice.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private CategoryService categoryService;

  @GetMapping("/list")
  public ResultVO list() {

    // find all products
    List<ProductInfo> productInfoList = productService.findAllInStock();

    // find all categories
    List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
    List<ProductCategory> productCategoryList = categoryService.findByCategoryByTypeIn(categoryTypeList);
    List<ProductVO> productVOList = new ArrayList<>();

    for (ProductCategory p: productCategoryList) {
      ProductVO productVO = new ProductVO();
      productVO.setCategoryType(p.getCategoryType());
      productVO.setCategoryName(p.getCategoryName());

      List<ProductInfoVO> productInfoVOList = new ArrayList<>();
      for (ProductInfo productInfo : productInfoList) {
        if (productInfo.getCategoryType().equals(p.getCategoryType())) {
          ProductInfoVO productInfoVO = new ProductInfoVO();
          BeanUtils.copyProperties(productInfo, productInfoVO);
          productInfoVOList.add(productInfoVO);
        }
      }
      productVO.setProductInfoVOList(productInfoVOList);
      productVOList.add(productVO);
    }
    return ResultVOUtil.success(productVOList);
  }
}
