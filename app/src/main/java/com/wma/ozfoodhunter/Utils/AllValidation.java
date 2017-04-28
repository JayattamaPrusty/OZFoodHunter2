package com.wma.ozfoodhunter.Utils;

import android.content.Context;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mathivanan on 09/10/16.
 */
public class AllValidation {
    public static boolean getRegisterValidate(String fname, String lname, String email, String mobile, String password, final Context mContext){
        boolean flag=false;
        if(!fname.equalsIgnoreCase("")){
            if(!lname.equalsIgnoreCase("")){
                if(!email.equalsIgnoreCase("")){
                    if(validate(email)){
                        if(!password.equalsIgnoreCase("")){
                            if(!mobile.equalsIgnoreCase("")){
                                if(mobile.length()==10){
                                    flag=true;
                                    }else{
                                            myToast(mContext,"enter 10 digit mobile no.!");
                                        }
                                    }else{
                                        myToast(mContext,"plesae enter mobile no.");
                                    }

                                }else{
                                    myToast(mContext,"please enter password");
                                }

                            }else{
                                myToast(mContext,"invalid email id");
                            }
                        }else{
                            myToast(mContext,"Invalide email id!");
                    }
            }else{
                myToast(mContext,"please enter last name");
            }
        }else{
            myToast(mContext,"please enter first name");
        }

        return flag;
    }


    public static boolean validate(final String hex) {
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher= pattern.matcher(hex);
        return matcher.matches();

    }

    public static void myToast(Context mContext, String msg){
        try {
            Toast.makeText(mContext,msg, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean loginValidate(String email, String pass, Context mContext) {
        if(!email.equalsIgnoreCase("")){
            if(!pass.equalsIgnoreCase("")){
                return true;
            }else{
                myToast(mContext,"Please enter password");
            }
        }else{
            myToast(mContext,"Please enter email id");
        }
        return false;
    }

    public static boolean emptyFieldValidation(String field, String mag, Context context){
        boolean flag=false;
        if(!field.equalsIgnoreCase("")){
            flag=true;
        }else{
            myToast(context,"please enter "+mag+"");
        }
        return flag;
    }
}
