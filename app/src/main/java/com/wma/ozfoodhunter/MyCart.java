package com.wma.ozfoodhunter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.wma.ozfoodhunter.Adapters.MyCartAdapter;
import com.wma.ozfoodhunter.Adapters.Restaurant_Adapter;
import com.wma.ozfoodhunter.Fragments.Cart_Address;
import com.wma.ozfoodhunter.Fragments.FragmentCart_time;
import com.wma.ozfoodhunter.Fragments.Home;
import com.wma.ozfoodhunter.Fragments.Mycart_default;
import com.wma.ozfoodhunter.Widgets.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    ViewPager viewPager;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycart);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.beginFakeDrag();
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.GRAY);
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.menu_my_cart_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.clock_icon1);
        tabLayout.getTabAt(2).setIcon(R.drawable.address_icon);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Mycart_default(),"");
        adapter.addFragment(new FragmentCart_time(),"" );
        adapter.addFragment(new Cart_Address(),"" );
        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmenttitlelist = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmenttitlelist.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
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

    public void  setFragment(int target){
        viewPager.setCurrentItem(target);
        linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setEnabled(false);
        for(int i = 0; i < linearLayout.getChildCount(); i++) {
            if(i<target){

                linearLayout.getChildAt(i).setClickable(true);
            }else {
                linearLayout.getChildAt(i).setClickable(false);

            }

            /*linearLayout.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });*/
        }
    }
}
