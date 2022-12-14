package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public
class Select extends AppCompatActivity{

    Button buttonService, buttonFreelance;

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_select );

        Button buttonService   = ( Button ) findViewById ( R.id.SelectBtnService );
        Button buttonFreelance = ( Button ) findViewById ( R.id.SelectBtnFreelance );

        buttonService.setOnClickListener ( new View.OnClickListener ( ){

            @Override
            public
            void onClick ( View view ) {
                Toast.makeText ( Select.this , "CLICKED CUSTOMER " , Toast.LENGTH_SHORT ).show ( );

                Intent intent = new Intent ( getApplicationContext ( ) , LoginTwo.class );
                startActivity ( intent );
            }
        } );

        buttonFreelance.setOnClickListener ( new View.OnClickListener ( ){

            @Override
            public
            void onClick ( View view ) {

                Toast.makeText ( Select.this , "CLICKED FREELANCE  " , Toast.LENGTH_SHORT ).show ( );

                Intent intent = new Intent ( getApplicationContext ( ) , Login.class );
                startActivity ( intent );
            }
        } );


    }
}