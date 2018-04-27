package com.project.nuerp.attRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.nuerp.R;

public class attholder extends RecyclerView.ViewHolder {

    public TextView sub,attText;

    public attholder(View itemView)
    {
        super(itemView);
        sub=(TextView)itemView.findViewById(R.id.subject);
        attText=(TextView)itemView.findViewById(R.id.att);
    }

}
