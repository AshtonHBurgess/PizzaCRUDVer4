package com.example.pizzaver4;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.time.LocalDate;

public class MyDataBaseHelper extends SQLiteOpenHelper {
//add to git
    private Context context;
    private static final String DATABASE_NAME="CRUDPizza.db";
    private static final int DATABASE_VERSION=1;


    private static final String TABLE_NAME = "pizza_order";
    //Order #, Date, Cust Info (non granular), Size, Top 1, Top 2, Top 3
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_CNAME = "cname";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PNAME = "pname";
    private static final String COLUMN_SIZE = "size";
    private static final String COLUMN_TOP1 = "top1";
    private static final String COLUMN_TOP2 = "top2";
    private static final String COLUMN_TOP3 = "top3";

    private static final String COLUMN_TOP4 = "top4";
    private static final String COLUMN_TOP5 = "top5";
    private static final String COLUMN_TOP6 = "top6";

    MyDataBaseHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE " + TABLE_NAME +
                " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_CNAME + " TEXT, " +
                COLUMN_PHONE + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_PNAME + " TEXT, " +
                COLUMN_SIZE + " TEXT, " +
                COLUMN_TOP1 + " TEXT, " +
                COLUMN_TOP2 + " TEXT, " +
                COLUMN_TOP3 + " TEXT, " +
                COLUMN_TOP4 + " TEXT, " +
                COLUMN_TOP5 + " TEXT, " +
                COLUMN_TOP6 + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
    }

    void addPizzaOrder(String cname, String phone, String address, String pname, String size, String top1, String top2, String top3, String top4, String top5, String top6){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
      // COLUMN_DATE,COLUMN_CNAME,COLUMN_PHONE,COLUMN_ADDRESS,COLUMN_PNAME,
        // COLUMN_SIZE,COLUMN_TOP1,COLUMN_TOP2,COLUMN_TOP3
        String date = String.valueOf(LocalDate.now());
        cv.put(COLUMN_DATE,date);
        cv.put(COLUMN_CNAME,cname);
        cv.put(COLUMN_PHONE,phone);
        cv.put(COLUMN_ADDRESS,address);
        cv.put(COLUMN_PNAME,pname);
        cv.put(COLUMN_SIZE,size);
        cv.put(COLUMN_TOP1,top1);
        cv.put(COLUMN_TOP2,top2);
        cv.put(COLUMN_TOP3,top3);

        cv.put(COLUMN_TOP4,top4);
        cv.put(COLUMN_TOP5,top5);
        cv.put(COLUMN_TOP6,top6);
//        db.insert(TABLE_NAME,null,cv);
    long result=db.insert(TABLE_NAME,null,cv);

    //If failed toast
    if(result== -1){
        Toast.makeText(context, "Failed to Insert", Toast.LENGTH_SHORT).show();
    }
    else
    {Toast.makeText(context, "Pizza Order Inserted", Toast.LENGTH_SHORT).show();}
    }

    Cursor readAlldata(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db !=null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;//will return cursor with all table data
    }


    void updateData(String row_id,String cname, String phone, String address, String pname, String size, String top1, String top2, String top3 ,  String top4, String top5, String top6  ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        String date = String.valueOf(LocalDate.now());

//        cv.put(COLUMN_DATE,date);
        cv.put(COLUMN_CNAME,cname);
        cv.put(COLUMN_PHONE,phone);
        cv.put(COLUMN_ADDRESS,address);
        cv.put(COLUMN_PNAME,pname);
        cv.put(COLUMN_SIZE,size);
        cv.put(COLUMN_TOP1,top1);
        cv.put(COLUMN_TOP2,top2);
        cv.put(COLUMN_TOP3,top3);

        cv.put(COLUMN_TOP4,top4);
        cv.put(COLUMN_TOP5,top5);
        cv.put(COLUMN_TOP6,top6);
        long results = db.update(TABLE_NAME,cv,"_id=?",new String[]{row_id});
        //validate
        if(results == -1){
            //no data
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Pizza has been updated", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOnePizza(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
      long result =   db.delete(TABLE_NAME,"_id=?",new String[]{row_id});
      if(result == -1){
          Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
      }else{
          Toast.makeText(context, "Pizza was deleted", Toast.LENGTH_SHORT).show();
      }

    }

void deleteAllPizzas(){
SQLiteDatabase db = this.getWritableDatabase();
db.execSQL("DELETE FROM " + TABLE_NAME);

}

}//END OF DB CLASS


