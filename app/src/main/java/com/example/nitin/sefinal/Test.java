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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test extends Activity{

    Button btn;
    EditText sid;
    EditText spass;

    MyDbHelper mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    SimpleCursorAdapter mAdapter;
    String Table_Name= "student";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btn_login);
        sid=(EditText)findViewById(R.id.editText_studentID);
        spass=(EditText)findViewById(R.id.editText_password);

        mHelper = new MyDbHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String stid=sid.getText().toString();

                String stpass=spass.getText().toString();

                Cursor row1 = mHelper.getStudent();
                row1.moveToFirst();



                String sid = row1.getString(1);

                String spass = row1.getString(2);

                System.out.println("..................... =>"+sid);
                System.out.println(spass);

                System.out.println("......textvalue............... =>"+stid);
                System.out.println("..................... =>"+stpass);

                if(stid.equalsIgnoreCase(sid) && stpass.equalsIgnoreCase(spass)){

                    Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "StudentId or Password is Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
