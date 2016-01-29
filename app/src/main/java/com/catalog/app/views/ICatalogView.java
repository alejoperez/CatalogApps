package com.catalog.app.views;

import com.catalog.app.model.client.Category;

import java.util.List;

public interface ICatalogView {
    void loadData();
    void loadUserInterface(List<Category> categoryList);
    void onLoadCatalogSuccess(List<Category> categoryList);
    void onLoadCatalogFail();
}
