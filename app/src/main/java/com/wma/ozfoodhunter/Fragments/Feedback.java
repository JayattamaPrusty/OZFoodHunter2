package com.wma.ozfoodhunter.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wma.ozfoodhunter.Adapters.Item_Adapter;
import com.wma.ozfoodhunter.Item_Detail;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.DividerItemDecoration;

/**
 * Created by mathivanan on 13/02/17.
 */

public class Feedback extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.feedback, container, false);


        return view;
    }
}
