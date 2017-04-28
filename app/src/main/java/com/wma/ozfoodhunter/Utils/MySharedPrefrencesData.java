package com.wma.ozfoodhunter.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class MySharedPrefrencesData {

    public void setFName(Context mContext, String party_name){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Fname", party_name);
        editor.commit(); // commit changes
    }
    public String getFName(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getString("Fname","");
    }

    public void setLName(Context mContext, String party_name){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Lname", party_name);
        editor.commit(); // commit changes
    }
    public String getLName(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getString("Lname","");
    }

    public void setUser_Id(Context mContext, String user_id){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("user_id", user_id);
        editor.commit(); // commit changes
    }
    public String getUser_Id(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getString("user_id","");
    }
    public void setReferal(Context mContext, String referal){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("referal", referal);
        editor.commit(); // commit changes
    }
    public String getReferal(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getString("referal","");
    }

    public void setPartyEmail(Context mContext, String party_email){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("party_email", party_email);
        editor.commit(); // commit changes
    }
    public String getPartyemail(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getString("party_email","");
    }
    public void setParty_pwd(Context mContext, String party_password){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("party_password", party_password);
        editor.commit(); // commit changes
    }
    public String getParty_pwd(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getString("party_password","");
    }
    public void set_Party_mobile(Context mContext, String party_mobile){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("party_mobile", party_mobile);
        editor.commit(); // commit changes
    }
    public String get_Party_mobile(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getString("party_mobile","");
    }

    public void saveWidth(Context context, int mToken) {
        // TODO Auto-generated method stub
        SharedPreferences.Editor editor = context
                .getSharedPreferences("MyPref", Context.MODE_PRIVATE).edit();
        editor.putInt("Width", mToken);
        editor.commit();

    }

    public int getWidth(Context context) {
        SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getInt("Width", 0);

    }
    public void saveHalfWidth(Context context, int mToken) {
        // TODO Auto-generated method stub
        SharedPreferences.Editor editor = context
                .getSharedPreferences("MyPref", Context.MODE_PRIVATE).edit();
        editor.putInt("HalfWidth", mToken);
        editor.commit();

    }

    public int getHalfWidth(Context context) {
        SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE);
        return pref.getInt("HalfWidth", 0);

    }


}
