package com.project.nuerp.AdminActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.nuerp.Activity.mainErp;
import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

import java.util.ArrayList;
import java.util.List;

public class listAdapter extends BaseAdapter{

   dbHelper db;
    LayoutInflater inflater;
    ArrayList<items> names;
    Context c;

    public listAdapter(ArrayList<items> names, Context c) {
        this.names = names;
        this.c = c;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position,View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.item_list,parent,false);
        }

        TextView name=(TextView) convertView.findViewById(R.id.item1);
        TextView enno=(TextView) convertView.findViewById(R.id.item2);
        name.setText(names.get(position).getName());
        enno.setText(names.get(position).getId()+"");
        db=new dbHelper(c);
        final int pos =position;
        try {
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(c);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            db.delete(names.get(pos).getId());
                            Toast.makeText(c, "Deleted", Toast.LENGTH_SHORT).show();

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.setTitle("Delete "+names.get(pos).getName()+"?");
                    builder.show();

                }
            });
        }
        catch(Exception e){
            Toast.makeText(c, e+"", Toast.LENGTH_SHORT).show();
        }
        return convertView;
    }

}
