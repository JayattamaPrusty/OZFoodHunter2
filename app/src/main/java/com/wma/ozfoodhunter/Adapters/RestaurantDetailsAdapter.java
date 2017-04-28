package com.wma.ozfoodhunter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
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
import com.wma.ozfoodhunter.Fragments.PreferenceDialog;
import com.wma.ozfoodhunter.MyCart;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.RestarantDetails;
import com.wma.ozfoodhunter.Restaurant_ChildAdapter_Activity;
import com.wma.ozfoodhunter.Utils.AllValidation;
import com.wma.ozfoodhunter.Widgets.Constants;
import com.wma.ozfoodhunter.database.Localdb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jayattama on 15-Mar-17.
 */

public class RestaurantDetailsAdapter extends ExpandableRecyclerViewAdapter<ParentHolder, ChildHolder> implements ExpandCollapseListener {

    Context ctx;
    ExpandCollapseController expandCollapseController;
    protected ExpandableList expandableList;
    View view;
    Localdb localdb;
    ArrayList<Dishdetail>dishdetails_iteam=new ArrayList<>();



    public RestaurantDetailsAdapter(List<? extends ExpandableGroup> groups, Context ctx) {
        super(groups);
        this.ctx = ctx;
        this.expandableList = new ExpandableList(groups);
        this.expandCollapseController = new ExpandCollapseController(expandableList, this);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
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
        localdb=new Localdb(ctx);
        return new ChildHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {

       final Dishdetail dishdetail=((Dishitem)group).getItems().get(childIndex);
        String flagaddchoice=dishdetail.getFlgAddChoices();
        if(flagaddchoice.equalsIgnoreCase("0"))
        {
        holder.childdishname.setText(dishdetail.getStDishName());
        }
        else
        {
            holder.childdishname.setText(dishdetail.getStDishName()+" "+'*');
        }


        if(dishdetail.getStDishName().isEmpty())
        {
            holder.linearLayout.setVisibility(View.GONE);
            holder.child_text.setText(dishdetail.getDishDesription());

        }else
        {
            holder.linearLayout.setVisibility(View.VISIBLE);
            holder.child_text.setText(dishdetail.getDishDesription());
            holder.price.setText("$"+dishdetail.getStPrice().get(0).getMenuPrice());
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int qty=0;
                    if(
                        dishdetail.getExtrasdetail().size()>0 || dishdetail.getStPrice().size()>1){
                        Intent intent=new Intent(ctx,Restaurant_ChildAdapter_Activity.class);
                        intent.putExtra("extrasdetaillist", (Serializable) dishdetail.getExtrasdetail());
                        intent.putExtra("pricelist", (Serializable) dishdetail.getStPrice());
                        ctx.startActivity(intent);

                    }
                    else {
                        qty++;
                        localdb.insertCategory(" "," ",qty);
                        AllValidation.myToast(ctx,"dish is successfully added to cart ");
                    }

                }
            });
        }


        if(dishdetail.getDishDesription()==null || dishdetail.getDishDesription().isEmpty())
        {
            holder.child_text.setVisibility(View.GONE);
        }else
        {
            holder.child_text.setText(dishdetail.getDishDesription());
            holder.child_text.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onBindGroupViewHolder(ParentHolder holder, int flatPosition, ExpandableGroup group)
    {
        Dishitem dishitem=((Dishitem)group);
        holder.parent_dish_name.setText(dishitem.getCuisineName());

    }

}



