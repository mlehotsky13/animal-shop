package com.animalshop.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import com.animalshop.controller.ProductController;
import com.animalshop.mapper.ProductMapper;
import com.animalshop.model.Product;
import com.animalshop.model.dto.ProductDto;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductDto> {

	@Autowired
	private ProductMapper productMapper;

	public ProductModelAssembler() {
		super(ProductController.class, ProductDto.class);
	}

	@Override
	public ProductDto toModel(Product product) {
		ProductDto productDto = productMapper.productToProductDto(product);
		productDto.add(linkTo(ProductController.class).slash(product.getId()).withSelfRel());

		return productDto;
	}

	@Override
	public CollectionModel<ProductDto> toCollectionModel(Iterable<? extends Product> products) {
		CollectionModel<ProductDto> productModels = super.toCollectionModel(products);
		productModels.add(linkTo(ProductController.class).withSelfRel());

		return productModels;
	}
}
