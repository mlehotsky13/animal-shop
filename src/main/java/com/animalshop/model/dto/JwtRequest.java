package com.animalshop.model.dto;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    @ApiModelProperty(required = true)
    @NotNull
    private String username;

    @ApiModelProperty(required = true)
    @NotNull
    private String password;
}
