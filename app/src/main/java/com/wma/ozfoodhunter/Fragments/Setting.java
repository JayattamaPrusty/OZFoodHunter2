package com.wma.ozfoodhunter.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.TermsActivity;


public class Setting extends Fragment implements View.OnClickListener{
    View view;
    RelativeLayout chngpw,notification,help,terms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_setting, container, false);
        chngpw=(RelativeLayout)view.findViewById(R.id.changepw);
        notification=(RelativeLayout)view.findViewById(R.id.notification);
        help=(RelativeLayout)view.findViewById(R.id.help);
        terms=(RelativeLayout)view.findViewById(R.id.terms);
        chngpw.setOnClickListener(this);
        notification.setOnClickListener(this);
        help.setOnClickListener(this);
        terms.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.changepw:
                break;
            case R.id.notification:
                break;
            case R.id.help:
                break;
            case R.id.terms:
                Intent in=new Intent(getActivity(), TermsActivity.class);
                startActivity(in);
                break;
        }

    }
}
