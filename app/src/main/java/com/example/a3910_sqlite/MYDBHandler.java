package com.example.a3910_sqlite;
import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MYDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "college.db";
    public static final String TABLE_STUDENTS = "Student";

    public MYDBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE = "CREATE TABLE STUDENTS (Roll_No int PRIMARY KEY,NAME TEXT, DEPT TEXT)";
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS STUDENT");
        onCreate(db);
    }
    public boolean insert_data(int roll, String name,String dept){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("Roll_No",roll);
        val.put("NAME",name);
        val.put("DEPT",dept);
        long result = db.insert("STUDENTS",null,val);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    Cursor readAllData(){
        String query = "SELECT * FROM STUDENTS";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public long Update_data(String rollno,String name,String dept){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put("NAME",name);
        val.put("DEPT",dept);

        long result = db.update("STUDENTS", val, "Roll_No=?", new String[]{rollno});
//        if(result == -1){
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
//        }
        return result;
    }

    public long Delete_data(String rollno){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();

        long result = db.delete("STUDENTS", "Roll_No=?", new String[]{rollno});
        return result;
    }

//   public long deleteAllData(){
//       SQLiteDatabase db = this.getWritableDatabase();
//        long result = db.delete("STUDENTS", null, null);
//        return result;
//    }

}