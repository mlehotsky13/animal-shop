package com.animalshop.model.dto;

import java.net.URL;
import java.util.List;
import org.springframework.hateoas.RepresentationModel;
import com.animalshop.cst.AnimalCategory;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto extends RepresentationModel<ProductDto> {
    protected String id;

    @ApiModelProperty(required = true)
    @NotNull
    protected String name;

    @ApiModelProperty(required = true)
    @NotNull
    protected List<AnimalCategory> categories;

    @ApiModelProperty(required = true)
    @NotNull
    protected double price;

    private String description;
    private List<URL> gallery;
}
