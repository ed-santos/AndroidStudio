package com.example.didyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView img = (ImageView) findViewById(R.id.imgLogo);
        img.setImageResource(R.mipmap.didyoulogoonly);

        ImageButton imgbtn = (ImageButton) findViewById(R.id.imgChk);
        imgbtn.setImageResource(R.mipmap.didyouchk);
    }
}
