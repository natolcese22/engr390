package com.example.y_barham.breathleaf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME ="accounts.db";
    private static final String TABLE_NAME ="accounts";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_USERNAME ="username";
    private static final String COLUMN_PASSWORD ="password";

    SQLiteDatabase db;


    private static String TABLE_CREATE= "create table accounts (id integer primary key not null , "+
    "username text not null , password text not null);";



    @Override
    public void onCreate(SQLiteDatabase db) {

        //execute sql
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query= "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
    public Databasehelper(Context context)
    {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);


    }
    //insert a new account
    public void insertAccount(AccountInformation accountInformation){

        db = this.getWritableDatabase();
        ContentValues values=new ContentValues();

        //to get the number of accounts that are stored in the database
        //and we pass the count as an id
        String query="select * from accounts";
        Cursor cursor=db.rawQuery(query,null);

        int count=cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_USERNAME, accountInformation.getUsername());
        values.put(COLUMN_PASSWORD, accountInformation.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public String searchPassword(String usernameString) {

        db=this.getReadableDatabase();
        String query="select username, password from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);

        String username, password;
        password="not found";

        if(cursor.moveToFirst()){
            do {

              username=cursor.getString(0);//username

                if(username.equals(usernameString)){
                    password=cursor.getString(1);//password
                    break;

                }
            }while (cursor.moveToNext());

        }
        return password;
    }
}
