package com.project.nuerp.StudentFragment;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.project.nuerp.R;

public class timeFrag extends Fragment{
Button downloadBtn,wrdbtn,xlbtn;
PDFView pdfView;
    DownloadManager downloadManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.timefrag,container,false);

      pdfView=(PDFView)v.findViewById(R.id.pdf);
      pdfView.fromAsset("StudentWiseTTReport.pdf").load();

        wrdbtn=(Button)v.findViewById(R.id.wrdBtn);
      downloadBtn=(Button)v.findViewById(R.id.pdfBtn);
        xlbtn=(Button)v.findViewById(R.id.xlBtn);

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadManager =(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/StudentWiseTTReport.pdf");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);

            }
        });wrdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadManager =(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/StudentWiseTTReport.doc");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);

            }
        });xlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadManager =(DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri= Uri.parse("https://raw.githubusercontent.com/shan-github/myrep/master/StudentWiseTTReport.xls");
                DownloadManager.Request request =new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long ref = downloadManager.enqueue(request);
            }
        });

        return v;

    }

}
