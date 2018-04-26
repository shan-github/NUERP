package com.project.nuerp.StudentFragment;

public class ticket {
    String id;
    String ctype;
    String status;

    public ticket(String id,String ctype,String status)
    {
        this.id=id;
        this.ctype=ctype;
        this.status=status;
    }
    public String getId() {
        return id;
    }
    public String getCtype() {
        return ctype;
    }
    public String getStatus() {
        return status;
    }



}
