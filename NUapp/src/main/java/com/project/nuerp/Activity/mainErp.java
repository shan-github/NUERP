package com.project.nuerp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.project.nuerp.R;
import com.project.nuerp.Settings;
import com.project.nuerp.StudentFragment.attFrag;
import com.project.nuerp.StudentFragment.courseFrag;
import com.project.nuerp.StudentFragment.timeFrag;
import com.project.nuerp.dbHelper;
import com.project.nuerp.StudentFragment.examFrag;
import com.project.nuerp.StudentFragment.feeFrag;
import com.project.nuerp.StudentFragment.profileFrag;
import com.project.nuerp.StudentFragment.regFrag;


public class mainErp extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
dbHelper mydb;
boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_erp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press Back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_erp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, Settings.class));
            return true;
        }
        if (id == R.id.about) {
            AlertDialog.Builder builder =new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("About");
            builder.setMessage("NIIT University ERP App \n v.1.0.0");
            builder.show();

            return true;
        }
        if (id == R.id.hostel) {
            StringBuffer stringBuffer =new StringBuffer();
            stringBuffer.append("Hostel: "+/*res.getString(0)+*/"\n"+
                    "Room no.: "+/*res.getString(1)+*/"\n"+
                    "Bed no.: "+/*res.getString(2)+*/"\n"+
                    "Alloted date: "+/*res.getString(3)+*/"\n"+
                    "Effective start date: "+/*res.getString(4)+*/"\n"+
                    "Effective end date: "+/*res.getString(5)+*/"\n"+
                    "Room type: "+/*res.getString(6)+*/"\n"+
                    "location:"+/*res.getString(7)+*/"\n"
            );
            AlertDialog.Builder builder =new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Hostel details:");
            builder.setMessage(stringBuffer.toString());
            builder.show();

            return true;
        }
        if (id == R.id.changePwd) {

            AlertDialog.Builder builder =new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.alert_pwd, null);
            builder.setView(dialogView);

           final EditText input1=(EditText)findViewById(R.id.current);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                    Toast.makeText(mainErp.this, "Changed", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(mainErp.this, "Cancelled", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setCancelable(true);
            builder.setTitle("Change Password");
            builder.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.dashboard) {
            setTitle("Dashboard");
            FragmentTransaction fragmentTransaction;
            FragmentManager fragmentManager= getSupportFragmentManager();
            Fragment fragment=fragmentManager.findFragmentById(R.id.mfragment);
            if(fragment!=null)
            {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(fragment).commit();
            }

        } else if (id == R.id.att) {
            setTitle("Attendence");
            attFrag attend =new attFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mfragment,attend).commit();

        } else if (id == R.id.course) {
            setTitle("Course Detail");
            courseFrag course =new courseFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mfragment,course).commit();

        } else if (id == R.id.nav_fee) {
            setTitle("Fee Detail");
            feeFrag fee =new feeFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mfragment,fee).commit();

        } else if (id == R.id.reg) {
            setTitle("Registration");
            regFrag reg =new regFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mfragment,reg).commit();


        }else if (id == R.id.profile) {
            setTitle("Profile");
            profileFrag pro =new profileFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mfragment,pro).commit();


        }
        else if (id == R.id.nav_exam) {
            setTitle("Exam Details");
            examFrag exam =new examFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mfragment,exam).commit();

        }else if (id == R.id.nav_time) {
            setTitle("Time table");
            timeFrag time =new timeFrag();
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.mfragment,time).commit();

        }else if (id == R.id.logout)
        {
                mydb=new dbHelper(this);
                Cursor log=mydb.getLogin();
                log.moveToFirst();
                Toast.makeText(this, "Thank you", Toast.LENGTH_SHORT).show();
                mydb.updateStatus(
                        log.getString(5),
                        0);
                startActivity(new Intent(this,home.class));
                finish();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
