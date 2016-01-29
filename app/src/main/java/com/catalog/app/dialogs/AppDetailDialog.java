package com.catalog.app.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.catalog.app.R;
import com.catalog.app.graphic.ScaleImageEnum;
import com.catalog.app.model.client.App;
import com.catalog.app.util.GraphicUtilities;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppDetailDialog {

    private Context context;
    private Dialog dialog;
    private App app;
    private int imageSize;

    @Bind(R.id.App_Detail_Dialog_ImageView)
    ImageView imageViewApp;

    @Bind(R.id.App_Detail_Dialog_TextView_Name)
    TextView textViewName;

    @Bind(R.id.App_Detail_Dialog_TextView_Summary)
    TextView textViewSummary;

    @Bind(R.id.App_Detail_Dialog_Button_Buy)
    Button buttonBuy;

    public AppDetailDialog(Context context,App app) {
        this.context = context;
        this.app = app;
        this.imageSize = GraphicUtilities.getImageSize(context, ScaleImageEnum.TWO);
    }

    public void showAppDetailDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_app_detail, null);
        ButterKnife.bind(this, view);

        builder.setIcon(R.mipmap.ic_launcher);
        builder.setView(view);

        dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(imageSize,imageSize);
        imageViewApp.setLayoutParams(params);
        ImageLoader.getInstance().displayImage(app.getImageList().get(1).getImageUrl(), imageViewApp, GraphicUtilities.getDisplayOptions());

        textViewName.setText(app.getAppName());
        textViewSummary.setText(app.getSummary());

        buttonBuy.setText(app.getPrice());

        dialog.show();
    }

    @OnClick({R.id.App_Detail_Dialog_Button_Buy, R.id.App_Detail_Dialog_Button_Close})
    public void closeDialog(){
        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

}
