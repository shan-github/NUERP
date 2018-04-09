package com.project.nuerp.StudentFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.project.nuerp.R;

import java.text.DateFormat;
import java.util.Calendar;

public class attFrag extends Fragment implements AdapterView.OnItemSelectedListener{
    Spinner s1;
    Spinner s2;
    ArrayAdapter<CharSequence> adapter1;
    ArrayAdapter<CharSequence> adapter2;

    Calendar date =Calendar.getInstance();
    private Button dateFrom;
    private Button dateTo;
    private TextView dateTextF;
    private TextView dateTextT;
    DateFormat dateFormat =DateFormat.getDateInstance();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.attfrag, container, false);
//datepicker stuff
        dateFrom=(Button) view.findViewById(R.id.from);
        dateTo=(Button) view.findViewById(R.id.to);
        dateTextF=(TextView)view.findViewById(R.id.d1);
        dateTextT=(TextView)view.findViewById(R.id.d2);

        dateTextF.setText("Jan 7,2018");
        dateTextT.setText(dateFormat.format(date.getTime()));


        dateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDateF();
            }
        });

        dateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDateT();
            }
        });


//Spinners stuff
        s1= (Spinner)view.findViewById(R.id.s1);
        s2= (Spinner)view.findViewById(R.id.s2);

        adapter1 = ArrayAdapter.createFromResource(getActivity(),R.array.spinnerdate,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter1);

        adapter2 = ArrayAdapter.createFromResource(getActivity(),R.array.spinnersem,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);
        s2.setOnItemSelectedListener(this);

        return view;
    }



    private void updateTextT()
    {
        dateTextT.setText(dateFormat.format(date.getTime()));
    }
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            date.set(Calendar.YEAR,year);
            date.set(Calendar.MONTH,month);
            date.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            updateTextT();
        }
    };
    private void updateDateT() {
       DatePickerDialog dp = new DatePickerDialog(getActivity(),d,date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH));
       dp.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        Calendar to= Calendar.getInstance();
        to.set(2018,0,7);
        dp.getDatePicker().setMinDate(to.getTimeInMillis() );
       dp.show();
    }
    DatePickerDialog.OnDateSetListener d1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            date.set(Calendar.YEAR,year);
            date.set(Calendar.MONTH,month);
            date.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            updateTextF();
        }
    };


    private void updateTextF()
    {
        dateTextF.setText(dateFormat.format(date.getTime()));
    }

    private void updateDateF() {
        DatePickerDialog dp1= new DatePickerDialog(getActivity(),d1,2018,0,7);
        dp1.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        Calendar from= Calendar.getInstance();
        from.set(2018,0,7);
        dp1.getDatePicker().setMinDate(from.getTimeInMillis() );
        dp1.show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

