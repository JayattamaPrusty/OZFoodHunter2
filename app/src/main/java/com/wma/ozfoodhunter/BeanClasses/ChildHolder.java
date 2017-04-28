package com.wma.ozfoodhunter.BeanClasses;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.RestarantDetails;
import com.wma.ozfoodhunter.Widgets.Constants;

/**
 * Created by Jayattama on 15-Mar-17.
 */
public class ChildHolder extends ChildViewHolder {

    public TextView childdishname,child_text,childspecial,price;

    public RecyclerView pricerecycle;
    public LinearLayout linearLayout;
    public ChildHolder(View itemView) {
        super(itemView);
        childdishname=(TextView)itemView.findViewById(R.id.txt1);
        child_text=(TextView)itemView.findViewById(R.id.child_text);
        price=(TextView)itemView.findViewById(R.id.txt3);
 //       childspecial=(TextView)itemView.findViewById(R.id.child_text1);
        linearLayout=(LinearLayout)itemView.findViewById(R.id.card_view);
//        pricerecycle=(RecyclerView)itemView.findViewById(R.id.pricerecyclerview);
    }


}
