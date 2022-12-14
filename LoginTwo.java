package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class LoginTwo extends AppCompatActivity {

    EditText username, password;
    MaterialButton loginbtn, signbtn;
    private DBHandler db;



    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login_two );

        username = ( EditText ) findViewById ( R.id.username1 );
        password = ( EditText ) findViewById ( R.id.password1 );


        loginbtn = ( MaterialButton ) findViewById ( R.id.loginbtn );
        signbtn = ( MaterialButton ) findViewById ( R.id.signbtn1 );

        db = new DBHandler ( this );
        db.OpenDB ( );

        loginbtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                ArrayList <userCustomer> userCustomerList = db.CheckUsernameForcustomer ( username.getText ( ).toString ( ) ,password.getText ( ).toString ( ) );

                if(userCustomerList.size  ()!=0){

                    Toast.makeText ( getApplicationContext ( ) , " Login Success " , Toast.LENGTH_LONG ).show ( );

                    Intent intent=new Intent ( getApplicationContext (),HomeTwo.class );
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
                Toast.makeText ( LoginTwo.this , "REDIRECT SIGN UP FORM" , Toast.LENGTH_SHORT ).show ( );
                Intent intent = new Intent ( getApplicationContext ( ) , SignUpTwo.class );
                startActivity ( intent );
            }
        } );

    }


}