package com.wma.ozfoodhunter.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wma.ozfoodhunter.MyCart;
import com.wma.ozfoodhunter.R;


public class FragmentCart_time extends Fragment {
    View root;
    Button done_btn;
    MyCart mc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mc = (MyCart) getActivity();
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_cart_time, container, false);
        done_btn=(Button)root.findViewById(R.id.time_done_btn);

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc.setFragment(2);
            }
        });
        return root;
    }


}
