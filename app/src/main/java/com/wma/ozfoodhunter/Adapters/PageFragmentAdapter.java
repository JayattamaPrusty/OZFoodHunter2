package com.wma.ozfoodhunter.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PageFragmentAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();
    private final List<Bundle> mFragmentBundles = new ArrayList<>();

    public PageFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title, Bundle bun) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
        mFragmentBundles.add(bun);
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment f = mFragments.get(position);
        f.setArguments(mFragmentBundles.get(position));
        return f;
    }


    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    public String getTitle(int position){
        return mFragmentTitles.get(position);
    }
}