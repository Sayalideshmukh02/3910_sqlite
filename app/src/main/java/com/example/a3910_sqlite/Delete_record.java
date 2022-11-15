package com.example.a3910_sqlite;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class Delete_record extends AppCompatActivity  {
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
        setContentView(R.layout.delete_record);


        Button delete = findViewById(R.id.button3);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno = findViewById(R.id.editTextNumber);

                mydb = new MYDBHandler(Delete_record.this);
                String roll = rollno.getText().toString();

                Long r =mydb.Delete_data(roll);
                if(r == -1){
                    Toast.makeText(Delete_record.this, "Failed to Delete.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Delete_record.this, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
