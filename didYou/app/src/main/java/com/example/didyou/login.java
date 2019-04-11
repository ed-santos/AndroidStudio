package com.example.didyou;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class login extends AppCompatActivity {

    private String username,password;
    private Button ok;
    private EditText editTextUsername,editTextPassword;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView img = (ImageView) findViewById(R.id.loginLogo);
        img.setImageResource(R.mipmap.didyoulogofullvert);

        ImageButton imgbtn = (ImageButton) findViewById(R.id.imgChk);
        imgbtn.setImageResource(R.mipmap.didyouchk);

        ok = (Button)findViewById(R.id.chkRemember);
        //ok.setOnClickListener(this);
        editTextUsername = (EditText)findViewById(R.id.txtEmail);
        editTextPassword = (EditText)findViewById(R.id.txtPwd);
        saveLoginCheckBox = (CheckBox)findViewById(R.id.chkRemember);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            editTextUsername.setText(loginPreferences.getString("username", ""));
            editTextPassword.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
    }

    public void onClick(View view) {
        if (view == ok) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editTextUsername.getWindowToken(), 0);

            username = editTextUsername.getText().toString();
            password = editTextPassword.getText().toString();

            if (saveLoginCheckBox.isChecked()) {
                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", username);
                loginPrefsEditor.putString("password", password);
                loginPrefsEditor.commit();
            } else {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
            }

            doSomethingElse();
        }
    }

    public void doSomethingElse() {
        startActivity(new Intent(login.this, MainActivity.class));
        login.this.finish();
    }

}


