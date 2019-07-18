package com.baba.todoapp;

import android.widget.EditText;

public class Notes {
    public String id;
    public String tital;
    public String desc;

    public Notes() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTital() {
        return tital;
    }

    public void setTital(String tital) {
        this.tital = tital;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Notes(String id, String tital, String desc) {

        this.id =id;
        this.tital=tital;
        this.desc = desc;
    }

}
