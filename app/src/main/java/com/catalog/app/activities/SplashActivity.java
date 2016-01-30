package com.catalog.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.catalog.app.R;
import com.catalog.app.animation.SplashAnimation;
import com.catalog.app.views.ISplashView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements ISplashView{

    @Bind(R.id.Splash_Screen_ImageView)
    ImageView imageViewSplash;

    @Bind(R.id.Splash_Screen_TextView)
    TextView textViewSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        showSplashScreen();
    }

    private void showSplashScreen() {
        SplashAnimation splashAnimation = new SplashAnimation(this,textViewSplash,imageViewSplash);
        splashAnimation.startAnimation();
    }

    @Override
    public void goToCatalogActivity() {
        Intent i = new Intent(SplashActivity.this, CatalogActivity.class);
        startActivity(i);
        finish();
    }
}
