package com.project.nuerp.attRecycler;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.nuerp.R;

import java.util.Collections;
import java.util.List;

public class attadapter extends RecyclerView.Adapter<attholder>{

    private Activity activity;
    List<att> att = Collections.emptyList();
  private OnTapListener onTapListener;

    public attadapter(Activity activity, List<att> att) {
        this.activity = activity;
        this.att = att;
    }


    @Override
    public attholder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.att_model,parent,false);
        return new attholder(view);
    }

    @Override
    public void onBindViewHolder(attholder holder, final int position) {
        holder.attText.setText(att.get(position).getAttendence()+"%");
        holder.sub.setText(att.get(position).getSubject());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return att.size();
    }
    public void setOnTapListener(OnTapListener onTapListener)
    {
        this.onTapListener=onTapListener;
    }


}
