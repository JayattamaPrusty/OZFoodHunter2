package com.wma.ozfoodhunter.BeanClasses;

import android.os.Parcel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by Jayattama on 15-Mar-17.
 */

public class ParentDish extends ExpandableGroup<ChildDish> {
    public ParentDish(String title, List<ChildDish> items) {

        super(title, items);
    }

    protected ParentDish(Parcel in) {
        super(in);
    }
}
