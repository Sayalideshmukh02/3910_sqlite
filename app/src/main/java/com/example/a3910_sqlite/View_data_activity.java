package com.example.a3910_sqlite;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class View_data_activity extends AppCompatActivity {
    MYDBHandler mydb;
    ArrayList<String> stud_names, stud_dept,stud_rollno;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    Button update,delete;
    @Override
    public void onBackPressed() {
//        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(getApplicationContext(),MainActivity.class);
//        setIntent.addCategory(Intent.CATEGORY_HOME);
//        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        setIntent.setAction(Intent.ACTION_SEND);
        setIntent.setType("text/plain");
        startActivity(setIntent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        recyclerView = findViewById(R.id.recycler);
        mydb = new MYDBHandler(View_data_activity.this);
        stud_names = new ArrayList<>();
        stud_dept = new ArrayList<>();
        stud_rollno = new ArrayList<>();
        storeDataInArrays();
        customAdapter = new CustomAdapter(View_data_activity.this,View_data_activity.this,stud_names,stud_dept,stud_rollno);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(View_data_activity.this));

    }

    void storeDataInArrays() {

        Cursor cursor = mydb.readAllData();
        if(cursor.getCount() == 0){

        }
        else{
            while (cursor.moveToNext()){
                stud_rollno.add(cursor.getString(0));
                stud_names.add(cursor.getString(1));
                stud_dept.add(cursor.getString(2));


            }

        }

        update = findViewById(R.id.button3);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_intent = new Intent(getApplicationContext(),Update_details.class);
                view_intent.setAction(Intent.ACTION_SEND);
                view_intent.setType("text/plain");
                startActivity(view_intent);
            }
        });

        delete = findViewById(R.id.button4);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_intent = new Intent(getApplicationContext(),    Delete_record.class);
                view_intent.setAction(Intent.ACTION_SEND);
                view_intent.setType("text/plain");
                startActivity(view_intent);
            }
        });
    }
}