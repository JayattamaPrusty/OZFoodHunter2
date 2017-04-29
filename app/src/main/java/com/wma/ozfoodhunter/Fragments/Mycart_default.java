package com.wma.ozfoodhunter.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wma.ozfoodhunter.Adapters.MyCartAdapter;
import com.wma.ozfoodhunter.BeanClasses.Cart_Model;
import com.wma.ozfoodhunter.MyCart;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.DividerItemDecoration;
import com.wma.ozfoodhunter.database.Localdb;

import java.util.ArrayList;
import java.util.List;

public class Mycart_default extends Fragment {
    View root;
    RecyclerView recyclerView;
    MyCartAdapter myCartAdapter;
    LinearLayoutManager lm;
    Button addcart;
    TextView edit;
    int type=0;
    MyCart mc;
    TextView additem;
    Localdb db;
    List<Cart_Model.Cart_Details> cd = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mc = (MyCart) getActivity();
        db = new Localdb(mc);
        cd = db.getCart_Details();
        root= inflater.inflate(R.layout.fragment_mycart_default, container, false);
        edit=(TextView)root.findViewById(R.id.edit);
        edit.setVisibility(View.GONE);
        addcart=(Button)root.findViewById(R.id.addcart);
        additem=(TextView)root.findViewById(R.id.additem);
        recyclerView=(RecyclerView)root.findViewById(R.id.cartlistItems);
        lm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        myCartAdapter = new MyCartAdapter(getActivity(),cd);
        recyclerView.setAdapter(myCartAdapter);
        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc.setFragment(1);
            }
        });

        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return root;
    }


}
