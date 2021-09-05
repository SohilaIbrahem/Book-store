package com.example.booksstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sqlite extends SQLiteOpenHelper {


    public Sqlite(@Nullable Context context) {
        super(context, "Books.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase ggggg) {
        ggggg.execSQL(" create table books ( Id Integer PRIMARY KEY AUTOINCREMENT  , BookName Text , Disc Text , Type Integer )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS books " );
        onCreate(sqLiteDatabase);

    }


    public boolean InsertData (String name , String dis ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put("BookName" , name);
        values.put("Disc" , dis);

        long check = db.insert("books" , null , values);
        if(check == -1){
            return false;
        }else {
            return true;
        }

    }

    public Cursor ViewData (){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" select * from books" , null);
        return cursor;

    }


    public void UpdateData (int id , String name , String dis , int type ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values =new ContentValues();
        values.put("BookName" , name);
        values.put("Disc" , dis);
        values.put("Type" , type);

        db.update("books" , values , " Id = ? " , new String[] {String.valueOf(id)});


    }
}
