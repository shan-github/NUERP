package com.project.nuerp.AdminActivity;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

public class adminHome extends AppCompatActivity {
CardView a1,a2,a3,a4;
dbHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        mydb=new dbHelper(this);

        a1=(CardView)findViewById(R.id.a1);
        a2=(CardView)findViewById(R.id.a2);
        a3=(CardView)findViewById(R.id.a3);
        a4=(CardView)findViewById(R.id.a4);
       a1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(adminHome.this,addOpt.class));
           }
       });
       viewData();

    }
    public void viewData()
    {
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getData();
                Snackbar.make(v,"No. of students:"+res.getCount(),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                StringBuffer stringBuffer =new StringBuffer();
                if(res.getCount()==0)
                {
                    showMessage("Error","No Data");
                    return;
                }
                while(res.moveToNext())
                {
                    stringBuffer.append("Name: "+res.getString(0)+"\n"+
                            "Enrollment no.: "+res.getString(1)+"\n"+
                            "program: "+res.getString(2)+"\n"+
                            "phone: "+res.getString(3)+"\n"+
                            "year: "+res.getString(4)+"\n"+
                            "email id: "+res.getString(5)+"\n"+
                            "password: "+res.getString(6)+"\n"+
                            "login status:"+res.getString(10)+"\n"
                            +"---------------------------------\n"
                    );

                }
                showMessage("Students:",stringBuffer.toString());

            }
        });
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
