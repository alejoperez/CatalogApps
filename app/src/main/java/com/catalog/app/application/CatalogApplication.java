package com.catalog.app.application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class CatalogApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

}
