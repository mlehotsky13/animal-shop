package com.animalshop.model.dto;

import java.net.URL;
import java.util.List;
import org.springframework.hateoas.RepresentationModel;
import com.animalshop.cst.AnimalCategory;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto extends RepresentationModel<ProductDto> {
    protected String id;

    @NotNull
    protected String name;

    @NotNull
    protected List<AnimalCategory> categories;

    @NotNull
    protected double price;

    private String description;
    private List<URL> gallery;
}
