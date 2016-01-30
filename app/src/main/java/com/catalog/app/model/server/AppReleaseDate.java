package com.catalog.app.model.server;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Server class representing application release date in JSON server response
 */
public class AppReleaseDate implements Serializable{

    private static final String ATTRIBUTES = "attributes";
    
    @SerializedName(ATTRIBUTES)
    private AppReleaseDateAttributes appReleaseDateAttributes;

    public AppReleaseDate() {
    }

    public AppReleaseDate(AppReleaseDateAttributes appReleaseDateAttributes) {
        this.appReleaseDateAttributes = appReleaseDateAttributes;
    }

    public AppReleaseDateAttributes getAppReleaseDateAttributes() {
        return appReleaseDateAttributes;
    }

    public void setAppReleaseDateAttributes(AppReleaseDateAttributes appReleaseDateAttributes) {
        this.appReleaseDateAttributes = appReleaseDateAttributes;
    }
}
