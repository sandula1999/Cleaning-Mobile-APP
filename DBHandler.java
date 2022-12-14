package com.example.icbt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHandler {
    private Context con;
    private SQLiteDatabase db;


    public DBHandler ( Context con ) {
        this.con = con;
    }



    public DBHandler OpenDB () {
        com.example.icbt.DBConnector dbCon = new com.example.icbt.DBConnector ( con );
        db = dbCon.getWritableDatabase ( );
        return this;
    }

    public boolean insertUser ( com.example.icbt.userFreelance userfreelance ) {
        try {
            ContentValues cv = new ContentValues();
            cv.put ( "username",userfreelance.getUsername () );
            cv.put ( "password",userfreelance.getPassword () );
            cv.put ( "email",userfreelance.getEmail () );
            cv.put ( "mobile",userfreelance.getMobile () );

            db.insert ( "users",null,cv );
            return true;
        } catch (Exception ex) {
            Toast.makeText ( con , ex.getMessage ( ) , Toast.LENGTH_LONG ).show ( );
            return false;
        }
    }

    public boolean checkuser ( com.example.icbt.userFreelance userfreelance ) {
        try {
            ContentValues cv = new ContentValues();
            cv.put ( "username",userfreelance.getUsername () );
            cv.put ( "password",userfreelance.getPassword () );


            db.insert ( "users",null,cv );
            return true;
        } catch (Exception ex) {
            Toast.makeText ( con , ex.getMessage ( ) , Toast.LENGTH_LONG ).show ( );
            return false;
        }
    }

    public boolean insertUserCustomer ( com.example.icbt.userCustomer usercustomer ) {
        try {
            ContentValues cv = new ContentValues();
            cv.put ( "username",usercustomer.getUsername () );
            cv.put ( "password",usercustomer.getPassword () );
            cv.put ( "email",usercustomer.getEmail () );
            cv.put ( "mobile",usercustomer.getMobile () );

            db.insert ( "usersCustomer",null,cv );
            return true;
        } catch (Exception ex) {
            Toast.makeText ( con , ex.getMessage ( ) , Toast.LENGTH_LONG ).show ( );
            return false;
        }
    }






    public  ArrayList<com.example.icbt.userFreelance>CheckUsername(String username,String password)
    {
        ArrayList<com.example.icbt.userFreelance> userFreelanceList=new ArrayList<userFreelance>();
        try
        {
            Cursor cursor=db.rawQuery("Select * from users where username='"+username+"' AND password='"+password+"' ",null);
            if(cursor.moveToFirst())
            {
                do{
                    com.example.icbt.userFreelance userfreelance=new com.example.icbt.userFreelance ();
                    userfreelance.setUsername (cursor.getString(0));
                    userfreelance.setPassword (cursor.getString(1));
                    userFreelanceList.add(userfreelance);

                }while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return userFreelanceList;
    }

    public  ArrayList<com.example.icbt.userCustomer>CheckUsernameForcustomer(String username,String password)
    {
        ArrayList<com.example.icbt.userCustomer> userCustomerList=new ArrayList<userCustomer>();
        try
        {
            Cursor cursor=db.rawQuery("Select * from usersCustomer where username='"+username+"' AND password='"+password+"' ",null);
            if(cursor.moveToFirst())
            {
                do{
                    com.example.icbt.userCustomer usercustomer=new com.example.icbt.userCustomer ();
                    usercustomer.setUsername (cursor.getString(0));
                    usercustomer.setPassword (cursor.getString(1));
                    userCustomerList.add(usercustomer);

                }while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return userCustomerList;
    }


    public boolean postJob ( com.example.icbt.jobs jobdetails ) {
        try {
            ContentValues cv = new ContentValues();
            cv.put ( "JobType",jobdetails.getJobType () );
            cv.put ( "CustomerName",jobdetails.getCustomerName ());
            cv.put ( "CustomerEmail",jobdetails.getCustomerEmail ());
            cv.put ( "CustomerMobile",jobdetails.getCustomerMobile () );
            cv.put ( "CustomerAddress",jobdetails.getCustomerAddress ());
            cv.put ( "NumberOfRoom",jobdetails.getNumberOfRoom () );

            db.insert ( "JOBS",null,cv );
            return true;
        } catch (Exception ex) {
            Toast.makeText ( con , ex.getMessage ( ) , Toast.LENGTH_LONG ).show ( );
            return false;
        }
    }
    public Cursor SearchJobs()
    {
        Cursor cursor=null;
        try
        {
            cursor=db.rawQuery("Select ID from JOBS ",null);
            // cursor=db.rawQuery("Select JobType from JOBS ",null);
        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return cursor;
    }




    public  ArrayList<com.example.icbt.jobs>getJobData(String str)
    {
        ArrayList<com.example.icbt.jobs> jobDetailsList=new ArrayList<jobs>();
        try
        {
            Cursor cursor=db.rawQuery("Select * from JOBS where ID= '"+str+"' ",null);
           // Cursor cursor=db.rawQuery("Select * from usersCustomer where ID= '1' ",null);
            if(cursor.moveToFirst())
            {
                do{
                    com.example.icbt.jobs jobDetails=new com.example.icbt.jobs ();
                    jobDetails.setJobType (cursor.getString(1));
                   // jobDetails.getCustomerName (cursor.getString(0));
                   // jobDetails.setJobType (cursor.getString(0));
                    jobDetails.setCustomerAddress (cursor.getString(2));
                    jobDetails.setCustomerName (cursor.getString(3));
                    jobDetails.setCustomerEmail (cursor.getString(4));
                    jobDetails.setNumberOfRoom (cursor.getString(5));
                    jobDetails.setCustomerMobile (cursor.getString(6));
                    jobDetailsList.add(jobDetails);

                }while (cursor.moveToNext());
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(con, ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        return jobDetailsList;
    }




}



