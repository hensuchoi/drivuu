package com.example.drivuu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drivuu.R;

import java.util.List;

public class RecyclerView_Config {

    private Context mContext;
    private PlateAdapter mPlateAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Plate> plates, List<String> keys){
        mContext = context;
        mPlateAdapter = new PlateAdapter(plates, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mPlateAdapter);
    }

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

    class PlateAdapter extends RecyclerView.Adapter<PlateItemView>{
        private List<Plate> mPlateList;
        private List<String> mKeys;

        public PlateAdapter(List<Plate> mPlateList, List<String> mKeys) {
            this.mPlateList = mPlateList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public PlateItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PlateItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull PlateItemView holder, int position) {
            holder.bind(mPlateList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mPlateList.size();
        }
    }



    }

