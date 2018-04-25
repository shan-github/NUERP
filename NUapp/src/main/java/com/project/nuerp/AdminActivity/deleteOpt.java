package com.project.nuerp.AdminActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.project.nuerp.R;

public class deleteOpt extends AppCompatActivity {

    CardView student,staff,course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_opt);

        student=(CardView)findViewById(R.id.delete_stu);
        course=(CardView)findViewById(R.id.delete_course);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(deleteOpt.this,delete_student.class));
            }
        });

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(updateOpt.this,add_course.class));
            }
        });



    }
}
