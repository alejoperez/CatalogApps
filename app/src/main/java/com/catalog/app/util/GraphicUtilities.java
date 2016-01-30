package com.catalog.app.util;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.catalog.app.R;
import com.catalog.app.graphic.ScaleImageEnum;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * Class responsible for provide methods helping image management
 */
public class GraphicUtilities {

    public static DisplayImageOptions getDisplayOptions(){
        return new DisplayImageOptions.Builder()
                .showImageOnLoading(0)
                .showImageForEmptyUri(0)
                .showImageOnFail(0)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true).build();
    }

    public static int getImageSize(Context context,ScaleImageEnum scaleImageEnum) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher, options);
        return ScaleImageEnum.getScaleNumber(scaleImageEnum) * options.outHeight;
    }
}
