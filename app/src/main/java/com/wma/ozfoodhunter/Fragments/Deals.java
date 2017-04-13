package com.wma.ozfoodhunter.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wma.ozfoodhunter.Adapters.DealsAdapter;
import com.wma.ozfoodhunter.R;

/**
 * Created by mathivanan on 13/02/17.
 */

public class Deals extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.deals, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView_deals);
        DealsAdapter adapter = new DealsAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.notifyDataSetChanged();
        return view;
    }
}
