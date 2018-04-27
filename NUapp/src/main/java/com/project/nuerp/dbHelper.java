package com.project.nuerp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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

       db.execSQL("create table branch(" +
               "branch_id varchar(3) primary key not null," +
               "branch_name varchar(30) not null);");

        db.execSQL("create table attendence(" +
                "email varchar(50) not null," +
                "subject varchar(50) not null," +
                "attendence int not null);");

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
        db.execSQL("create table complaint (" +
                "ticket_no varchar(20) unique not null," +
                "email_id varchar(50)," +
                "complaint_type varchar(20) not null," +
                "log_date text," +
                "description varchar(300)," +
                "status varchar(20) not null);");
        db.execSQL("insert into branch values('CSE','Computer Science'),('ECE','Electronics'),('BT','Bio Technology');");
        db.execSQL("insert into semesters values(1),(2),(3),(4),(5),(6),(7),(8)");
//        db.execSQL("insert into courses values('CSE','Computer Science'),('ECE','Electronics'),('BT','Bio Technology');");


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
    }
    public Cursor search(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data=null;
        if(name!=null)
        {
           data= db.rawQuery("select name,en_no from students where name like '%"+name+"%'; ",null);
            return data;
        }
        return data;
    }
    public void delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COL_2+"="+id, null);
    }
    public Cursor getTickets(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select * from complaint where email_id = '"+email+"';",null);
        return data;
    }
    public boolean insertTicket(String email,String ctype,String desc)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        Random rand=new Random();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String log = sdf.format(c.getTime());
        contentValues.put("ticket_no","STU1800"+rand.nextInt(8000)+"");
        contentValues.put("email_id",email);
        contentValues.put("complaint_type",ctype);
        contentValues.put("log_date",log);
        contentValues.put("description",desc);
        contentValues.put("status","open");
        long res= db.insert("complaint",null,contentValues);
        if(res==-1)
            return false;
        else
            return true;

    }
    public boolean insertAttendence(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c=new ContentValues();
        Random rand=new Random();
        String[] sub={"Operating System",
                "Design and analysis of algorithm",
                "Professional Ethics and Values",
                "Computer architecture and organization",
                "Database Management System"};
        int min=50;
        long res=-1;
        for(int i=0;i<sub.length;i++)
        {
            c.put("email",email);
            c.put("subject",sub[i]);
            c.put("attendence",min+rand.nextInt(50));
            res= db.insert("attendence",null,c);
        }
        if(res==-1)
            return false;
        else
            return true;
    }
    public Cursor getAttendence(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("select subject,attendence from attendence where email = '"+email+"';",null);
        return data;
    }
    public void updatePass(String email, String log)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_7 ,log);
        db.update(TABLE_NAME,contentValues," email_id = "+"'"+email+"'",null );
    }

}
