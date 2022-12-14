package com.example.icbt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnector extends SQLiteOpenHelper {


    public  DBConnector(Context context) {
        super(context, "clean2", null, 2);

    }

    @Override
    public void onCreate ( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.execSQL("create Table users(username TEXT primary key, password TEXT, email TEXT, mobile TEXT)");
        sqLiteDatabase.execSQL("create Table usersCustomer(username TEXT primary key, password TEXT, email TEXT, mobile TEXT)");
        sqLiteDatabase.execSQL("create Table JOBS(ID INTEGER primary key AUTOINCREMENT,JobType TEXT , CustomerName TEXT, CustomerEmail TEXT, CustomerMobile TEXT, CustomerAddress TEXT, NumberOfRoom TEXT)");

    }

    @Override
    public void onUpgrade ( SQLiteDatabase sqLiteDatabase , int i , int i2 ) {


    }
}
