package com.catalog.app.activities;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.catalog.app.R;
import com.catalog.app.adapters.CatalogPagerAdapter;
import com.catalog.app.model.client.App;
import com.catalog.app.model.client.Category;
import com.catalog.app.model.client.Image;
import com.catalog.app.presenters.CatalogPresenter;
import com.catalog.app.views.ICatalogView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CatalogActivity extends AppCompatActivity implements ICatalogView{

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
        loadUserInterface();
    }

    @Override
    public void loadData() {
        catalogPresenter = new CatalogPresenter(getApplicationContext(),CatalogActivity.this);
        catalogPresenter.loadCatalog();
    }

    @Override
    public void loadUserInterface() {
        catalogPagerAdapter = new CatalogPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(catalogPagerAdapter);
    }

    @Override
    public void onLoadCatalogSuccess(List<Category> categoryList) {
        for(Category c:categoryList){
            List<App> appList = c.getAppList();
            for(App app:appList){
                List<Image> imageList = app.getImageList();
                int y = 0;
                int r = y +2;
            }
        }
    }

    @Override
    public void onLoadCatalogFail() {
        //TODO: Show error
    }
}

