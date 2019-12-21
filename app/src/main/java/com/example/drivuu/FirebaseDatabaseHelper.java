package com.example.drivuu;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferencePlates;
    private List<Plate> plates = new ArrayList<>();

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferencePlates = mDatabase.getReference("Plates");


    }

    public interface DataStatus {
        void DataIsLoaded(List<Plate> plates, List<String> keys);

        void DataIsInserted();

        void DataIsUpdated();

        void DataIsDeleted();

    }

    public void readPlates(final DataStatus dataStatus) {
        mReferencePlates.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                plates.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Plate plate = keyNode.getValue(Plate.class);
                    plates.add(plate);

                }
                dataStatus.DataIsLoaded(plates, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }
}
