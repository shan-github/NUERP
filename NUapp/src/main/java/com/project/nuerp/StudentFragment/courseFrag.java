package com.project.nuerp.StudentFragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.project.nuerp.R;
import com.project.nuerp.courseRecycler.cadapter;
import com.project.nuerp.courseRecycler.course;
import com.project.nuerp.dbHelper;

import java.util.ArrayList;

public class courseFrag extends Fragment{

    private dbHelper mydb;
    private RecyclerView recyclerView;
    private ArrayList<course> list =new ArrayList<course>();
    private cadapter adapter;
    Spinner sem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.coursefrag,container,false);

        ArrayAdapter<CharSequence> sadapter;
        sem= (Spinner)v.findViewById(R.id.er1);
        sadapter = ArrayAdapter.createFromResource(getActivity(),R.array.spinnersem,android.R.layout.simple_spinner_item);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sem.setAdapter(sadapter);

        mydb=new dbHelper(getContext());
        recyclerView=(RecyclerView)v.findViewById(R.id.courseRecycler);
        Cursor res=mydb.getLogin();
        res.moveToFirst();
        loadData(res.getString(5));
        return v;
    }
    private void loadData(String email)
    {

        Cursor data=mydb.getAttendence(email);
        if(data.getCount()!=0)
        {
            while(data.moveToNext())
            {
                course t=new course(data.getString(0));
                list.add(t);
            }
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        adapter=new cadapter(getActivity(),list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


}
