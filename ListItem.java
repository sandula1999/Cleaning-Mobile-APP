package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public
class ListItem extends AppCompatActivity{

    EditText EditjobType,EditCustomerAdr,EditCustomerName,EditCustomerEmail,editTextNumberOfRoom,editTextMobile;
    Button btnAaccept;

    TextView t1;
    private DBHandler db;
    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_list_item );

        db = new DBHandler ( this );
        db.OpenDB ( );

        EditjobType=(EditText)findViewById(R.id.editTextJobType);
        EditCustomerAdr=(EditText)findViewById (R.id.editTextCustomerAdr );
        EditCustomerName=(EditText)findViewById(R.id.editTextCustomerName);
        EditCustomerEmail=(EditText)findViewById(R.id.editTextCustomerEmail);
        editTextNumberOfRoom=(EditText)findViewById(R.id.editTextNOB);
        editTextMobile=(EditText)findViewById(R.id.editTextMobile);
        btnAaccept=(Button ) findViewById ( R.id.button );

      t1=findViewById ( R.id.TextView);
        Intent intent =getIntent ( );
       String str =intent.getStringExtra ( "name");
       t1.setText (str);



        ArrayList <com.example.icbt.jobs> jobDetailsList = db.getJobData (str);

        com.example.icbt.jobs jobs=jobDetailsList.get ( 0 );

      //  com.example.icbt.jobs jobs=jobDetailsList.get(0);
        EditjobType.setText (jobs.getJobType ());
        EditCustomerName.setText (jobs.getCustomerName ());
        EditCustomerEmail.setText (jobs.getCustomerEmail ());
        EditCustomerAdr.setText (jobs.getCustomerAddress ());
        editTextNumberOfRoom.setText (jobs.getNumberOfRoom ());
        editTextMobile.setText (jobs.getCustomerMobile ());




        btnAaccept.setOnClickListener ( new View.OnClickListener ( ){
            @Override
            public
            void onClick ( View view ) {
                Toast.makeText ( ListItem.this , "JOB IS ACCEPTED" , Toast.LENGTH_SHORT ).show ( );
            }
        } );








    }
}