package com.catalog.app.model.client;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

/**
 * Client class representing an image of an application in local storage
 */
@Table(name = Image.TABLE_NAME)
public class Image extends Model implements Serializable {

    public static final String TABLE_NAME = "Image";

    public static final String APP = "App";

    @Column
    private String imageUrl;

    @Column(name = APP)
    private App app;

    public Image() {}

    public Image(String imageUrl, App app) {
        this.imageUrl = imageUrl;
        this.app = app;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }
}
