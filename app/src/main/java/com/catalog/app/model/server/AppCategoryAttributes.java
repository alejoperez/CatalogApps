package com.catalog.app.model.server;

import java.io.Serializable;

public class AppCategoryAttributes implements Serializable{

    private String label;

    public AppCategoryAttributes() {
    }

    public AppCategoryAttributes(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
