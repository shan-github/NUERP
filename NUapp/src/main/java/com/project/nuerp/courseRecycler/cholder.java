package com.project.nuerp.courseRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.nuerp.R;

public class cholder extends RecyclerView.ViewHolder {

    public TextView sub;

    public cholder(View itemView)
    {
        super(itemView);
        sub=(TextView)itemView.findViewById(R.id.cText);
    }

}
