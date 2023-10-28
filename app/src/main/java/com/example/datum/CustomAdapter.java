package com.example.datum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList _id, student_id, student_name, student_grade;

    CustomAdapter(Activity activity, Context context, ArrayList _id, ArrayList student_id, ArrayList student_name,
                  ArrayList student_grade){
        this.activity = activity;
        this.context = context;
        this._id = _id;
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_grade = student_grade;
    };

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.data_id_txt.setText(String.valueOf(_id.get(position)));
        holder.student_id_txt.setText(String.valueOf(student_id.get(position)));
        holder.student_name_txt.setText(String.valueOf(student_name.get(position)));
        holder.student_grade_txt.setText(String.valueOf(student_grade.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("_id",String.valueOf(_id.get(position)));
                intent.putExtra("student_id",String.valueOf(student_id.get(position)));
                intent.putExtra("student_name",String.valueOf(student_name.get(position)));
                intent.putExtra("student_grade",String.valueOf(student_grade.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return _id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView data_id_txt, student_id_txt, student_name_txt, student_grade_txt;
        LinearLayout mainLayout;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            data_id_txt = itemView.findViewById(R.id.data_id_txt);
            student_id_txt = itemView.findViewById(R.id.student_id_txt);
            student_name_txt = itemView.findViewById(R.id.student_name_txt);
            student_grade_txt = itemView.findViewById(R.id.student_grade_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
