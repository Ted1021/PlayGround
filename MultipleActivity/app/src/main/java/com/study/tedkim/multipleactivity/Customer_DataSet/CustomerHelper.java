package com.study.tedkim.multipleactivity.Customer_DataSet;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.study.tedkim.multipleactivity.Customer.CustomerItem;

import java.util.ArrayList;

/**
 * Created by tedkim on 2017. 6. 2..
 */

public class CustomerHelper extends SQLiteOpenHelper {

    SQLiteDatabase mDB;

    ArrayList<CustomerItem> mDataSet = new ArrayList<>();

    public CustomerHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, SQLiteDatabase db) {
        super(context, name, factory, version);

        mDB = db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE customer (" +
                "customer_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "age INTEGER, " +
                "address TEXT, " +
                "tel TEXT);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXIST customer;";
        db.execSQL(sql);

        onCreate(db);
    }

    public void insertData() {

        String name = "", address = "", tel = "";
        int age = 0;

        String query;

        mDB = getWritableDatabase();
        for (int i = 0; i < 20; i++) {

            name = i + 97 + "";
            age = i + 20;
            address = "용인시 기흥구 보정동";
            tel = "010" + i + "3" + i + "7" + "1234";

            query = "INSERT INTO customer VALUES(null, '" + name + "', '" + age + "', '" + address + "', '" + tel + "');";
            mDB.execSQL(query);

        }
        close();
    }

    public void updateData(int index, String eng) {

        String query = "UPDATE customer SET eng = '"+ eng +"' WHERE customer_id = '"+ index +"';";

        mDB = getWritableDatabase();
        mDB.execSQL(query);

        this.close();
    }

    public void deleteData() {

        String query = "DELETE FROM customer;";

        mDB = getWritableDatabase();
        mDB.execSQL(query);

        this.close();

    }

    public void deleteData(String eng){

        String query = "DELETE FROM customer WHERE eng = '"+ eng +"';";
        mDB = getWritableDatabase();
        mDB.execSQL(query);

        this.close();
    }

    public ArrayList<CustomerItem> selectData() {

        String query = "SELECT * FROM customer;";

        mDB = getReadableDatabase();
        Cursor cursor = mDB.rawQuery(query, null);

        int pIndex = cursor.getColumnIndex("customer_id");
        int pName = cursor.getColumnIndex("name");
        int pAge = cursor.getColumnIndex("age");
        int pAddress = cursor.getColumnIndex("address");
        int pTel = cursor.getColumnIndex("tel");

        while(cursor.moveToNext()){

            CustomerItem item = new CustomerItem();

            item.setCustomer_id(pIndex);
            item.setName(cursor.getString(pName));
            item.setAge(cursor.getInt(pAge));
            item.setAddress(cursor.getString(pAddress));
            item.setTel(cursor.getString(pTel));

            mDataSet.add(item);
        }

        this.close();

        return mDataSet;

    }
}
