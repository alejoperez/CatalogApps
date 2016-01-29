package com.catalog.app.interactors;

import android.content.Context;

import com.catalog.app.model.client.Category;
import com.catalog.app.presenters.ICatalogPresenter;

import java.util.List;

public interface ICatalogInteractor {
    void loadCatalog(Context context,ICatalogPresenter catalogPresenter);
    boolean isCatalogInLocalStorage();
    List<Category> getCatalogFromLocalStorage();
    void loadCatalogFromServer(Context context,ICatalogPresenter catalogPresenter);
}
