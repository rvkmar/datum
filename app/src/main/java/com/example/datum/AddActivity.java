package com.example.datum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText student_id_input, student_name_input, student_grade_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        student_id_input = findViewById(R.id.student_id_input);
        student_name_input = findViewById(R.id.student_name_input);
        student_grade_input = findViewById(R.id.student_grade_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addData(student_id_input.getText().toString().trim(),
                        student_name_input.getText().toString().trim(),
                        Integer.valueOf(student_grade_input.getText().toString().trim()));

                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}