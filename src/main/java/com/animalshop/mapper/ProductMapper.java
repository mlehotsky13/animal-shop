package com.animalshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.animalshop.model.Product;
import com.animalshop.model.dto.ProductDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

	ProductDto productToProductDto(Product product);

	Product productDtoToProduct(ProductDto productDto);
}
