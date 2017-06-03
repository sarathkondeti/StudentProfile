package com.example.srikanth.studentprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton profilePicImage;
    Button uploadProPicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onUploadButtonClicked(View view){

        Toast.makeText(MainActivity.this, "hello there", Toast.LENGTH_SHORT).show();

    }




}
