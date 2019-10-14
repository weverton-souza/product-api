package com.product.dto;

import com.product.abstracts.AbstractDataTransferObject;
import org.springframework.data.mongodb.core.mapping.Document;

public class CategoryDTO extends AbstractDataTransferObject {
    private String name;
    private String description;

    public CategoryDTO() {}

    public String getName() {
        return name;
    }

    public CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
