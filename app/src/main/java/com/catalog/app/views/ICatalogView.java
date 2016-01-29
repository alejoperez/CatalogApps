package com.catalog.app.views;

import com.catalog.app.model.client.Category;

import java.util.List;

public interface ICatalogView {
    void loadData();
    void loadUserInterface();
    void onLoadCatalogSuccess(List<Category> categoryList);
    void onLoadCatalogFail();
}
