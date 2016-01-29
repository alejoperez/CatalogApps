package com.catalog.app.model.server;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppStoreContent  implements Serializable {

    private static final String APPS = "entry";

    @SerializedName(APPS)
    private List<AppServer> appServerList = new ArrayList<>();

    public AppStoreContent() {}

    public AppStoreContent(List<AppServer> appServerList) {
        this.appServerList = appServerList;
    }

    public List<AppServer> getAppServerList() {
        return appServerList;
    }

    public void setAppServerList(List<AppServer> appServerList) {
        this.appServerList = appServerList;
    }
}
