package com.wma.ozfoodhunter.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter;
import com.wma.ozfoodhunter.BeanClasses.Extrasdetail;
import com.wma.ozfoodhunter.BeanClasses.RestaurantItemBeans;
import com.wma.ozfoodhunter.R;
import com.wma.ozfoodhunter.Widgets.Constants;

import java.util.ArrayList;

/**
 * Created by Jayattama on 16-Mar-17.
 */

public class RestaurantSectionAdapter extends SectionedRecyclerViewAdapter<RecyclerView.ViewHolder> {


    public LocalBroadcastManager broadcaster;
    private ArrayList<Extrasdetail> itemlist;

    String listType="";
    private Context ctx;
    Activity activity;
    float total=0;
    String totalprice;
    private  RadioButton lastCheckedRB = null;

    public RestaurantSectionAdapter(Context context, ArrayList<Extrasdetail> itemlist) {
        this.itemlist = itemlist;
        ctx = context;
        this.listType = listType;
        this.activity=(Activity)ctx;
        broadcaster = LocalBroadcastManager.getInstance(context);
    }


    @Override
    public int getSectionCount() {
        return itemlist.size();
    }

    @Override
    public int getItemCount(int section) {

        return itemlist.get(section).getExtras().size();

    }


    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int section) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
   //     String c= Constants.cuisines[section];
        itemViewHolder.titlesection.setText(itemlist.get(section).getType());
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int section, final int relativePosition, int absolutePosition) {

        final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        //       String c= Constants.cuisines[relativePosition];
        String flag_mandatory = itemlist.get(section).getFlgMandatory();
        if (flag_mandatory.equalsIgnoreCase("1"))
        {

            itemViewHolder.radiobtnlay.setVisibility(View.VISIBLE);
            itemViewHolder.checkboxlay.setVisibility(View.GONE);
            itemViewHolder.radioButton.setText(itemlist.get(section).getExtras().get(relativePosition).getAttributeName());
            itemViewHolder.priceradio.setText( itemlist.get(section).getExtras().get(relativePosition).getAttributePrice());

           itemViewHolder.radioButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   itemlist.get(section).getExtras().get(relativePosition).setIsChecked("1");
                   for(int i=0;i<itemlist.get(section).getExtras().size();i++)
                   {
                       if(i!=relativePosition){
                        itemlist.get(section).getExtras().get(relativePosition).setIsChecked("0");
                       }
                       if(itemlist.get(section).getExtras().get(i).getIsChecked()=="1"){
                           itemViewHolder.radioButton.setChecked(true);
                       }else {
                           itemViewHolder.radioButton.setChecked(false);
                       }

                   }
               }
           });


        } else
        {    itemViewHolder.radiobtnlay.setVisibility(View.GONE);
            itemViewHolder.checkboxlay.setVisibility(View.VISIBLE);
            itemViewHolder.itemchild.setText(itemlist.get(section).getExtras().get(relativePosition).getAttributeName());
            itemViewHolder.price.setText( itemlist.get(section).getExtras().get(relativePosition).getAttributePrice());
        }

//        if(itemlist.get(section).getExtras().get(relativePosition).getIsChecked()=="1"){
//            itemViewHolder.radioButton.setChecked(true);
//        }else {
//            itemViewHolder.radioButton.setChecked(false);
//        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Change inflated layout based on 'header'.
        View v = LayoutInflater.from(parent.getContext())
                .inflate(viewType == VIEW_TYPE_HEADER ? R.layout.list_item_section : R.layout.list_item, parent, false);
        return new ItemViewHolder(v);


    }


   // ItemViewHolder Class for Items in each Section
    public static class ItemViewHolder extends RecyclerView.ViewHolder {

       TextView titlesection,price,priceradio;
       CheckBox itemchild;
       RadioButton radioButton;
       LinearLayout checkboxlay,radiobtnlay;

        public ItemViewHolder(View itemView) {
            super(itemView);
            checkboxlay=(LinearLayout)itemView.findViewById(R.id.card_view);
            radiobtnlay=(LinearLayout)itemView.findViewById(R.id.flagradio);
            titlesection=(TextView)itemView.findViewById(R.id.itemsectionname);
            itemchild=(CheckBox) itemView.findViewById(R.id.check);
            price=(TextView)itemView.findViewById(R.id.price);
            radioButton=(RadioButton)itemView.findViewById(R.id.radio);
            priceradio=(TextView)itemView.findViewById(R.id.price1);
        }
    }

}
