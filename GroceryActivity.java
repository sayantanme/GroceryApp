package com.example.sayantanchakraborty.grocery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GroceryActivity extends AppCompatActivity {

    TextView groceryItem;
    Button readList;
    Button writeList;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);
    }

    @Override
    protected void onStart() {
        super.onStart();
        groceryItem = (TextView)findViewById(R.id.textViewItem);
        readList = (Button)findViewById(R.id.read);
        writeList = (Button)findViewById(R.id.write);
        //mRef = new Firebase("https://vivid-torch-9290.firebaseio.com/");
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference mRef = db.getReference();
        //mRef.setValue("Hello, world");

        mRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue();
                groceryItem.setText(value.toString());
                Log.d("log:","Value is: " + value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("log:", "Failed to read value.", databaseError.toException());
            }
        });
//        mRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                String text = dataSnapshot.getValue(String.class);
//                groceryItem.setText(text);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                String text = dataSnapshot.getValue(String.class);
//                groceryItem.setText(text);
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                groceryItem.setText(text);
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
    }
}
