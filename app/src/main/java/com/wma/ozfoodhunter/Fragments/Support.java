package com.wma.ozfoodhunter.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wma.ozfoodhunter.R;

/**
 * Created by mathivanan on 13/02/17.
 */

public class Support extends Fragment {
    View view;
    TextView call_number;
    Button call_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.support, container, false);
        call_number=(TextView)view.findViewById(R.id.call_no);
        call_btn=(Button) view.findViewById(R.id.call_btn);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
