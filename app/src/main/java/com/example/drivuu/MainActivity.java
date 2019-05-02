package com.example.drivuu;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText edtName;
    DatabaseReference databaseReference;

    ListView listComments;
    List<User> users;
    private String userId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        btnSave= (Button) findViewById(R.id.btSave);
        edtName = (EditText) findViewById(R.id.edtPlate);
        listComments = (ListView) findViewById(R.id.listComments);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                if (TextUtils.isEmpty(userId)) {
                    String id = databaseReference.push().getKey();
                    User user = new User(id, name);
                    databaseReference.child(id).setValue(user);
                    Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
            }
            });
        }

        @Override
        protected void onStart(){
            super.onStart();
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    users.clear();
                    for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                        User user = postSnapshot.getValue(User.class);
                        users.add(user);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }



}
