package com.example.nitin.sefinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

class MyDbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mydb";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "student";
    public static final String COL_NAME = "sId";
    public static final String COL_PASSWORD = "sPassword";
    private static final String STRING_CREATE = "CREATE TABLE "+TABLE_NAME+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_NAME+" TEXT, "+COL_PASSWORD+" TEXT);";

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(STRING_CREATE);
        ContentValues cv = new ContentValues(2);
        addStudent("1001241807", "password");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addStudent(String stuid,String pass)

    {

        ContentValues values=new ContentValues(2);

        values.put("studentId", stuid);

        values.put("password", pass);

        getWritableDatabase().insert("student", "studentId", values);

    }


    public Cursor getStudent()

    {

        Cursor cursor = getReadableDatabase().rawQuery("select * from student where _id=1", null);

        return cursor;

    }
}
