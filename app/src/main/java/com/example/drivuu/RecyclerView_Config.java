package com.example.drivuu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drivuu.R;

public class RecyclerView_Config {

    private Context mContext;

    class PlateItemView extends RecyclerView.ViewHolder{
        private TextView mPlateID;
        private TextView mComment;
        private String key;

        public PlateItemView (ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.plate_list_item,parent, false ));

            mPlateID = (TextView) itemView.findViewById(R.id.plateID_view);
            mComment = (TextView) itemView.findViewById( R.id.comment_view);
        }

        public void bind (Plate plate, String key){
            mPlateID.setText(plate.getPlateID());
            //mComment.setText(plate.getComments());



        }
    }
}
