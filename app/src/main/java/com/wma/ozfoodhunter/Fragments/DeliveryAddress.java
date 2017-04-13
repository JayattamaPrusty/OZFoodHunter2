package com.wma.ozfoodhunter.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.wma.ozfoodhunter.R;


public class DeliveryAddress extends Fragment implements View.OnClickListener{

    EditText edtName, edtAddress, edtLandmark, edtPincode, edtCity, edtPhoneNumber;
    TextView edtCountry;
    String access_token, flag, data,address_id;
    Spinner SpnState;
    Button btnSave, btnCancel;

    public DeliveryAddress(){

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            flag = bundle.getString("type", "");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.add_address, container, false);

        return root;

    }
    @Override
    public void onClick(View v) {

    }
}
