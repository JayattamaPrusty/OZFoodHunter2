package com.wma.ozfoodhunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.wma.ozfoodhunter.Adapters.PageFragmentAdapter;
import com.wma.ozfoodhunter.Fragments.TabFragment;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by mathivanan on 12/02/17.
 */

public class Restaurant_Activity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    SliderLayout mDemoSlider;
    Toolbar toolbar;
    ActionBar actionbar;
    HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
    private ViewPager viewPager;
    TabLayout tabLayout;
    public static TextView viewcart;
    PageFragmentAdapter adapter;
    String[] tabname={"tab1","tab2","tab3","tab4","tab5","tab6","tab7","tab8"};
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.restaurant);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbar.setDisplayHomeAsUpEnabled(true);

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        mDemoSlider.setVisibility(View.VISIBLE);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewcart = (TextView) findViewById(R.id.viewcart);

        viewcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Restaurant_Activity.this,MyCart.class));
            }
        });

        file_maps.put("Hannibal",R.drawable.food_banner);
        file_maps.put("Big Bang Theory",R.drawable.food_banner);
        file_maps.put("House of Cards",R.drawable.food_banner);
        file_maps.put("Game of Thrones", R.drawable.food_banner);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        setupTabClick();



        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(Restaurant_Activity.this);
            // initialize a SliderLayout
            textSliderView
//                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new PageFragmentAdapter(getSupportFragmentManager());
        for(int i=0;i<tabname.length;i++){
            Bundle bundle= new Bundle();
            bundle.putInt("type",i);
            bundle.putString("Type",tabname[i]);
            adapter.addFragment(new TabFragment(), tabname[i],bundle);
        }
        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    private void setupTabClick() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
