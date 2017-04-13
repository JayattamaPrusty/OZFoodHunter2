package com.wma.ozfoodhunter.BeanClasses;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.Constants;

/**
 * Created by Jayattama on 15-Mar-17.
 */
public class ChildHolder extends ChildViewHolder {

    public TextView childdishname,childitemsize,price,child_text;
    public LinearLayout childlay;
    public ChildHolder(View itemView) {
        super(itemView);
        childdishname=(TextView)itemView.findViewById(R.id.txt1);
        childitemsize=(TextView)itemView.findViewById(R.id.txt2);
        price=(TextView)itemView.findViewById(R.id.txt3);
        child_text=(TextView)itemView.findViewById(R.id.child_text);
        childlay=(LinearLayout)itemView.findViewById(R.id.card_view);
    }


}
