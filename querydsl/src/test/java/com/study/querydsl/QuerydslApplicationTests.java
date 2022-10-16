package com.study.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import com.study.querydsl.domain.Product;
import com.study.querydsl.domain.QProduct;
import com.study.querydsl.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import com.querydsl.core.types.Predicate;


@SpringBootTest
class QuerydslApplicationTests {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private ProductRepository productRepository;

//	@Autowired
//	private ProductSupportRepository productRepositorySupport;

	@Test
	void queryDslTest() {
		JPAQuery<Product> query = new JPAQuery(entityManager);
		QProduct qProduct = QProduct.product;

		List<Product> productList = query
				.from(qProduct)
				.where(qProduct.name.eq("펜"))
				.orderBy(qProduct.price.asc())
				.fetch();

		for(Product product : productList) {
			System.out.println("name: "+product.getName());
			System.out.println("price: "+product.getPrice());
		}
	}

	@Test
	void queryDslPredicateExeTest() {
		// Predicate는 간단하게 표현식으로 정의하는 쿼리로 생각하면 된다.
		Predicate predicate = QProduct.product.name.containsIgnoreCase("펜")
				.and(QProduct.product.price.between(1000, 2500));

		Optional<Product> foundProduct = productRepository.findOne(predicate);

		if(foundProduct.isPresent()) {
			Product product = foundProduct.get();
			System.out.println(product.getName());
			System.out.println(product.getPrice());
		}

	}

	@Test
	void queryDslSupportTest() {
		List<Product> products = productRepository.findByName("펜");

		for(Product product : products) {
			System.out.println(product.getName());
			System.out.println(product.getPrice());
		}
	}

}
