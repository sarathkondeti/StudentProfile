package com.example.srikanth.studentprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {

    // This is a reference to catch Profile picture imagebutton view.
    ImageButton profilePicImage;
    private final static  int SELECTED_PICTURE=1;


    RecyclerView accomRV;
    public static AccomAdapter accomadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        profilePicImage = (ImageButton) findViewById(R.id.profile_pic);
        profilePicImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(MainActivity.this,profilePicImage);
                popupMenu.getMenuInflater().inflate(R.menu.image_dropdown_menu,popupMenu.getMenu());


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.upload_image_item){
                            onUploadButtonClicked();
                        }
                        else if(item.getItemId()==R.id.remove_image_item){

                            AlertDialog.Builder builder  = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Do you want to remove your Proile Pic?")
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            profilePicImage.setImageResource(R.drawable.dummypropic);
                                        }
                                    })
                                    .setNegativeButton("Cancel",null);

                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }

                        return true;


                    }
                });

                popupMenu.show();
            }
        });




        accomRV=(RecyclerView) findViewById(R.id.accom_rv);
        accomadapter=new AccomAdapter(this,AccomDetailArray.getAccomData());
        LinearLayoutManager layoutmanger=new LinearLayoutManager(this);
        accomRV.setLayoutManager(layoutmanger);
        accomRV.setAdapter(accomadapter);
        accomRV.setHasFixedSize(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.accom_save_action,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.accom_save_action_button){
            AlertDialog.Builder builder  = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to save changes?")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Upload the data into the server.




                            /**********************************/
                        }
                    })
                    .setNegativeButton("Cancel",null);

            AlertDialog alertDialog = builder.create();
            alertDialog.show();



        }
        return super.onOptionsItemSelected(item);
    }

    // This method invokes when the upload imagebutton is clicked.

    public void onUploadButtonClicked(){

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,SELECTED_PICTURE);

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
    /*****************************************************************/


    // This method is when accom_plus_image is clicked.
    public void onAccomPlusClicked(View view){
        Intent intent = new Intent(this,AccomEditActivity.class);
        startActivity(intent);
    }

}
