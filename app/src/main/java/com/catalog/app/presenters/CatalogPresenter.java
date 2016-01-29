package com.catalog.app.presenters;

import android.content.Context;

import com.catalog.app.interactors.CatalogInteractor;
import com.catalog.app.model.client.Category;
import com.catalog.app.views.ICatalogView;

import java.util.List;

public class CatalogPresenter implements ICatalogPresenter{

    private Context context;
    private ICatalogView catalogView;
    private CatalogInteractor catalogInteractor;

    public CatalogPresenter(Context context,ICatalogView catalogView) {
        this.context = context;
        this.catalogView = catalogView;
        this.catalogInteractor =  new CatalogInteractor();
    }

    @Override
    public void loadCatalog() {
        catalogInteractor.loadCatalog(context,CatalogPresenter.this);
    }

    @Override
    public void onLoadCatalogSuccess(List<Category> categoryList) {
        catalogView.onLoadCatalogSuccess(categoryList);
    }

    @Override
    public void onLoadCatalogFail() {
        catalogView.onLoadCatalogFail();
    }

    @Override
    public Context getContext() {
        return context;
    }
}
