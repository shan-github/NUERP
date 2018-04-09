package com.project.nuerp.StudentFragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

public class profileFrag extends Fragment{
    dbHelper mydb;
    TextView enro,t,prog,ph,email;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.profilefrag,container,false);
        t=(TextView)v.findViewById(R.id.uname);
        enro=(TextView)v.findViewById(R.id.enno);
        prog=(TextView)v.findViewById(R.id.prog);
        ph=(TextView)v.findViewById(R.id.ph);
        email=(TextView)v.findViewById(R.id.em);
        mydb =new dbHelper(getContext());
        Cursor res = mydb.getLogin();
        res.moveToFirst();
        t.setText(res.getString(0));
        enro.setText(res.getString(1));
        prog.setText(res.getString(2));
        ph.setText(res.getString(3));
        email.setText(res.getString(5));

        return v;
    }


    
}
