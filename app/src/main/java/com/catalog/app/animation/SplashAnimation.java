package com.catalog.app.animation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.catalog.app.views.ISplashView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;

/**
 * SplashAnimation in SplashActivity
 */
public class SplashAnimation {

    private static final long SPLASH_IMAGE_VIEW_ANIMATION = 3000; // in milliseconds
    private static final long SPLASH_TEXT_VIEW_ANIMATION = 3000; // in milliseconds

    ISplashView splashView;
    TextView textViewSplash;
    ImageView imageViewSplash;

    public SplashAnimation(ISplashView splashView, TextView textViewSplash, ImageView imageViewSplash) {
        this.splashView = splashView;
        this.textViewSplash = textViewSplash;
        this.imageViewSplash = imageViewSplash;
    }

    public void startAnimation(){
        animateImageViewSplashScreen();
    }

    private void animateImageViewSplashScreen() {
        YoYo.with(Techniques.ZoomInUp)
                .duration(SPLASH_IMAGE_VIEW_ANIMATION)
                .interpolate(new AccelerateDecelerateInterpolator())
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        imageViewSplash.setVisibility(ImageView.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animateTextViewSplashScreen();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {}

                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                })
                .playOn(imageViewSplash);
    }

    private void animateTextViewSplashScreen() {
        YoYo.with(Techniques.DropOut)
                .duration(SPLASH_TEXT_VIEW_ANIMATION)
                .interpolate(new AccelerateDecelerateInterpolator())
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        textViewSplash.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        splashView.goToCatalogActivity();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {}

                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                })
                .playOn(textViewSplash);
    }

}