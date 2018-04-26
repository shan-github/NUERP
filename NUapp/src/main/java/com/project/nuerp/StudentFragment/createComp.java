package com.project.nuerp.StudentFragment;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class createComp extends AppCompatActivity {
Spinner s;
Button save;
dbHelper mydb;
EditText textarea;
TextView lb,mail,contact,lo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comp);
        save=(Button)findViewById(R.id.save);
        ArrayAdapter<CharSequence> adapter;
        s= (Spinner)findViewById(R.id.ctype);
        mydb=new dbHelper(this);
        textarea=(EditText)findViewById(R.id.Textarea);
        lb=(TextView)findViewById(R.id.lb);
        mail=(TextView) findViewById(R.id.mail);
        contact=(TextView)findViewById(R.id.contact);
        lo=(TextView)findViewById(R.id.lo);

        Cursor res=mydb.getLogin();
        res.moveToFirst();
        lb.setText(res.getString(0).toUpperCase());
        mail.setText(res.getString(5));
        contact.setText(res.getString(3));
        lo.setText(new SimpleDateFormat("dd-MM-yyyy ").format(Calendar.getInstance().getTime()));

        adapter = ArrayAdapter.createFromResource(this,R.array.ctype,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ctype=s.getSelectedItem().toString();
                if(ctype.equals("select"))
                {
                    Toast.makeText(createComp.this, "Select complaint type", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Cursor c=mydb.getLogin();
                    c.moveToFirst();
                    Boolean res=mydb.insertTicket(c.getString(5),ctype,textarea.getText().toString());
                    if(res)
                    {
                        Toast.makeText(createComp.this, "Complaint filed successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText(createComp.this, "Try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
