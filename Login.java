package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    EditText username, password;
    MaterialButton loginbtn, signbtn;

    private DBHandler db;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );


        db = new DBHandler ( this );
        db.OpenDB ( );

        username = ( EditText ) findViewById ( R.id.username1 );
        password = ( EditText ) findViewById ( R.id.password1 );


        loginbtn = ( MaterialButton ) findViewById ( R.id.loginbtn );
        signbtn = ( MaterialButton ) findViewById ( R.id.signbtn1 );



        loginbtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {


                ArrayList <com.example.icbt.userFreelance> userFreelance = db.CheckUsername ( username.getText ( ).toString ( ) ,password.getText ( ).toString ( ) );


                if(userFreelance.size ()!=0){

                    Toast.makeText ( getApplicationContext ( ) , " Login Success " , Toast.LENGTH_LONG ).show ( );

                    Intent intent=new Intent ( getApplicationContext (),Home.class );
                    intent.putExtra ( "USERNAME",username.getText ().toString () );
                    startActivity ( intent );
                }else {
                    Toast.makeText ( getApplicationContext ( ) , "  Login Failed" , Toast.LENGTH_LONG ).show ( );
                }


            }
        } );

        signbtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                Toast.makeText ( Login.this , "REDIRECT SIGN UP FORM" , Toast.LENGTH_SHORT ).show ( );
                Intent intent = new Intent ( getApplicationContext ( ) , SignUp.class );
                startActivity ( intent );
            }
        } );

    }


}