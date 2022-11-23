package com.example.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyDAO {
    private Context context;
    private SQLiteDatabase database;

    public MyDAO(Context context){
        this.context = context;
        MyDBhelper dBhelper = new MyDBhelper(context,"myDB",null,1);
        database = dBhelper.getWritableDatabase();
    }

    public Uri DAOinsert(ContentValues contentValues) {
        long rowid=database.insert("student", null, contentValues);
        Uri uri=Uri.parse("content://myDB.provider");
        Uri inserturi= ContentUris.withAppendedId(uri,rowid);
        context.getContentResolver().notifyChange(inserturi,null);
        return inserturi;
    }

}
