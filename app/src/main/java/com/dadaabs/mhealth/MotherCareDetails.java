package com.dadaabs.mhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MotherCareDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_care_details);

        TextView txtTitle = (TextView) findViewById(R.id.lv_title);
        TextView txtDesc = (TextView) findViewById(R.id.lv_description);


        /*
        *GET INTENT
        */
        Intent newsIntent = this.getIntent();

        /*
        * RECEIVE DATA
         */
        String title = newsIntent.getExtras().getString("TTTLE_KEY");
        String desc = newsIntent.getExtras().getString("DESC_KEY");
        //String organization = newsIntent.getExtras().getString("ORG_KEY");

        /*
        * BIND DATA
        */
        txtTitle.setText(title);
        txtDesc.setText(desc);
    }
}
