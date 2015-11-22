package com.example.nitin.sefinal;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test extends Activity{



    MyDbHelper mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    SimpleCursorAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mHelper = new MyDbHelper(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mDb = mHelper.getWritableDatabase();

    }

    @Override
    public void onPause() {
        super.onPause();
        mDb.close();
        mCursor.close();
    }



}
