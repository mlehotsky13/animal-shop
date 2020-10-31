package com.animalshop.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.animalshop.exception.ProductNotFoundException;
import com.animalshop.mapper.ProductMapper;
import com.animalshop.model.Product;
import com.animalshop.model.assembler.ProductModelAssembler;
import com.animalshop.model.dto.ProductDto;
import com.animalshop.service.ProductService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private ProductModelAssembler productModelAssembler;

	@Autowired
	private PagedResourcesAssembler<Product> pagedResourcesAssembler;

	@ApiOperation("Get paged products satisfying provided filter parameters")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<PagedModel<ProductDto>> getProducts(//
			@RequestParam(required = false) Double minPrice, //
			@RequestParam(required = false) Double maxPrice, //
			@RequestParam(required = false) String name, //
			@RequestParam(defaultValue = "0") int page, //
			@RequestParam(defaultValue = "50") int size) {

		Page<Product> products = productService.getProducts(minPrice, maxPrice, name, page, size);
		PagedModel<ProductDto> collModel = pagedResourcesAssembler.toModel(products, productModelAssembler);

		return ResponseEntity.ok(collModel);
	}

	@ApiOperation("Save new product")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Product> saveProduct(@Valid @RequestBody ProductDto productDto) {
		Product product = productMapper.productDtoToProduct(productDto);
		String id = productService.saveProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();

		return ResponseEntity.created(location).build();
	}

	@ApiOperation("Get concrete product by its id")
	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ProductDto getProduct(@PathVariable String productId) throws ProductNotFoundException {
		return productMapper.productToProductDto(productService.getProduct(productId));
	}
}
