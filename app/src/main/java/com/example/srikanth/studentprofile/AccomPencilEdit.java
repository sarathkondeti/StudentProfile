package com.example.srikanth.studentprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class AccomPencilEdit extends AppCompatActivity {
    EditText accomPencilOrgan,accomPencilPos,accomPencilFromyear,accomPencilToyear;
    Intent intent = getIntent();
   // int position = Integer.parseInt(intent.getStringExtra(AccomAdapter.EXTRA_MESSAGE));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accom_pencil_edit);

        accomPencilOrgan = (EditText) findViewById(R.id.accom_editpencil_organ);
        accomPencilPos= (EditText) findViewById(R.id.accom_editpencil_pos);
        accomPencilFromyear= (EditText) findViewById(R.id.accom_editpencil_fromyear);
        accomPencilToyear = (EditText) findViewById(R.id.accom_editpencil_toyear);



        accomPencilOrgan.setText(AccomAdapter.adapterData.get(AccomAdapter.postionValue).accomOrgan);
        accomPencilPos.setText(AccomAdapter.adapterData.get(AccomAdapter.postionValue).accomPos);
        accomPencilFromyear.setText(AccomAdapter.adapterData.get(AccomAdapter.postionValue).accomFromyear);
        accomPencilToyear.setText(AccomAdapter.adapterData.get(AccomAdapter.postionValue).accomToyear);

    }
}
