package com.animalshop.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.animalshop.exception.ProductNotFoundException;
import com.animalshop.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public Page<Product> getProducts(Double minPrice, Double maxPrice, String name, int pageNumber, int pageSize) {
		Criteria criteria = new Criteria();

		if (minPrice != null || maxPrice != null)
			criteria.andOperator(//
					Criteria.where("price").gte(Optional.ofNullable(minPrice).orElse(Double.MIN_VALUE)), //
					Criteria.where("price").lte(Optional.ofNullable(maxPrice).orElse(Double.MAX_VALUE))//
			);

		if (name != null)
			criteria.and("name").regex("^" + name);

		long productsCount = mongoOperations.count(new Query(criteria), Product.class);

		Query query = new Query(criteria).with(PageRequest.of(pageNumber, pageSize));
		query.fields().exclude("description").exclude("gallery");
		List<Product> products = mongoOperations.find(query, Product.class);

		return new PageImpl<>(products, PageRequest.of(pageNumber, pageSize), productsCount);
	}

	@Override
	public String saveProduct(Product product) {
		mongoOperations.insert(product);
		return product.getId();
	}

	@Override
	public Product getProduct(String id) throws ProductNotFoundException {
		Product product = mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Product.class);

		if (product == null)
			throw new ProductNotFoundException(id);

		return product;
	}
}
