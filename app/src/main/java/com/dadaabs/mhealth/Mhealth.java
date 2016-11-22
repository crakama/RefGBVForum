package com.dadaabs.mhealth;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by crakama on 11/22/2016.
 */

public class Mhealth extends Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Firebase.setAndroidContext(this);
    }

}
