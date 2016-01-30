package com.catalog.app.model.server;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Server class representing a category in JSON server response
 */
public class AppCategory implements Serializable{

    private static final String ATTRIBUTES = "attributes";

    @SerializedName(ATTRIBUTES)
    private AppCategoryAttributes categoryAttributes;

    public AppCategory() {
    }

    public AppCategory(AppCategoryAttributes categoryAttributes) {
        this.categoryAttributes = categoryAttributes;
    }

    public AppCategoryAttributes getCategoryAttributes() {
        return categoryAttributes;
    }

    public void setCategoryAttributes(AppCategoryAttributes categoryAttributes) {
        this.categoryAttributes = categoryAttributes;
    }
}
