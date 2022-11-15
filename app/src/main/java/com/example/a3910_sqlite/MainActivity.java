package com.example.a3910_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText rollno, name, dept;
    Button insert,view_data,update,delete;
    MYDBHandler mydb;
    ArrayList<String> stud_names, stud_dept;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollno = findViewById(R.id.editTextNumber);
        name = findViewById((R.id.editTextTextPersonName));
        dept = findViewById((R.id.editTextTextPersonName2));
        mydb = new MYDBHandler(MainActivity.this);
        stud_names = new ArrayList<>();
        stud_dept = new ArrayList<>();

        insert = findViewById(R.id.button);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int roll = Integer.parseInt(rollno.getText().toString());
                String uname = name.getText().toString();
                String udept = dept.getText().toString();
                boolean r =mydb.insert_data(roll,uname,udept);
                if (r){
                    Toast.makeText(MainActivity.this, "Added successfully!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "error Already added!",Toast.LENGTH_SHORT).show();

                }

            }
        });
        view_data = findViewById(R.id.button2);
        view_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_intent = new Intent(getApplicationContext(),View_data_activity.class);
                view_intent.setAction(Intent.ACTION_SEND);
                view_intent.setType("text/plain");
                startActivity(view_intent);

            }
        });
        //storeDataInArrays();
//        update = findViewById(R.id.button3);
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent view_intent = new Intent();
//                view_intent.setAction(Intent.ACTION_SEND);
//                view_intent.setType("text/plain");
//                startActivity(view_intent);
//            }
//        });

//        delete = findViewById(R.id.button4);
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent view_intent = new Intent();
//                view_intent.setAction(Intent.ACTION_SEND);
//                view_intent.setType("text/plain");
//                startActivity(view_intent);
//            }
//        });

    }
    void storeDataInArrays(){
        Cursor c = mydb.readAllData();

    }
}