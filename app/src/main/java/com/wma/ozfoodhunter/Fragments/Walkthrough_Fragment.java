package com.wma.ozfoodhunter.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wma.ozfoodhunter.Login;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Splash;
import com.wma.ozfoodhunter.Walkthrough;

/**
 * Created by mathivanan on 11/02/17.
 */

public class Walkthrough_Fragment extends Fragment {

    int index = 0;
    private TextView textView, textView1;
    ImageView imageView;
    Button skip;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View view = inflater.inflate(R.layout.intro, container, false);
        textView = (TextView) view.findViewById(R.id.headerText);
        textView1 = (TextView) view.findViewById(R.id.subText);
        imageView = (ImageView) view.findViewById(R.id.imageview);
        skip = (Button) view.findViewById(R.id.skip);
        Bundle args = getArguments();
        if (args != null) {

            index = args.getInt("index", 0);

            if (index == 0) {
                System.gc();
                imageView.setImageResource(R.drawable.walkthrough_page1);
                textView.setText("Welcome to Ozfood");
                textView1.setText("An easy way \nfor people to find boggling food from \nrestaurants around you");
            } else if (index == 1) {
                System.gc();
                imageView.setImageResource(R.drawable.walkthrough_page2);
                textView.setText("Are you hungry?");
                textView1.setText("Dont worry !!!  \nwe enlist best restaurants that titilate \nyour taste buds");
            } else if (index == 2) {
                System.gc();
                imageView.setImageResource(R.drawable.walkthrough_page3);
                textView.setText("Pick and Order");
                textView1.setText("You pick, we deliver\nPick amazing dishes and tell us where to \ndeliver");
            } else if (index == 3) {
                System.gc();
                imageView.setImageResource(R.drawable.walkthrough_page4);
                textView.setText("Grab It");
                textView1.setText("Grab it \nonce we deliver at your doorstep");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getActivity(),Login.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                }, 2000);
            }
        }

        return view;
    }

}
