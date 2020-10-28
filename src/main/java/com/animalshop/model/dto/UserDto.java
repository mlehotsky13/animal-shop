package com.animalshop.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
