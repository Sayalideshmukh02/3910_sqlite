package com.example.a3910_sqlite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList stud_names, stud_dept,stud_rollno;

    CustomAdapter(Activity activity, Context context, ArrayList names, ArrayList dept,ArrayList rollno){
        this.activity = activity;
        this.context = context;
        this.stud_names = names;
        this.stud_dept = dept;
        this.stud_rollno = rollno;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.stud_name_txt.setText(String.valueOf(stud_names.get(position)));
        holder.dept_txt.setText(String.valueOf(stud_dept.get(position)));
        holder.roll_txt.setText(String.valueOf(stud_rollno.get(position)));
    }

    @Override
    public int getItemCount() {
        return stud_names.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView stud_name_txt,dept_txt,roll_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            stud_name_txt= itemView.findViewById(R.id.student_name);
            dept_txt = itemView.findViewById(R.id.student_department);
            roll_txt = itemView.findViewById(R.id.student_rollno);

        }

    }

}