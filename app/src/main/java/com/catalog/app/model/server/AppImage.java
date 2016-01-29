package com.catalog.app.model.server;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AppImage implements Serializable {

    private static final String IMAGE_URL = "label";

    @SerializedName(IMAGE_URL)
    private String imageUrl;

    public AppImage() {
    }

    public AppImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
