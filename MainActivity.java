package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public
class MainActivity extends AppCompatActivity{

    Timer Timer;

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView ( R.layout.activity_main );

        Timer=new Timer ();
        Timer.schedule (  new TimerTask (){

            @Override
            public void run(){
                Intent intent=new Intent (  MainActivity.this,Select.class);
                startActivity ( intent );
                finish ();
            }
        },5000 );



    }
}