package com.example.didyoulite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class createUserProfile extends AppCompatActivity {

    public String name;
    public String role;
    public Integer pic;
    public String profilePic = String.valueOf(pic);

    //public String picturePath;
    //private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user_profile);

        ImageView img = (ImageView) findViewById(R.id.imgLogo);
        img.setImageResource(R.mipmap.didyoulogoonly);

        ImageButton imgbtn = (ImageButton) findViewById(R.id.imgChk);
        imgbtn.setImageResource(R.mipmap.didyouchk);

        /*Button buttonLoadImage = (Button) findViewById(R.id.btnProfilePic);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent i = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            startActivityForResult(i, RESULT_LOAD_IMAGE);
        }
    });*/
    }

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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

            this.picturePath = picturePath;
        }
    }*/

    public void imageBtn (View v) {

        int rId = v.getId();
        String roles = v.getResources().getResourceEntryName(rId);
        this.role = roles;

        int imageId = getResources().getIdentifier(roles, "mipmap", "com.example.didyoulite");
        this.pic = imageId;


        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(imageId);
    }

    public void addName() {

        EditText names = (EditText)findViewById(R.id.txtName1);
        String Uname = names.getText().toString();
        this.name = Uname;

        //Spinner mySpinner = (Spinner) findViewById(R.id.spnRole);
        //String roles = mySpinner.getSelectedItem().toString();
        //this.role = roles;


        DBHelper dbH = new DBHelper(this);

        boolean result = dbH.addUser(name, role, profilePic);


        if (result == true)
            Toast.makeText(this, "User Added Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error with DB", Toast.LENGTH_SHORT).show();

    }

    public void ContinueBtnClick(View v){

        Intent ProfileIntent = new Intent(this, Dashboard.class);
        startActivity(ProfileIntent);
        Intent i = new Intent(this, Dashboard.class);
        i.putExtra("Uname", name);
        i.putExtra("Urole", role);
        i.putExtra("Upic", pic);


        addName();



    }
}
