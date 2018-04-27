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
import com.project.nuerp.R;
import com.project.nuerp.dbHelper;
import com.project.nuerp.attRecycler.att;
import com.project.nuerp.attRecycler.attadapter;
import com.project.nuerp.attRecycler.OnTapListener;
import java.util.ArrayList;

public class attFrag extends Fragment{

    private dbHelper mydb;
    private RecyclerView recyclerView;
    private ArrayList<att> list =new ArrayList<att>();
    private attadapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.attfrag, container, false);
        mydb=new dbHelper(getContext());
        recyclerView=(RecyclerView)view.findViewById(R.id.attRecycler);
        Cursor res=mydb.getLogin();
        res.moveToFirst();
        loadData(res.getString(5));


        return view;
    }


    private void loadData(String email)
    {

        Cursor data=mydb.getAttendence(email);
        if(data.getCount()!=0)
        {
            while(data.moveToNext())
            {
                att t=new att(data.getString(0),
                        data.getString(1));
                list.add(t);

            }
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        adapter=new attadapter(getActivity(),list);
        adapter.setOnTapListener(new OnTapListener()
        {
            @Override
            public void OnTapView(int position)
            {

            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


}

