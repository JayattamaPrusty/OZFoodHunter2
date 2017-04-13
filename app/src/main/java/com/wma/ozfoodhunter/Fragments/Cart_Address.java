package com.wma.ozfoodhunter.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wma.ozfoodhunter.Address_list;
import com.wma.ozfoodhunter.MyCart;
import com.wma.ozfoodhunter.R;


public class Cart_Address extends Fragment {

    Button address_done_btn;
    TextView add_address;
    MyCart mc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mc = (MyCart) getActivity();
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_cart__address, container, false);
        address_done_btn=(Button)root.findViewById(R.id.address_done_btn);
        add_address=(TextView) root.findViewById(R.id.add_address);
        address_done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mc, Address_list.class));
            }
        });
        return root;
    }


}
