package com.project.nuerp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class dbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "student.db";
    public static final String TABLE_NAME = "students";
    public static final String COL_1 = "name";
    public static final String COL_2 = "en_no";
    public static final String COL_3 = "program";
    public static final String COL_4 = "phone_no";
    public static final String COL_5 = "year";
    public static final String COL_6 = "email_id";
    public static final String COL_7 = "password";
    public static final String COL_8 = "login_status";


    public dbHelper(Context context) {
        super(context, DB_NAME, null, 1);
     }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table semesters" +
                " (semester integer not null primary key" +
                ");");
       db.execSQL("create table branch(branch_id varchar(3) primary key not null," +
         "branch_name varchar(30) not null);");

         db.execSQL("create table courses" +
          " (course_id varchar(10) not null primary key," +
           "course_name varchar(50) not null," +
                 "semester integer not null," +
                 "foreign key(semester) references semesters(semester)" +
            ");");

        db.execSQL("create table "+TABLE_NAME+
                "("+COL_1+" varchar(50) not null primary key,"+
                COL_2+" varchar(15) unique not null, "+
                COL_3+" varchar(10) not null, "+
                COL_4+" longblob , "+
                COL_5+" int not null, "+
                COL_6+" varchar(50) not null, "+
                COL_7+" varchar(50) not null, " +
                "gender char not null,"+
                "branch_id varchar(3)," +
                "current_sem integer not null," +
                COL_8+" int default 0," +
                "foreign key(current_sem) references semester(semester)"
                +");");
        db.execSQL("insert into branch values('CSE','Computer Science'),('ECE','Electronics'),('BT','Bio Technology');");
        db.execSQL("insert into semesters values(1),(2),(3),(4),(5),(6),(7),(8)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+"branch");
        db.execSQL("DROP TABLE IF EXISTS "+"courses");
        db.execSQL("DROP TABLE IF EXISTS "+"semester");
        onCreate(db);
    }
    public boolean insertData(String name,String enro,String program,String phone,int year,String gender,String branch,int cSem,String email,String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,enro);
        contentValues.put(COL_3,program);
        contentValues.put(COL_4,phone);
        contentValues.put(COL_5,year);
        contentValues.put(COL_6,email);
        contentValues.put(COL_7,pass);
        contentValues.put("gender",gender);
        contentValues.put("branch_id",branch);
        contentValues.put("current_sem",cSem);
        long res= db.insert(TABLE_NAME,null,contentValues);
        if(res==-1)
            return false;
        else
            return true;
    }
    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from "+TABLE_NAME,null);
        return data;

    }
    public Cursor getStudentData(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from "+TABLE_NAME+" where "+COL_6+" is "+"'"+email+"'",null);
        return data;

    }
    public Cursor getLogin()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from "+TABLE_NAME+" where "+COL_8+" = 1 ",null);
        return data;

    }

    public void updateStatus(String email, int log)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_8 ,log);
        db.update(TABLE_NAME,contentValues," email_id = "+"'"+email+"'",null );
        //return true;
    }
}
