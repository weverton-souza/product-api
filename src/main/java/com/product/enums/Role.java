package com.product.enums;

public enum Role {
    ADM_LEV1("ADM_LEV1", "Administrative Access; Level 01."),
    USER_LEV1("USER_LEV1", "Regular user Access; Level 01.");

    private String name;
    private String description;

    Role(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
