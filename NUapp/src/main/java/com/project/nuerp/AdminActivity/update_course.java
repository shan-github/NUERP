package com.project.nuerp.AdminActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

public class update_course extends AppCompatActivity{

    dbHelper mydb;
    Button update;
    EditText enro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_update_students);

        mydb=new dbHelper(this);


    }
}
