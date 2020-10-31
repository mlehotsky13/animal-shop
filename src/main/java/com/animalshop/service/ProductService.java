package com.animalshop.service;

import org.springframework.data.domain.Page;
import com.animalshop.exception.ProductNotFoundException;
import com.animalshop.model.Product;

/**
 * Service working with {@link Product}s
 */
public interface ProductService {

	/**
	 * Get paged products satisfying filter parameters
	 * 
	 * @param minPrice minimal price of product
	 * @param maxPrice maximal price of product
	 * @param name beginning or full name of product
	 * @param pageNumber number of page to get
	 * @param pageSize number of products per page
	 * 
	 * @return paged products
	 */
	Page<Product> getProducts(Double minPrice, Double maxPrice, String name, int pageNumber, int pageSize);

	/**
	 * Save provided product
	 * 
	 * @param product to save
	 * @return id of saved product
	 */
	String saveProduct(Product product);

	/**
	 * Get product by its id
	 * 
	 * @param id of product to get
	 * @return product
	 * @throws ProductNotFoundException if product with given id was not found
	 */
	Product getProduct(String id) throws ProductNotFoundException;
}
