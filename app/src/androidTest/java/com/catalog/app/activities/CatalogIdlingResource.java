package com.catalog.app.activities;

import android.support.test.espresso.IdlingResource;

public class CatalogIdlingResource implements IdlingResource {

    ResourceCallback resourceCallback;
    CatalogActivity catalogActivity;

    public CatalogIdlingResource(CatalogActivity catalogActivity) {
        this.catalogActivity = catalogActivity;
    }

    @Override
    public String getName() {
        return CatalogIdlingResource.class.getName();
    }

    @Override
    public boolean isIdleNow() {
        boolean idle = isCatalogReady();
        if (idle && resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }
        return idle;
    }

    private boolean isCatalogReady() {
        return catalogActivity.viewPager != null
            && catalogActivity.viewPager.getAdapter() != null
            && catalogActivity.viewPager.getAdapter().getCount() > 0;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.resourceCallback = callback;
    }
}
