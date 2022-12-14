package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class SignUp extends AppCompatActivity{

    EditText username, password, email, mobile;
    MaterialButton signup;
    private DBHandler db;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sign_up );


        username = ( EditText ) findViewById ( R.id.username );
        password = ( EditText ) findViewById ( R.id.password );
        email = ( EditText ) findViewById ( R.id.email );
        mobile = ( EditText ) findViewById ( R.id.mobile );

        signup = ( MaterialButton ) findViewById ( R.id.signupbtn );

        db = new DBHandler ( this );
        db.OpenDB ( );



        signup.setOnClickListener ( new View.OnClickListener ( ){
            @Override
            public void onClick ( View v ) {

                if ( username.getText ( ).toString ( ).isEmpty ( ) || password.getText ( ).toString ( ).isEmpty ( ) || email.getText ( ).toString ( ).isEmpty ( ) || mobile.getText ( ).toString ( ).isEmpty ( ) ) {

                    Toast.makeText ( getApplicationContext ( ) , "Fields Can't be blank" , Toast.LENGTH_LONG ).show ( );
                }
                else {
                    com.example.icbt.userFreelance userfreelance = new com.example.icbt.userFreelance ( username.getText ( ).toString ( ) , password.getText ( ).toString ( ) , email.getText ( ).toString ( ) , mobile.getText ( ).toString ( ) );
                    if ( db.insertUser ( userfreelance ) ) {
                        Toast.makeText ( getApplicationContext ( ) , "signup completed " , Toast.LENGTH_LONG ).show ( );
                        Intent intent=new Intent ( getApplicationContext (),Login.class );
                        startActivity ( intent );

                    }
                    else {
                        Toast.makeText ( getApplicationContext ( ) , "Failed" , Toast.LENGTH_LONG ).show ( );

                    }

                }

            }
        } );
    }
}