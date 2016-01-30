package com.catalog.app.model.server;


import java.io.Serializable;

/**
 * Server class representing application name in JSON server response
 */
public class AppName implements Serializable {

    private String label;

    public AppName() {}

    public AppName(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
