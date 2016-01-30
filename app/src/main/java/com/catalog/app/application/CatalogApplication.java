package com.catalog.app.application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.catalog.app.R;
import com.catalog.app.graphic.TextStyleList;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class CatalogApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath(TextStyleList.OPEN_SANS_REGULAR)
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }

}
