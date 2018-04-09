package com.project.nuerp.AdminActivity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

public class addFrag extends AppCompatActivity {
EditText name,enro,program,phone,year,email,pass,branch;
Button addbtn;
RadioButton m,f;
    dbHelper mydb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_students);
    mydb=new dbHelper(this);
        name=(EditText)findViewById(R.id.name);
        enro=(EditText)findViewById(R.id.enro);
        program=(EditText)findViewById(R.id.program);
        year=(EditText)findViewById(R.id.year);
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);
        phone=(EditText)findViewById(R.id.phone);
        branch=(EditText)findViewById(R.id.branch);
        addbtn =(Button)findViewById(R.id.addBtn);
        m=(RadioButton)findViewById(R.id.male);
        f=(RadioButton)findViewById(R.id.female);

        addData();


    }

    public void addData()
    {

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ok= validate(new EditText[]{enro,program,name,phone,year,email,pass});
                if(ok)
                {
                    String g="";
                    if(m.isChecked() || f.isChecked())
                    {
                        if(m.isChecked())
                            g="m";
                        else
                            g="f";
                    }
                    else
                    {
                        Toast.makeText(addFrag.this,"Select gender",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    int y=Integer.parseInt(year.getText().toString());
                    boolean done=mydb.insertData(name.getText().toString(),
                            enro.getText().toString(),
                            program.getText().toString(),
                            phone.getText().toString(),
                            y,g,
                            branch.getText().toString(),
                            y+1,
                            email.getText().toString(),
                            pass.getText().toString()

                    );

                    if(done)
                            Snackbar.make(v,"Data inserted Successfully",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                    else
                        Toast.makeText(addFrag.this,"Unable to insert data!!",Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(addFrag.this,"Unable to insert data!!",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private boolean validate(EditText[] fields)
    {
        for(int i = 0; i < fields.length; i++){
            EditText currentField = fields[i];
            if(currentField.getText().toString().length() <= 0){
                return false;
            }
        }
        return true;
    }
   }
