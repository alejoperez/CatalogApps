package com.catalog.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.catalog.app.R;
import com.catalog.app.adapters.CatalogAppAdapter;
import com.catalog.app.dialogs.AppDetailDialog;
import com.catalog.app.model.client.App;
import com.catalog.app.model.client.Category;
import com.nhaarman.listviewanimations.appearance.AnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class CategoryFragment extends Fragment {

    private static final String CATEGORY = "category";

    @Bind(R.id.Catalog_GridView_Apps)
    GridView gridViewApps;

    private CatalogAppAdapter catalogAppAdapter;
    private Category category;

    public CategoryFragment() {}

    public static CategoryFragment newInstance(Category category) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putSerializable(CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        loadData();
        return view;
    }

    private void loadData() {
        category = (Category) getArguments().getSerializable(CATEGORY);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadUserInterface();
        showGridViewAnimation();
    }

    private void loadUserInterface() {
        catalogAppAdapter = new CatalogAppAdapter(getActivity(), category.getAppList());
        gridViewApps.setAdapter(catalogAppAdapter);
        showGridViewAnimation();
    }

    private void showGridViewAnimation() {
        AnimationAdapter animationAdapter = new SwingBottomInAnimationAdapter(catalogAppAdapter);
        animationAdapter.setAbsListView(gridViewApps);
        gridViewApps.setAdapter(animationAdapter);
    }

    @OnItemClick(R.id.Catalog_GridView_Apps)
    public void onItemSelected(int position) {
        App app = catalogAppAdapter.getItem(position);
        AppDetailDialog appDetailDialog = new AppDetailDialog(getActivity(),app);
        appDetailDialog.showAppDetailDialog();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
