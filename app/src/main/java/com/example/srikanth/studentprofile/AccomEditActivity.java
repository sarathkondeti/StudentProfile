package com.example.srikanth.studentprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class AccomEditActivity extends AppCompatActivity {

    EditText accomOrgan,accomPos,accomFromyear,accomToyear;
    int cardCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accom_edit);

        accomOrgan = (EditText) findViewById(R.id.accom_organ);
        accomPos = (EditText) findViewById(R.id.accom_pos);
        accomFromyear = (EditText) findViewById(R.id.accom_fromyear);
        accomToyear = (EditText) findViewById(R.id.accom_toyear);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.accom_save_action,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.accom_save_action_button){
            //grabbing the details entered in the fields into cardview.

        }
        return super.onOptionsItemSelected(item);
    }
}
