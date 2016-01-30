package com.catalog.app.model.server;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Server class representing an artist of an application in JSON server response
 */
public class AppArtist implements Serializable{

    private static final String NAME = "label";

    @SerializedName(NAME)
    private String name;

    public AppArtist() {
    }

    public AppArtist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
