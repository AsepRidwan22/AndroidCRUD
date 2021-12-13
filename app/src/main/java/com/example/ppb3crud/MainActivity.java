package com.example.ppb3crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnHalamanTambah , btnHalamanLihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHalamanLihat = (Button)findViewById(R.id.btnHalamanLihat);
        btnHalamanTambah = (Button) findViewById(R.id.btnHalamanTambah);
        btnHalamanTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HalamanTambah.class));
            }
        });
        btnHalamanLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HalamanLihat.class));
            }
        });
    }
}