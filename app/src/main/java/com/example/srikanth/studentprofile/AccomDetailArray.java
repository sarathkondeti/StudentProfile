package com.example.srikanth.studentprofile;

import java.util.ArrayList;

/**
 * Created by skyrider on 5/6/17.
 */

public class AccomDetailArray {



    public static ArrayList<AccomDetails> getAccomData(){
        ArrayList<AccomDetails> data=new ArrayList<AccomDetails>();
        for(int i=1;i<10;i++){

            AccomDetails current=new AccomDetails();
            current.accomOrgan=String.valueOf(i);
            current.accomPos  =String.valueOf(i+1);
            current.accomFromyear =String.valueOf(i+2);
            current.accomToyear =String.valueOf(i+3);
            data.add(current);
        }

        return data;
    }

    /*public void makeAccomCard(){
        AccomDetails current=new AccomDetails();
        current.accomOrgan=AccomEditActivity.accomOrgan.getText().toString();
        current.accomPos  =AccomEditActivity.accomPos.getText().toString();
        current.accomFromyear =AccomEditActivity.accomFromyear.getText().toString();
        current.accomToyear =AccomEditActivity.accomToyear.getText().toString();

        data.add(current);
        AccomAdapter.adapterData=data;
        MainActivity.accomadapter.notifyDataSetChanged();
        MainActivity.accomadapter.notifyItemInserted(data.indexOf(current));


    }*/
}
