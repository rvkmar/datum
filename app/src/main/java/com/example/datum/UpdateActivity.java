package com.example.datum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText student_id_input, student_name_input, student_grade_input;
    Button update_button;
    String _id, student_id, student_name, student_grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        student_id_input = findViewById(R.id.student_id_input2);
        student_name_input = findViewById(R.id.student_name_input2);
        student_grade_input = findViewById(R.id.student_grade_input2);
        update_button = findViewById(R.id.update_button);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    void getIntentData(){
        if(getIntent().hasExtra("_id") && getIntent().hasExtra("student_id") &&
                getIntent().hasExtra("student_name")&& getIntent().hasExtra("student_grade")){
            _id = getIntent().getStringExtra("_id");

        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}