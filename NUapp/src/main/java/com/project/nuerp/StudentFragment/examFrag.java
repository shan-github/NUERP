package com.project.nuerp.StudentFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.project.nuerp.R;

public class examFrag extends Fragment implements AdapterView.OnItemSelectedListener{

    Spinner se;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.examfrag,container,false);
        ArrayAdapter<CharSequence> adapter;
        se= (Spinner)v.findViewById(R.id.se);
        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.examOpt,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        se.setAdapter(adapter);

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    
}
