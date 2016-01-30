package com.catalog.app.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.catalog.app.R;
import com.catalog.app.model.client.Category;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * ArrayAdapter for Spinner in CatalogActivity Action Bar. It displays all app categories.
 */
public class CategorySpinnerAdapter extends ArrayAdapter<Category> implements ThemedSpinnerAdapter {

    private Helper dropDownHelper;

    public CategorySpinnerAdapter(Context context, List<Category> categoryList) {
        super(context, R.layout.spinner_item, categoryList);
        this.dropDownHelper = new Helper(context);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = dropDownHelper.getDropDownViewInflater();
            view = inflater.inflate(R.layout.spinner_category_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) view.getTag();

        Category category = getItem(position);
        holder.textViewCategory.setText(category.getName());

        return view;
    }

    static class ViewHolder {

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @Bind(android.R.id.text1)
        TextView textViewCategory;
    }

    @Override
    public Resources.Theme getDropDownViewTheme() {
        return dropDownHelper.getDropDownViewTheme();
    }

    @Override
    public void setDropDownViewTheme(Resources.Theme theme) {
        dropDownHelper.setDropDownViewTheme(theme);
    }
}
