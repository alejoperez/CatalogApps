package com.catalog.app.model.server;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Server class representing AppStore in JSON server response
 */
public class AppStore implements Serializable {

    private static final String APP_STORE_CONTENT = "feed";

    @SerializedName(APP_STORE_CONTENT)
    AppStoreContent appStoreContent;

    public AppStore() {}

    public AppStore(AppStoreContent appStoreContent) {
        this.appStoreContent = appStoreContent;
    }

    public AppStoreContent getAppStoreContent() {
        return appStoreContent;
    }

    public void setAppStoreContent(AppStoreContent appStoreContent) {
        this.appStoreContent = appStoreContent;
    }
}
