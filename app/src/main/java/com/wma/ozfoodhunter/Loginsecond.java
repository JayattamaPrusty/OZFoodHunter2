package com.wma.ozfoodhunter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Loginsecond extends Activity {

    ImageView centerleft, center, btmleft, btmright;
    private Animation animation, anim1, anim2, anim3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsecond);
        centerleft = (ImageView) findViewById(R.id.logofoodleft);
        center = (ImageView) findViewById(R.id.logofood);
        btmleft = (ImageView) findViewById(R.id.foodbottomlft);
        btmright = (ImageView) findViewById(R.id.foodbottomright);


        if (savedInstanceState == null) {
             flyIn();
//            moveViewToScreenCenter(center);
//            moveViewToScreenCenter(centerleft);
//            moveViewToScreenCenter(btmleft);
//            moveViewToScreenCenter(btmright);
        }
        endSplash();
    }

    private void endSplash() {
    }

    private void flyIn() {
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_slide_in_right);
        centerleft.startAnimation(animation);
        anim1=AnimationUtils.loadAnimation(this,R.anim.slide_in_bottom);
        btmleft.startAnimation(anim1);
        btmright.startAnimation(anim1);

        anim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {



            }

            @Override
            public void onAnimationEnd(Animation animation) {

                anim2=AnimationUtils.loadAnimation(Loginsecond.this,R.anim.shake);
                btmleft.startAnimation(anim2);
                btmright.startAnimation(anim2);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }



  /*  private void moveViewToScreenCenter(View view) {
        RelativeLayout root = (RelativeLayout) findViewById(R.id.activity_loginsecond);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int statusBarOffset = dm.heightPixels - root.getMeasuredHeight();

        int originalPos[] = new int[2];
        view.getLocationOnScreen(originalPos);

        int xDest = dm.widthPixels / 2;
        xDest -= (view.getMeasuredWidth() / 2);
        int yDest = dm.heightPixels / 2 - (view.getMeasuredHeight() / 2) - statusBarOffset;

        TranslateAnimation anim = new TranslateAnimation(0, xDest - originalPos[0], 0, yDest - originalPos[1]);
        anim.setDuration(1000);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }*/
}