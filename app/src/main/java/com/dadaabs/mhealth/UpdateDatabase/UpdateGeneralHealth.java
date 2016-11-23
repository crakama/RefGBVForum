package com.dadaabs.mhealth.UpdateDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dadaabs.mhealth.Models.GeneralHealthModel;
import com.dadaabs.mhealth.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateGeneralHealth extends AppCompatActivity {

    EditText title,updateDetails,organization;
    DatabaseReference db;
    DatabaseOperations dbOperationsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_general_health);

        db = FirebaseDatabase.getInstance().getReference();
        dbOperationsHelper = new DatabaseOperations(db);


        // newsrecyclerView =(RecyclerView)findViewById(R.id.rv_noticeboard);

        title = (EditText) findViewById(R.id.txtUpdateHead);
        updateDetails = (EditText) findViewById(R.id.txtUpdateDetails);
        organization = (EditText) findViewById(R.id.txtorganization);


        Button btnNewsUpdate = (Button) findViewById(R.id.btn_add_update);

        btnNewsUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * GET DATA
                 */
                String healthtitle = title.getText().toString();
                String healthBody = updateDetails.getText().toString();
                String healthorganization = organization.getText().toString();

                /**
                 * SET DATA
                 */
                GeneralHealthModel dbModel = new GeneralHealthModel();
                dbModel.setTitle(healthtitle);
                dbModel.setTitleBody(healthBody);
                dbModel.setOraganization(healthorganization);
                /*** SIMPLE VALIDATION ***/
                if(healthtitle != null && healthBody.length() > 0){

                    if(dbOperationsHelper.saveNotice(dbModel)){
                        /** IF NEWS SAVED, CLEAR EDIT TEXT */
                        title.setText("");
                        updateDetails.setText("");
                        organization.setText("");

                    }else{
                        Toast.makeText(UpdateGeneralHealth.this, "MUST NOT BE EMPTY", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
