package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Encoder extends AppCompatActivity {

    EditText etenc;
    TextView enctv;
    ClipboardManager cpb;
    ImageView imageView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);

        etenc = findViewById(R.id.etenc);
        enctv = findViewById(R.id.enctv);
        imageView = findViewById(R.id.img);

        cpb= (ClipboardManager) getSystemService (Context.CLIPBOARD_SERVICE);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copy", enctv.getText().toString());
                clipboardManager.setPrimaryClip(clip);
                Toast.makeText(Encoder.this, "Copy to clipbord", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void enc (View view) {
        String temp=etenc.getText().toString();
        String rv=encode.enc (temp);
        enctv.setText (rv);
    }
}