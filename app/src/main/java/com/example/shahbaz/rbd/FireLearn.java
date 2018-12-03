package com.example.shahbaz.rbd;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by shahbaz on 12/01/2017.
 */

public class FireLearn extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        if(!FirebaseApp.getApps(this).isEmpty()){

            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}
