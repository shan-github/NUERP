package com.project.nuerp.StudentFragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.project.nuerp.R;

public class rholder extends RecyclerView.ViewHolder {

    public TextView tic,ctype,stat;

    public rholder(View itemView) {
        super(itemView);
        tic=(TextView)itemView.findViewById(R.id.tictext);
        ctype=(TextView)itemView.findViewById(R.id.type);
        stat=(TextView)itemView.findViewById(R.id.status);
    }

}
