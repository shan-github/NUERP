package com.project.nuerp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.nuerp.AdminActivity.adminHome;
import com.project.nuerp.R;

public class home extends AppCompatActivity {
    Button c1,c2,adminbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        c1=(Button) findViewById(R.id.cd1);
        c2=(Button) findViewById(R.id.cd2);
        adminbtn=(Button) findViewById(R.id.adminBtn);
        /*c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this,student_login.class));
            }
        });*/
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this,student_login.class));
            }
        });
        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this,adminHome.class));
            }
        });

    }
}
