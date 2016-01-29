package com.catalog.app.activities;

import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.catalog.app.R;
import com.catalog.app.adapters.CatalogPagerAdapter;
import com.catalog.app.model.client.Category;
import com.catalog.app.presenters.CatalogPresenter;
import com.catalog.app.views.ICatalogView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CatalogActivity extends BaseActivity implements ICatalogView{

    @Bind(R.id.container)
    ViewPager viewPager;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private CatalogPagerAdapter catalogPagerAdapter;
    private CatalogPresenter catalogPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        loadData();
    }

    @Override
    public void loadData() {
        catalogPresenter = new CatalogPresenter(getApplicationContext(),CatalogActivity.this);
        catalogPresenter.loadCatalog();
    }

    @Override
    public void loadUserInterface(List<Category> categoryList) {
        catalogPagerAdapter = new CatalogPagerAdapter(getSupportFragmentManager(),categoryList);
        viewPager.setAdapter(catalogPagerAdapter);
    }

    @Override
    public void onLoadCatalogSuccess(List<Category> categoryList) {
        loadUserInterface(categoryList);
    }

    @Override
    public void onLoadCatalogFail() {
        //TODO: Show error
    }
}

