package com.project.nuerp.AdminActivity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

public class add_course extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner s1,s2;
    ArrayAdapter<CharSequence> adapter1;
    ArrayAdapter<CharSequence> adapter2;
    dbHelper mydb;
    Button addc;
    EditText cname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb=new dbHelper(this);
        setContentView(R.layout.add_course);
        s1= (Spinner)findViewById(R.id.cid);
        s2= (Spinner)findViewById(R.id.sem);
        addc=(Button)findViewById(R.id.addC);
        cname=(EditText)findViewById(R.id.cname);

        adapter1 = ArrayAdapter.createFromResource(this,R.array.course,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter1);

        adapter2 = ArrayAdapter.createFromResource(this,R.array.spinnersem,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);
        s2.setOnItemSelectedListener(this);

        addc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cname.getText().toString().isEmpty())
                {
                    cname.setError("Course name cannot be empty!");
                }
                else
                    Snackbar.make(v,"Course added",Snackbar.LENGTH_SHORT).setAction("Action",null).show();

            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
