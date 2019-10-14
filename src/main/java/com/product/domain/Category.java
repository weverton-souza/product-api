package com.product.domain;

import com.product.abstracts.AbstractDomain;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category extends AbstractDomain {
    private String name;
    private String description;

    public Category() {}

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
