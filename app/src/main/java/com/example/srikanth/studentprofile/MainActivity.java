package com.example.srikanth.studentprofile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {

    // This is a reference to catch Profile picture imagebutton view.
    ImageButton profilePicImage;

    private final static  int SELECTED_PICTURE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilePicImage = (ImageButton) findViewById(R.id.profile_pic);

    }

    // This method invokes when the upload button is clicked.
    public void onUploadButtonClicked(View view){

        Toast.makeText(MainActivity.this, "hello there", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,SELECTED_PICTURE);

    }

    // This method is when accom_plus_image is clicked.
    public void onAccomPlusClicked(View view){
        Toast.makeText(MainActivity.this, "hello lala there", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AccomEditActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == SELECTED_PICTURE){
                Uri image_uri = data.getData();

                InputStream inputStream;

                try {
                    inputStream = getContentResolver().openInputStream(image_uri);

                    Bitmap image = BitmapFactory.decodeStream(inputStream);

                    profilePicImage.setImageBitmap(image);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this,"Unable to locate image",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
