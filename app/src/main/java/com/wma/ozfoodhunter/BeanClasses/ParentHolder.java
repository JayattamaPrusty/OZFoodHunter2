package com.wma.ozfoodhunter.BeanClasses;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.Constants;

/**
 * Created by Jayattama on 15-Mar-17.
 */
public class ParentHolder extends GroupViewHolder {

    public TextView parent_dish_name;
    public ParentHolder(View itemView) {
        super(itemView);
        parent_dish_name=(TextView)itemView.findViewById(R.id.parent_dish_name);
    }


    @Override
    public void expand() {

        parent_dish_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.collapse_arrow, 0);
        parent_dish_name.setTextColor(Color.GREEN);
        Log.i("Adapter", "expand");
    }

    @Override
    public void collapse() {
        Log.i("Adapter", "collapse");
        parent_dish_name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.expanda_rrow, 0);
        parent_dish_name.setTextColor(Color.BLACK);
    }


}


