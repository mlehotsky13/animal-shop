package com.animalshop.cst;

import lombok.Getter;

@Getter
public enum AnimalCategory {

    DOGS("dogs"), CATS("cats"), OTHER("other");

    private String categoryName;

    private AnimalCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}
