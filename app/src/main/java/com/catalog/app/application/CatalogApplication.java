package com.catalog.app.application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class CatalogApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }

}
