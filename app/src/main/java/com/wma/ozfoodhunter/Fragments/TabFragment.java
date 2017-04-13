package com.wma.ozfoodhunter.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wma.ozfoodhunter.Adapters.Item_Adapter;
import com.wma.ozfoodhunter.Item_Detail;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.DividerItemDecoration;

import static android.R.id.list;

/**
 * Created by mathivanan on 27/09/16.
 */

public class TabFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    int index=0;
    Item_Adapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_fragment_order, container, false);

        Bundle args = getArguments();
        index = args.getInt("type", 0);

        adapter = new Item_Adapter(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Item_Adapter.OnItemClickListener(){
            public void onItemClick(View v, int position) {
                Intent in = new Intent(getActivity(), Item_Detail.class);
                startActivity(in);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Resume","----->"+"Resume Come");

        adapter.notifyDataSetChanged();


    }
}
