package com.wma.ozfoodhunter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
                + " TEXT,"+totalprice+"TEXT,"+opentime+"TEXT,"+closetime+"TEXT)";
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

    public void insertCategory(String res,String type,int type1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
//        cv.put(Fieldresponse, res);
//        cv.put(DataType, type);
//        db.insert(CategoryTable, null, cv);
//        db.close();
        cv.put(quantity,type1);
        Long k=db.insert(Table_Dish, null, cv);
        Log.d("insert:","one row created");
        db.close();

    }
}
