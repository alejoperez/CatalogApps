package com.catalog.app.model.server;

import java.io.Serializable;

public class AppReleaseDateAttributes implements Serializable{

    private String label;

    public AppReleaseDateAttributes() {
    }

    public AppReleaseDateAttributes(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
