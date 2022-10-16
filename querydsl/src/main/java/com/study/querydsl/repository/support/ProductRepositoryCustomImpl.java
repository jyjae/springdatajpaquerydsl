package com.study.querydsl.repository.support;

import com.study.querydsl.domain.Product;
import com.study.querydsl.domain.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    public ProductRepositoryCustomImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> findByName(String name) {
        QProduct qProduct = QProduct.product;

        // form()이 JPAQuery 를 리턴함
        List<Product> products = from(qProduct)
                .where(qProduct.name.eq("name"))
                .select(qProduct)
                .fetch();

        return products;
    }
}
