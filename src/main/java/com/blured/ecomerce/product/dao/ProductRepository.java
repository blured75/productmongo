package com.blured.ecomerce.product.dao;

import com.blured.ecomerce.product.domain.entity.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Cacheable("productsByCategoryCache")
    List<Product> findByCatId(int catId);

    @CacheEvict(cacheNames = "productsByCategoryCache", key="#result?.catId")
    Product save(Product product);

    @CacheEvict(cacheNames = "productsByCategoryCache", key="#p0.catId")
    void delete(Product product);
}
