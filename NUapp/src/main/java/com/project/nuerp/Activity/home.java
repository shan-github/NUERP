package com.project.nuerp.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.nuerp.AdminActivity.adminHome;
import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

public class home extends AppCompatActivity {
    EditText email,pass;
    Button loginbtn,adminbtn;
    dbHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        adminbtn=(Button) findViewById(R.id.adminBtn);
        email=(EditText)findViewById(R.id.email_text);
        pass=(EditText)findViewById(R.id.pass_Text);
        loginbtn=(Button)findViewById(R.id.login);
        mydb=new dbHelper(this);
        login();
        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this,adminHome.class));
            }
        });

    }
    private void login() {
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email_id=email.getText().toString();
                String password=pass.getText().toString();
                Cursor res = mydb.getStudentData(email_id);
                if(email_id.isEmpty() && password.isEmpty())
                    Toast.makeText(home.this, "Empty fields", Toast.LENGTH_SHORT).show();
                else if(res.getCount()==0)
                    Toast.makeText(home.this, "Invalid Email ID", Toast.LENGTH_SHORT).show();
                else
                {
                    res.moveToFirst();
                    if(email_id.equalsIgnoreCase(res.getString(5)) &&
                            password.contentEquals(res.getString(6)))
                    {
                        Toast.makeText(home.this, "Logged in as\n"+res.getString(0)+" ", Toast.LENGTH_LONG).show();
                        mydb.updateStatus( res.getString(5),
                                1);
                        startActivity(new Intent(home.this,mainErp.class));

                        finish();
                    }
                    else
                    {
                        Toast.makeText(home.this, "Unable to login", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
