package com.wma.ozfoodhunter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wma.ozfoodhunter.Adapters.CustomPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by mathivanan on 10/02/17.
 */

public class Walkthrough extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator indicator;
    Button skip;
    int count = 0;
    Timer timer;

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.walkthrough);

        skip = (Button) findViewById(R.id.skip);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);

        viewPager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager(), 4));
        indicator.setViewPager(viewPager);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Walkthrough.this,Login.class));
                Walkthrough.this.finish();
            }
        });


        viewPager.setCurrentItem(0);
        // Timer for auto sliding
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(count<=5){
                            viewPager.setCurrentItem(count);
                            count++;
                        }else{
                            count = 0;
                            viewPager.setCurrentItem(count);
                        }
                    }
                });
            }
        }, 500, 1000);
    }

}
