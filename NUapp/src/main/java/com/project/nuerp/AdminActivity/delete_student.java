package com.project.nuerp.AdminActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

import java.util.ArrayList;

public class delete_student extends AppCompatActivity {

    dbHelper mydb;
    ListView listView;
    SearchView sv;
    ArrayList<items> nameArray = new ArrayList<>();
    listAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_delete_students);
        listView = (ListView) findViewById(R.id.listView);
        sv = (SearchView) findViewById(R.id.delsearch);
        mydb = new dbHelper(this);
        adapter = new listAdapter(nameArray, this);

        sv.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                listView.setAdapter(null);
                return false;
            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                getnames(text);
                return false;
            }
        });


    }

    private void getnames(String name) {
        if (name != null) {
            nameArray.clear();
            items item = null;
            Cursor data = mydb.search(name);
            while (data.moveToNext()) {
                String sname = data.getString(0);
                int enro = data.getInt(1);
                item = new items(sname, enro);
                nameArray.add(item);
            }
            listView.setAdapter(adapter);
        }
        else {
            listView.setAdapter(null);
        }
    }
}
