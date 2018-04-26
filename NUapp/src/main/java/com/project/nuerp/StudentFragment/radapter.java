package com.project.nuerp.StudentFragment;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.nuerp.R;

import java.util.Collections;
import java.util.List;

public class radapter extends RecyclerView.Adapter<rholder>{

    private Activity activity;
    List<ticket> ticket= Collections.emptyList();
    private OnTapListener onTapListener;

    public radapter(Activity activity, List<com.project.nuerp.StudentFragment.ticket> ticket) {
        this.activity = activity;
        this.ticket = ticket;
    }


    @Override
    public rholder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_model,parent,false);
        return new rholder(view);
    }

    @Override
    public void onBindViewHolder(rholder holder, final int position) {
        holder.tic.setText(ticket.get(position).getId());
        holder.ctype.setText(ticket.get(position).getCtype());
        holder.stat.setText(ticket.get(position).getStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTapListener.OnTapView(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ticket.size();
    }
    public void setOnTapListener(OnTapListener onTapListener)
    {
        this.onTapListener=onTapListener;
    }


}
