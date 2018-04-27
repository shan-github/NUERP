package com.project.nuerp.courseRecycler;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.nuerp.R;

import java.util.Collections;
import java.util.List;

public class cadapter extends RecyclerView.Adapter<cholder>{

    private Activity activity;
    List<course> c = Collections.emptyList();
  private OnTapListener onTapListener;

    public cadapter(Activity activity, List<course> c) {
        this.activity = activity;
        this.c = c;
    }


    @Override
    public cholder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_model,parent,false);
        return new cholder(view);
    }

    @Override
    public void onBindViewHolder(cholder holder, final int position) {
        holder.sub.setText(c.get(position).getSubject());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return c.size();
    }
    public void setOnTapListener(OnTapListener onTapListener)
    {
        this.onTapListener=onTapListener;
    }


}
