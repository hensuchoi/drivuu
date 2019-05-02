package com.example.drivuu;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class UserList extends ArrayAdapter<User> {

    private Activity context;
    private List<User> users;
    DatabaseReference databaseReference;
    EditText edtName;
    public UserList(@NonNull Activity context, List<User> users, DatabaseReference databaseReference, EditText edtName){

        super(context,R.layout.layout_user_list,users);
    }

}
