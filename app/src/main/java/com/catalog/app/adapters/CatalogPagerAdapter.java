package com.catalog.app.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.catalog.app.fragments.CategoryFragment;
import com.catalog.app.model.client.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * FragmentPagerAdapter responsible for showing app categories.
 * Each category per fragment.
 */
public class CatalogPagerAdapter extends FragmentPagerAdapter {

    private List<Category> categoryList = new ArrayList<>();

    public CatalogPagerAdapter(FragmentManager fm,List<Category> categoryList) {
        super(fm);
        this.categoryList = categoryList;
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryFragment.newInstance(categoryList.get(position));
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categoryList.get(position).getName();
    }
}
