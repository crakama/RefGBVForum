package com.dadaabs.mhealth.Models;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by crakama on 11/21/2016.
 */

public class DatabaseOperations {
    DatabaseReference dbref;
    Boolean savedhealthupdate;
    ArrayList<GeneralHealthModel> newsArraylist = new ArrayList<>();

    /**
     * GeneralHealthModel REFERENCE
     */

    public DatabaseOperations(DatabaseReference db){
        this.dbref = db;
    }

    public Boolean saveNotice(GeneralHealthModel news){
        if(news == null){
            savedhealthupdate = false;
        }else{
            try {
                dbref.child("GeneralHealthModel").push().setValue(news);
                savedhealthupdate = true;
            } catch (DatabaseException e) {

                e.printStackTrace();
                savedhealthupdate = false;
            }
        }
        return savedhealthupdate;
    }
}
