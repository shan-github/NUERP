package com.project.nuerp.AdminActivity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

import com.project.nuerp.R;

public class addOpt extends AppCompatActivity {

    CardView student,staff,course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_opt);

        student=(CardView)findViewById(R.id.stu);
        staff=(CardView)findViewById(R.id.staff);
        course=(CardView)findViewById(R.id.add_course);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(addOpt.this,addFrag.class));
            }
        });

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(addOpt.this,add_course.class));
            }
        });



    }
}
