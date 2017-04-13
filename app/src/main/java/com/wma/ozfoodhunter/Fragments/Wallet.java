package com.wma.ozfoodhunter.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wma.ozfoodhunter.R;

/**
 * Created by mathivanan on 13/02/17.
 */

public class Wallet extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.deals, container, false);


        return view;
    }
}
