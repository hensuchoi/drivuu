package com.example.drivuu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText edtName;
    DatabaseReference databaseReference;

    ListView listComments;
    List<User> users;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        btnSave= (Button) findViewById(R.id.btSave);
        edtName = (EditText) findViewById(R.id.edtPlate);
        listComments = (ListView) findViewById(R.id.listComments);


    }
}
