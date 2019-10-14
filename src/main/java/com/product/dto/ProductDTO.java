package com.product.dto;

import com.product.abstracts.AbstractDataTransferObject;
import com.product.abstracts.AbstractDomain;
import com.product.domain.Category;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

public class ProductDTO extends AbstractDataTransferObject {
    private String name;
    private String description;
    private Double price;
    private Category category;

    public ProductDTO() {}

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ProductDTO setCategory(Category category) {
        this.category = category;
        return this;
    }
}
