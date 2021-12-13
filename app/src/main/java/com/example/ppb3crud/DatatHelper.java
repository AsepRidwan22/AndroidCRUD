package com.example.ppb3crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatatHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="biodatadiri.db";
    private static final int DATABASE_VERSION=1;
    public DatatHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create  table biodata(no integer primary key, nama text null, tgl text null, jk text null, alamat text null);";
        Log.d("Data","onCreate:"+sql);
        db.execSQL(sql);
        sql="INSERT INTO biodata values('1001','Agung','2000-04-14','Laki-Laki','Cianjur')";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
