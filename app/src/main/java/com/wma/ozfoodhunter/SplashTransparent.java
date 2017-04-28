package com.wma.ozfoodhunter;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class SplashTransparent extends Activity {
    private Animation animation;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_transparent);
        logo=(ImageView)findViewById(R.id.ssss);


        if (savedInstanceState == null) {
            flyIn();
        }
        endSplash();

    }

    private void flyIn() {

        animation = AnimationUtils.loadAnimation(this, R.anim.activity_open_translate_from_bottom);
        logo.startAnimation(animation);

    }

    private void endSplash() {

        animation = AnimationUtils.loadAnimation(this,
                R.anim.slide_up);
        animation.setDuration(2000);
        logo.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(),
                                Splash.class);
                        startActivity(intent);
                        finish();
                    }
                }, 3000);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            }
        });
    }
}
