package com.animalshop.service;

import org.springframework.data.domain.Page;
import com.animalshop.exception.ProductNotFoundException;
import com.animalshop.model.Product;

public interface ProductService {

	Page<Product> getProducts(Double minPrice, Double maxPrice, String name, int pageNumber, int pageSize);

	String saveProduct(Product product);

	Product getProduct(String id) throws ProductNotFoundException;
}
