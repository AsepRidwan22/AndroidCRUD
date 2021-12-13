package com.example.ppb3crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HalamanLihat extends AppCompatActivity {
    EditText txt1, txt2, txt3,txt4,txt5;
    DatatHelper dbHelper;
    Button btncari, btnkembali, btnHapus, btnUpdate;
    EditText cari;
    protected Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //database
        setContentView(R.layout.activity_halaman_lihat);
        dbHelper = new DatatHelper(this);

        //text
        txt1 = (EditText) findViewById(R.id.edit1);
        txt2 = (EditText) findViewById(R.id.edit2);
        txt3 = (EditText) findViewById(R.id.edit3);
        txt4 = (EditText) findViewById(R.id.edit4);
        txt5 = (EditText) findViewById(R.id.edit5);
        cari = (EditText) findViewById(R.id.cari);

        //button
        btnkembali = (Button) findViewById(R.id.btnKembali2);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnHapus = (Button) findViewById(R.id.btnHapus);
        btncari = (Button) findViewById(R.id.btnCari);

        //action btnkembali
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //action btnUpdate
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE biodata SET nama = '"+txt2.getText().toString()+"',tgl='"+txt3.getText().toString()+"',"+
                        "jk='"+txt4.getText().toString()+"',alamat='"+txt5.getText().toString()+"' WHERE NO = '"+cari.getText().toString()+"'");
            }
        });

        //action btnHapus
        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM biodata WHERE NO= '"+cari.getText().toString()+"'");
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                txt5.setText("");
                Toast.makeText(getApplicationContext(),
                        "Data Berhasil Dihapus",Toast.LENGTH_SHORT).show();

            }
        });

        //action btnCari
        btncari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM biodata where no='"+cari.getText().toString()+"'",null);
                cursor.moveToFirst();
                if(cursor.getCount()>0){
                    txt1.setText(cursor.getString(0).toString());
                    txt2.setText(cursor.getString(1).toString());
                    txt3.setText(cursor.getString(2).toString());
                    txt4.setText(cursor.getString(3).toString());
                    txt5.setText(cursor.getString(4).toString());
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Data tidak ditemukan",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}