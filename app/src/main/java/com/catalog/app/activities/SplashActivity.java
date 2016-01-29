package com.catalog.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;

import com.catalog.app.R;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_LENGTH = 2500; // in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        showSplashScreen();
    }

    private void showSplashScreen() {
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        goToCatalogActivity();
                    }
                },
                SPLASH_DISPLAY_LENGTH
        );
    }

    private void goToCatalogActivity() {
        Intent i = new Intent(SplashActivity.this, CatalogActivity.class);
        startActivity(i);
        finish();
    }
}
