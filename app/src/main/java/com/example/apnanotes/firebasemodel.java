package com.example.apnanotes;

import com.google.android.material.textfield.TextInputEditText;

import com.google.firebase.Timestamp;


public class firebasemodel {

    private  String title;
    private  String content;
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public firebasemodel()
    {

    }
    public firebasemodel(String title, String content, Timestamp timestamp)
    {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


