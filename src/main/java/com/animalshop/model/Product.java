package com.animalshop.model;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import com.animalshop.cst.AnimalCategory;
import lombok.Getter;
import lombok.Setter;

@Document("products")
@Getter
@Setter
public class Product {

	@Id
	private String id;
	private String name;
	private List<AnimalCategory> categories;
	private double price;
	private String description;
	private List<URL> gallery;

	@CreatedDate
	private LocalDateTime created;

	@LastModifiedDate
	private LocalDateTime modified;
}
