package com.catalog.app.model.server;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppServer implements Serializable {

    private static final String APP_NAME = "im:name";
    private static final String IMAGE_LIST = "im:image";
    private static final String PRICE = "im:price";
    private static final String ARTIST = "im:artist";
    private static final String RELEASE_DATE = "im:releaseDate";


    @SerializedName(APP_NAME)
    private AppName appName;

    @SerializedName(IMAGE_LIST)
    private List<AppImage> appImageList = new ArrayList<>();

    private AppSummary summary;

    @SerializedName(PRICE)
    private AppPrice appPrice;

    @SerializedName(ARTIST)
    private AppArtist appArtist;

    private AppCategory category;

    @SerializedName(RELEASE_DATE)
    private AppReleaseDate appReleaseDate;

    public AppServer() {}

    public AppName getAppName() {
        return appName;
    }

    public void setAppName(AppName appName) {
        this.appName = appName;
    }

    public List<AppImage> getAppImageList() {
        return appImageList;
    }

    public void setAppImageList(List<AppImage> appImageList) {
        this.appImageList = appImageList;
    }

    public AppSummary getSummary() {
        return summary;
    }

    public void setSummary(AppSummary summary) {
        this.summary = summary;
    }

    public AppPrice getAppPrice() {
        return appPrice;
    }

    public void setAppPrice(AppPrice appPrice) {
        this.appPrice = appPrice;
    }

    public AppArtist getAppArtist() {
        return appArtist;
    }

    public void setAppArtist(AppArtist appArtist) {
        this.appArtist = appArtist;
    }

    public AppCategory getCategory() {
        return category;
    }

    public void setCategory(AppCategory category) {
        this.category = category;
    }

    public AppReleaseDate getAppReleaseDate() {
        return appReleaseDate;
    }

    public void setAppReleaseDate(AppReleaseDate appReleaseDate) {
        this.appReleaseDate = appReleaseDate;
    }
}
