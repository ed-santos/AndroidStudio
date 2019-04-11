package com.example.didyoulite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView) findViewById(R.id.welcomeImg);

        img.setImageResource(R.mipmap.didyoulogofullvert);
    }

    public void StartBtnClick(View v){

        Intent StartIntent = new Intent(this, createUserProfile.class);
        startActivity(StartIntent);
    }
}
