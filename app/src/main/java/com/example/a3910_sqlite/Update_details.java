package com.example.a3910_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Update_details extends AppCompatActivity {
    MYDBHandler mydb;
    EditText rollno, name, dept;

    @Override
    public void onBackPressed() {
//        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(getApplicationContext(),View_data_activity.class);
//        setIntent.addCategory(Intent.CATEGORY_HOME);
//        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        setIntent.setAction(Intent.ACTION_SEND);
        setIntent.setType("text/plain");
        startActivity(setIntent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_details);


        Button update = findViewById(R.id.button3);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno = findViewById(R.id.editTextNumber);
                name = findViewById((R.id.editTextTextPersonName));
                dept = findViewById((R.id.editTextTextPersonName2));
                mydb = new MYDBHandler(Update_details.this);

                String roll = rollno.getText().toString();
                String uname = name.getText().toString();
                String udept = dept.getText().toString();
                Long r =mydb.Update_data(roll,uname,udept);
                if(r == -1){
                    Toast.makeText(Update_details.this, "Failed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Update_details.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                }

            }
        });






    }

}