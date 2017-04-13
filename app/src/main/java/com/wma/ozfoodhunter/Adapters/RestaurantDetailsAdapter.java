package com.wma.ozfoodhunter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.ExpandCollapseController;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.listeners.ExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableList;
import com.wma.ozfoodhunter.BeanClasses.ChildDish;
import com.wma.ozfoodhunter.BeanClasses.ChildHolder;
import com.wma.ozfoodhunter.BeanClasses.Dishdetail;
import com.wma.ozfoodhunter.BeanClasses.Dishitem;
import com.wma.ozfoodhunter.BeanClasses.ParentDish;
import com.wma.ozfoodhunter.BeanClasses.ParentHolder;
import com.wma.ozfoodhunter.BeanClasses.Restaurant_Dish_Model;
import com.wma.ozfoodhunter.MyCart;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.RestarantDetails;
import com.wma.ozfoodhunter.Restaurant_ChildAdapter_Activity;
import com.wma.ozfoodhunter.Widgets.Constants;

import java.util.List;

/**
 * Created by Jayattama on 15-Mar-17.
 */

public class RestaurantDetailsAdapter extends ExpandableRecyclerViewAdapter<ParentHolder, ChildHolder> implements ExpandCollapseListener {

    Context ctx;
    ExpandCollapseController expandCollapseController;
    protected ExpandableList expandableList;
    View view;



    public RestaurantDetailsAdapter(List<? extends ExpandableGroup> groups, Context ctx) {
        super(groups);
        this.ctx = ctx;
        this.expandableList = new ExpandableList(groups);
        this.expandCollapseController = new ExpandCollapseController(expandableList, this);
    }

    @Override

    public ParentHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.parent_dishes, parent, false);

        return new ParentHolder(view);

    }

    @Override
    public ChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.child_dishes, parent, false);
        return new ChildHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

//       final ChildDish childDish = ((ParentDish) group).getItems().get(childIndex);
//        String c= Constants.cuisines[childIndex];
       final Dishdetail dishdetail=((Dishitem)group).getItems().get(childIndex);


        holder.childdishname.setText(dishdetail.getStDishName());
        if(dishdetail.getStDishName().isEmpty())
        {
            holder.childlay.setVisibility(View.GONE);
        }else{
            holder.childlay.setVisibility(View.VISIBLE);

        }
        try {
            holder.childitemsize.setText(dishdetail.getStPrice().get(0).getPriceItem());
            holder.price.setText(" $ " + dishdetail.getStPrice().get(0).getMenuPrice());

        }catch (Exception e){}
        if(dishdetail.getDishDesription()==null || dishdetail.getDishDesription().isEmpty())
        {
            holder.child_text.setVisibility(View.GONE);
        }else
        {
            holder.child_text.setText(dishdetail.getDishDesription());
            holder.child_text.setVisibility(View.VISIBLE);
        }

        holder.childlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ctx.startActivity(new Intent(ctx, MyCart.class) );
            }
        });

    }

    @Override
    public void onBindGroupViewHolder(ParentHolder holder, int flatPosition, ExpandableGroup group) {

//        String c= Constants.cuisines[flatPosition];
//        holder.parent_dish_name.setText(c);
        Dishitem dishitem=((Dishitem)group);
        holder.parent_dish_name.setText(dishitem.getCuisineName());

    }

}



