package com.project.nuerp.StudentFragment;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.nuerp.R;

public class downloadFrag extends Fragment{
DownloadManager downloadManager;
CardView c1,c2,c3,c4,c5,c6,c7;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.downfrag,container,false);
        c1=(CardView)v.findViewById(R.id.dcard1);
        c2=(CardView)v.findViewById(R.id.dcard2);
        c3=(CardView)v.findViewById(R.id.dcard3);
        c4=(CardView)v.findViewById(R.id.dcard4);
        c5=(CardView)v.findViewById(R.id.dcard5);
        c6=(CardView)v.findViewById(R.id.dcard6);
        c7=(CardView)v.findViewById(R.id.dcard7);
        downloadManager =(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/Sample_Student_handbook.pdf");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/Placement%20Policy.PDF");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/IP%20Policy_CIC.PDF");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/IP_Process.PDF");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/CIC_Placement%20Policy.PDF");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/Warden_ContactNo.XLSX");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/Medical_facilities_at_NU.PDF");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);
            }
        });


        return v;
    }
    
}
