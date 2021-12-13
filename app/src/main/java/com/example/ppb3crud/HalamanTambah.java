package com.example.ppb3crud;


import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HalamanTambah extends AppCompatActivity {
    EditText tambahno, tambahnama, tambahtgl, tambahjk, tambahalamat;
    Button btnsimpan, btnkembali;
    DatatHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_tambah);
        dbHelper = new DatatHelper(this);
        tambahno = (EditText) findViewById(R.id.tambahno);
        tambahnama = (EditText) findViewById(R.id.tambahnama);
        tambahtgl = (EditText) findViewById(R.id.tambahtgl);
        tambahjk = (EditText) findViewById(R.id.tambahjk);
        tambahalamat = (EditText) findViewById(R.id.tambahalamat);
        btnsimpan = (Button) findViewById(R.id.btnsimpan);
        btnkembali = (Button) findViewById(R.id.btnkembali);

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO biodata values('"+tambahno.getText().toString()+"'," +
                        "'"+tambahnama.getText().toString()+"'," +
                        "'"+tambahtgl.getText().toString()+"'," +
                        "'"+tambahjk.getText().toString()+"'," +
                        "'"+tambahalamat.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),
                        "Data Berhasil Disimpan",Toast.LENGTH_SHORT).show();
            }
        });
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}