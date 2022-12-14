package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public
class createAdd extends AppCompatActivity{


    EditText JobType, CustomerName, CustomerEmail, CustomerMobile, CustomerAddress, NumberOfRoom;
    Button buttonPost;
    private DBHandler db;


    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_create_add );


        JobType         = ( EditText ) findViewById ( R.id.JobType );
        CustomerName    = ( EditText ) findViewById ( R.id.CustomerName );
        CustomerEmail   = ( EditText ) findViewById ( R.id.CustomerEmail );
        CustomerMobile  = ( EditText ) findViewById ( R.id.CustomerMobile );
        CustomerAddress = ( EditText ) findViewById ( R.id.CustomerAddress );
        NumberOfRoom    = ( EditText ) findViewById ( R.id.NumberOfRoom );

        buttonPost = ( Button ) findViewById ( R.id.buttonPost );


        db = new DBHandler ( this );
        db.OpenDB ( );

        buttonPost.setOnClickListener ( new View.OnClickListener ( ){
            @Override
            public
            void onClick ( View view ) {
                if ( JobType.getText ( ).toString ( ).isEmpty ( ) || CustomerName.getText ( ).toString ( ).isEmpty ( )
                        || CustomerEmail.getText ( ).toString ( ).isEmpty ( )
                        || CustomerMobile.getText ( ).toString ( ).isEmpty ( )
                        || CustomerAddress.getText ( ).toString ( ).isEmpty ( )
                        || NumberOfRoom.getText ( ).toString ( ).isEmpty ( ) )
                {
                    Toast.makeText ( getApplicationContext ( ) , "Fields Can't be blank" , Toast.LENGTH_LONG ).show ( );
                }
                else {
                    com.example.icbt.jobs jobdetails = new com.example.icbt.jobs (
                            JobType.getText ( ).toString ( ) ,
                            CustomerName.getText ( ).toString ( ) ,
                            CustomerEmail.getText ( ).toString ( ) ,
                            CustomerMobile.getText ( ).toString ( ) ,
                            CustomerAddress.getText ( ).toString ( ) ,
                            NumberOfRoom.getText ( ).toString ( ) );

                    if ( db.postJob ( jobdetails ) ) {
                        Toast.makeText ( getApplicationContext ( ) , "job posted " , Toast.LENGTH_LONG ).show ( );

                    }
                    else {
                        Toast.makeText ( getApplicationContext ( ) , "Failed" , Toast.LENGTH_LONG ).show ( );

                    }

                }
            }
        } );


    }
}