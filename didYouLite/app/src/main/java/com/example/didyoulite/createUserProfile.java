package com.example.didyoulite;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class createUserProfile extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_profile);

        ImageView img = (ImageView) findViewById(R.id.imgLogo);
        img.setImageResource(R.mipmap.didyoulogoonly);

        ImageButton imgbtn = (ImageButton) findViewById(R.id.imgChk);
        imgbtn.setImageResource(R.mipmap.didyouchk);

        Button buttonLoadImage = (Button) findViewById(R.id.btnProfilePic);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent i = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            startActivityForResult(i, RESULT_LOAD_IMAGE);
        }
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            // String picturePath contains the path of selected Image
        }
    }

    public void ContinueBtnClick(View v){

        Intent ProfileIntent = new Intent(this, Dashboard.class);
        startActivity(ProfileIntent);
    }
}
