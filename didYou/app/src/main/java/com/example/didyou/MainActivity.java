package com.example.didyou;

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

        //img.animate().alpha(0.8f).setDuration(16000);
    }

    public void LoginBtnClick(View v){

        Intent LoginIntent = new Intent(this, login.class);
        startActivity(LoginIntent);
    }

    public void RegBtnClick(View v){

        Intent RegIntent = new Intent(this, register.class);
        startActivity(RegIntent);
    }
}
