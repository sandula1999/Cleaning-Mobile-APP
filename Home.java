package com.example.icbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ListView JobList;
    TextView textView;
    private DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=(TextView ) findViewById ( R.id.homeuname );
        Intent intent =getIntent ();
        String uname=intent.getStringExtra ( "USERNAME");
        textView.setText ( "Hii "+uname );
        db = new DBHandler ( this );
        db.OpenDB ( );
        JobList=(ListView ) findViewById ( R.id.JobList );
        ArrayList <String> ListOfJobs=new ArrayList<>();
        ArrayList <String> ListOfJobs1=new ArrayList<>();
        Cursor cursor=db.SearchJobs ();
        if(cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_LONG).show();
        }
        else{
            while (cursor.moveToNext())
            {
                ListOfJobs1.add(cursor.getString(0));
                //   ListOfJobs1.add(cursor.getString(1));
                // ListOfJobs.add(cursor.getString(1));

                ListAdapter listAdapter=new ArrayAdapter <> (this, android.R.layout.simple_list_item_1,ListOfJobs1);

                JobList.setAdapter(listAdapter);


            }
        }
        JobList.setOnItemClickListener ( new AdapterView.OnItemClickListener ( ){
            @Override
            public
            void onItemClick ( AdapterView <?> adapterView , View view , int i , long l ) {

                String str =JobList.getAdapter ().getItem ( i ).toString ();


                Intent intent=new Intent ( getApplicationContext (),ListItem.class );
                intent.putExtra ( "name",str );
                startActivity ( intent );



            }
        } );




    }
}
