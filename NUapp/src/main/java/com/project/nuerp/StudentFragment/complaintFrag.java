package com.project.nuerp.StudentFragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

import java.util.ArrayList;

public class complaintFrag extends Fragment{
    private RecyclerView recyclerView;
    private dbHelper mydb;
    private ArrayList<ticket> tickeList =new ArrayList<ticket>();
    private radapter adapter;
    Button create;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.compfrag,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler);
        mydb=new dbHelper(getContext());
        create=(Button)v.findViewById(R.id.ticket);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), createComp.class));
            }
        });
        Cursor res=mydb.getLogin();
        res.moveToFirst();
        loadData(res.getString(5));
        return v;
    }


    private void loadData(String email)
    {

        Cursor data=mydb.getTickets(email);
        if(data.getCount()!=0)
        {
            while(data.moveToNext())
            {
                ticket t=new ticket(data.getString(0)
                        ,data.getString(2),
                        data.getString(5));
                tickeList.add(t);

            }
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        adapter=new radapter(getActivity(),tickeList);
        adapter.setOnTapListener(new OnTapListener()
        {
            @Override
            public void OnTapView(int position) {

            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

}
