package com.study.querydsl.repository.support;

import com.study.querydsl.domain.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByName(String name);
}
