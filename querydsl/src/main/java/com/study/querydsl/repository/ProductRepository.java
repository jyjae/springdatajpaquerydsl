package com.study.querydsl.repository;

import com.study.querydsl.domain.Product;
import com.study.querydsl.repository.support.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/*
    쿼리 메소드를 사용하면 대상 컬럼이 다르면 같은 기능이여도 메소드들을 만들어주어야하는 단점이 있다
    이를 보완하기 위해 QueryDslPredicateExecutor 를 사용
    이를 사용하면 QueryDSL을 보다 편하게 사용할 수 있지만 join이나 fetch 기능은 사용할 수 없다.
 */
public interface ProductRepository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product>, ProductRepositoryCustom {
}
