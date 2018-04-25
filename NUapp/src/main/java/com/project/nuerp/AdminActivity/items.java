package com.project.nuerp.AdminActivity;

public class items {
    private String name;
    private int enno;
    public items(String name, int enno)
    {
        this.name=name;
        this.enno=enno;
    }

    public int getId() {
        return enno;
    }

    public String getName() {
        return name;
    }
}
