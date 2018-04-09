package com.project.nuerp.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.project.nuerp.R;
import com.project.nuerp.dbHelper;

public class splashScreen extends AppCompatActivity {

dbHelper mydb;
private static int splash_time_out = 500;
Animation myanim;
ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mydb=new dbHelper(this);

       im=(ImageView)findViewById(R.id.im);
        myanim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
        im.startAnimation(myanim);
        final Cursor log = mydb.getData();
        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            boolean flag=false;
            int status ;

            while (log.moveToNext()){
               status= Integer.parseInt( log.getString(10));
                if(status==0)
                    continue;
                else
                {
                    flag=true;
                    break;
                }
            }
            if(flag)
             startActivity(new Intent(splashScreen.this,mainErp.class));
            else
                startActivity(new Intent(splashScreen.this,home.class));

            finish();
        }
    },splash_time_out);



    }

}
