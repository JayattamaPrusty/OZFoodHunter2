package com.wma.ozfoodhunter.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.wma.ozfoodhunter.Fragments.Walkthrough_Fragment;

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public CustomPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        Walkthrough_Fragment sone = new Walkthrough_Fragment();
        Bundle args = new Bundle();
        args.putInt("index", position);
        sone.setArguments(args);

        return sone;
        //Returning the current tabs
       /* switch (position) {
            case 0:
                //ScreenOne sone = new ScreenOne();

                ScreenOne  sone = new ScreenOne();
                    Bundle args = new Bundle();
                    args.putInt("index", 0);
                    args.putSerializable("order", "One Screen 1");
                    sone.setArguments(args);

                return sone;
            case 1:
                ScreenTwo stwo = new ScreenTwo();
                return stwo;
            case 2:
                ScreenThree sthree = new ScreenThree();
                return sthree;
            default:
                return null;
        }*/
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

}
