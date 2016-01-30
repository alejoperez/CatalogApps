package com.catalog.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catalog.app.R;
import com.catalog.app.model.client.App;
import com.catalog.app.graphic.ScaleImageEnum;
import com.catalog.app.util.GraphicUtilities;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * ArrayAdapter responsible for showing app list for one category
 */
public class CatalogAppAdapter extends ArrayAdapter<App>{

    private List<App> appList = new ArrayList<>();
    private int imageSize;

    public CatalogAppAdapter(Context context, List<App> appList) {
        super(context, 0, appList);
        this.appList = appList;
        this.imageSize = GraphicUtilities.getImageSize(context, ScaleImageEnum.ONE);
    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public App getItem(int position) {
        return appList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.app_item, null);
            ViewHolder viewHolder = new ViewHolder(view);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(imageSize,imageSize);
            viewHolder.imageViewApp.setLayoutParams(params);
            view.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) view.getTag();

        App app = getItem(position);
        holder.textViewName.setText(app.getAppName());
        ImageLoader.getInstance().displayImage(app.getImageList().get(2).getImageUrl(), holder.imageViewApp, GraphicUtilities.getDisplayOptions());

        return view;
    }

    static class ViewHolder {

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        @Bind(R.id.App_ImageView)
        ImageView imageViewApp;

        @Bind(R.id.App_TextView_Name)
        TextView textViewName;
    }

}
