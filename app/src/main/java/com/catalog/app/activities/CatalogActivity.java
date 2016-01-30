package com.catalog.app.activities;

import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Toast;

import com.catalog.app.R;
import com.catalog.app.adapters.CatalogPagerAdapter;
import com.catalog.app.adapters.CategorySpinnerAdapter;
import com.catalog.app.model.client.Category;
import com.catalog.app.presenters.CatalogPresenter;
import com.catalog.app.views.ICatalogView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import butterknife.OnPageChange;

/**
 * Activity responsible for displaying the top free application of AppleStore.
 * ViewPager and Spinner view contains app categories
 */
public class CatalogActivity extends BaseActivity implements ICatalogView{

    @Bind(R.id.container)
    ViewPager viewPager;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.spinner)
    Spinner spinner;

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
        CatalogPresenter catalogPresenter = new CatalogPresenter(getApplicationContext(), CatalogActivity.this);
        catalogPresenter.loadCatalog();
    }

    @Override
    public void loadUserInterface(List<Category> categoryList) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        CategorySpinnerAdapter categorySpinnerAdapter = new CategorySpinnerAdapter(this, categoryList);
        spinner.setAdapter(categorySpinnerAdapter);

        CatalogPagerAdapter catalogPagerAdapter = new CatalogPagerAdapter(getSupportFragmentManager(), categoryList);
        viewPager.setAdapter(catalogPagerAdapter);
    }

    @OnPageChange(R.id.container)
    public void onPageSelected(int position) {
        spinner.setSelection(position);
    }

    @OnItemSelected(R.id.spinner)
    public void onItemSelected(int position) {
        viewPager.setCurrentItem(position,true);
    }

    @Override
    public void onLoadCatalogSuccess(List<Category> categoryList) {
        loadUserInterface(categoryList);
    }

    @Override
    public void onLoadCatalogFail() {
        Toast.makeText(this,R.string.connection_error,Toast.LENGTH_SHORT).show();
    }
}

