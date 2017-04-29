package com.wma.ozfoodhunter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.wma.ozfoodhunter.BeanClasses.Cart_Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jayattama Prusty on 12-Apr-17.
 */

public class Localdb extends SQLiteOpenHelper {

    public static final int db_version=4;
    public static final String db_name="OzFoodHunterdb";

    private String autoIncreament="autoIncreament";
    private String Table_Dish="Dish";
    private String id="id";
    private String restaurant_id="in_restaurant_id";
    private String dish_id="in_dish_id";
    private String dish_name="st_dish_name";
    private String dish_variety_name="price_item";
    private String dish_variety_price="menu_price";
    private String delivery_type="delivery_type";
    private String quantity="quantity";
    private String totalprice="totalprice";
    private String opentime="opentime";
    private String closetime="closetime";
    private String preference="is_preference";

    private String Table_Preference="Preference";
    private String preference_id="preferenceid";
    private String preference_type="type";
    private String preference_name="attribute_name";
    private String preference_price="attribute_price";


    private final String CategoryTable="CategoryTable";
    private final String SrNo="SrNo";
    private final String Fieldresponse="Fieldresponse";
    private final String DataType="DataType";




    public Localdb(Context context) {

        super(context, db_name, null, db_version);
        Log.d("database:","database created");
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_DISH= "CREATE TABLE " + Table_Dish + "("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + restaurant_id + " TEXT,"
                + dish_id + " TEXT," + dish_name + " TEXT,"
                +dish_variety_name+" TEXT,"+dish_variety_price+" TEXT,"+delivery_type+" TEXT,"+quantity
                + " TEXT,"+totalprice+" TEXT,"+opentime+" TEXT,"+closetime+" TEXT,"+preference+" TEXT)";
        sqLiteDatabase.execSQL(CREATE_DISH);

        String CREATE_PREFERENCE= "CREATE TABLE " + Table_Preference + "("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + preference_id + " TEXT,"
                + preference_type + " TEXT," + preference_name + " TEXT,"
                +preference_price+" TEXT,"+quantity+" TEXT,"+totalprice+" TEXT,"+dish_id+"TEXT)";
        sqLiteDatabase.execSQL(CREATE_PREFERENCE);


        String CREATE_CATEGORY="CREATE TABLE " +CategoryTable+" ("+SrNo+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                Fieldresponse+" TEXT,"+DataType+" TEXT)";
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
        Log.d("table:","table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Table_Dish);
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Table_Preference);

        // Create tables again
        onCreate(db);
    }
    public Cursor getCategoryData(String type) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoryTable + " WHERE " + DataType + "='" + type + "'", null);
        return c;
    }

    public void deleteCategoty(String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + CategoryTable + " WHERE " + DataType + "='" + type + "'");
    }

    public void insertCategory(int qty,String rid,String di,String dn,String dt,String dvn,String pr,String tp,String pre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(quantity,qty);
        cv.put(restaurant_id,rid);
        cv.put(dish_id,di);
        cv.put(dish_name,dn);
        cv.put(delivery_type,dt);
        cv.put(dish_variety_name,dvn);
        cv.put(dish_variety_price,pr);
        cv.put(totalprice,tp);
        cv.put(preference,pre);
        Long k=db.insert(Table_Dish, null, cv);
        Log.d("insert:",""+k);
        db.close();

    }

    public List<Cart_Model.Cart_Details> getCart_Details(){
        List<Cart_Model.Cart_Details> cd = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+Table_Dish;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            Cart_Model.Cart_Details d =  new Cart_Model().new Cart_Details();
            d.setId(cursor.getString(0));
            d.setIn_restaurant_id(cursor.getString(1));
            d.setIn_dish_id(cursor.getString(2));
            d.setSt_dish_name(cursor.getString(3));
            d.setPrice_item(cursor.getString(4));
            d.setMenu_price(cursor.getString(5));
            d.setQuantity(cursor.getString(7));;
            d.setIs_preference(cursor.getString(11));
            cd.add(d);
        }
        return cd;
    }


    public void updateCart(int qty,String iid) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "update "+Table_Dish+" set "+quantity+"="+qty+" where "+id +"="+iid ;
        Cursor cursor = db.rawQuery(query, null);
    }


}
