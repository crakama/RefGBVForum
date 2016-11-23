package com.dadaabs.mhealth.UpdateDatabase;

import com.dadaabs.mhealth.Models.GeneralHealthModel;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by crakama on 11/23/2016.
 */

public class DatabaseOperations {
        DatabaseReference dbref;
        Boolean  savedgeneralHealth;


        /**
         * NoticeBoardModel REFERENCE
         */

        public DatabaseOperations(DatabaseReference db){
            this.dbref = db;
        }

        public Boolean saveNotice(GeneralHealthModel generalHealthModel){
            if(generalHealthModel == null){
                savedgeneralHealth = false;
            }else{
                try {
                    dbref.child("GeneralHealthModel").push().setValue(generalHealthModel);
                    savedgeneralHealth = true;
                } catch (DatabaseException e) {

                    e.printStackTrace();
                    savedgeneralHealth = false;
                }
            }
            return savedgeneralHealth;
        }
}
