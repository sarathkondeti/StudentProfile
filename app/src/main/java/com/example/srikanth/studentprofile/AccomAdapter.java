package com.example.srikanth.studentprofile;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by skyrider on 5/6/17.
 */

public class AccomAdapter extends RecyclerView.Adapter<AccomAdapter.AccomViewHolder> {
    ArrayList<AccomDetails> adapterData;


    AccomAdapter(ArrayList<AccomDetails> adapterData){
        this.adapterData = adapterData;

    }
    @Override
    public AccomAdapter.AccomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();

        LayoutInflater inflater;
        inflater=LayoutInflater.from(context);

        return null;
    }

    @Override
    public void onBindViewHolder(AccomAdapter.AccomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AccomViewHolder extends RecyclerView.ViewHolder{
        CardView cardview;
        TextView organisation,position,fromyear,toyear;
        public AccomViewHolder(View itemView) {
            super(itemView);
            cardview     = (CardView) itemView.findViewById(R.id.accom_cardview);
            organisation = (TextView) itemView.findViewById(R.id.accom_card_organ);
            position     = (TextView) itemView.findViewById(R.id.accom_card_pos);
            fromyear     = (TextView) itemView.findViewById(R.id.accom_card_fromyear);
            toyear       = (TextView) itemView.findViewById(R.id.accom_card_toyear);
        }

    }





}
