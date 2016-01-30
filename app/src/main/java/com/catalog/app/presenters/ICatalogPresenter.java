package com.catalog.app.presenters;

import android.content.Context;

import com.catalog.app.model.client.Category;

import java.util.List;

/**
 * Catalog Presenter interface with base methods
 */
public interface ICatalogPresenter {
    void loadCatalog();
    void onLoadCatalogSuccess(List<Category> categoryList);
    void onLoadCatalogFail();
    Context getContext();
}
