package com.example.sayantanchakraborty.grocery;

import com.firebase.client.Firebase;

/**
 * Created by SayantanChakraborty on 19/05/16.
 */
public class Grocery extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
