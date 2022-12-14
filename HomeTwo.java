package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeTwo extends AppCompatActivity{

    Button buttonPostAdd;
    TextView textView;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home_two );

        textView=(TextView ) findViewById ( R.id.homeuname );
        Intent intent =getIntent ();
        String uname=intent.getStringExtra ( "USERNAME");
        textView.setText ( "Hii "+uname );


        Button buttonPostAdd = (Button) findViewById(R.id.postAdd);

        buttonPostAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText ( HomeTwo.this , "POS A ADD" , Toast.LENGTH_SHORT ).show ( );
                Intent intent=new Intent ( getApplicationContext (),createAdd.class );
                startActivity(intent);

            }
        });





    }
}