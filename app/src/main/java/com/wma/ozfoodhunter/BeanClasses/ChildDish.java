package com.wma.ozfoodhunter.BeanClasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Jayattama on 15-Mar-17.
 */

public class ChildDish implements Serializable, Parcelable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ChildDish(String name) {
        this.name = name;
    }


        public ChildDish(Parcel in) {
            name = in.readString();
        }
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<ChildDish> CREATOR = new Creator<ChildDish>() {
        @Override
        public ChildDish createFromParcel(Parcel in) {
            return new ChildDish(in);
        }

        @Override
        public ChildDish[] newArray(int size) {
            return new ChildDish[size];
        }
    };

}
