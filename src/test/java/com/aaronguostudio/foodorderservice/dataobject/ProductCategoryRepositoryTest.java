package com.aaronguostudio.foodorderservice.dataobject;

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
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> c1 = repository.findById(1);
        System.out.println(c1.get().getCategoryName());

        Optional<ProductCategory> c2 = repository.findById(2);
        System.out.println(c2.get().getCategoryName());
    }

    @Test
    @Transactional // rollback test data
    public void saveTest() {
        ProductCategory result = repository.save(new ProductCategory("Test", 7));
        Assert.notNull(result, "is not null");
    }

    @Test
    public void updateTest() {
        Optional<ProductCategory> c = repository.findById(3);
        if (c.isPresent()) {
            c.get().setCategoryName("Trend");
            repository.save(c.get());
        }
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        repository.findByCategoryTypeIn(list);
        Assert.isTrue(list.size() > 0, "should return some items");
    }
}