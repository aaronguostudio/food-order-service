package com.aaronguostudio.foodorderservice.repository;

import com.aaronguostudio.foodorderservice.dataobject.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repo;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> c1 = repo.findById(1);
        System.out.println(c1.get().getCategoryName());

        Optional<ProductCategory> c2 = repo.findById(2);
        System.out.println(c2.get().getCategoryName());
    }

    @Test
    @Transactional // rollback test data
    public void saveTest() {
        ProductCategory result = repo.save(new ProductCategory("Test", 7));
        Assert.notNull(result, "is not null");
    }

    @Test
    public void updateTest() {
        Optional<ProductCategory> c = repo.findById(3);
        if (c.isPresent()) {
            c.get().setCategoryName("Trend");
            repo.save(c.get());
        }
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        repo.findByCategoryTypeIn(list);
        Assert.isTrue(list.size() > 0, "should return some items");
    }
}