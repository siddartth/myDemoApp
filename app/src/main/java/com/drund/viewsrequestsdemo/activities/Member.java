package com.drund.viewsrequestsdemo.activities;

public class Member {

    private String mName="sample";
    private String mJobTitle="s";
    private String mDescriptionString="this is a string";
    public int i=0;

    public Member(String mName, String mJobTitle, String mDescriptionString) {
        this.mName = mName;
        this.mJobTitle = mJobTitle;
        this.mDescriptionString = mDescriptionString;
    }
    public Member(){}
    public void setmName(String name){
        this.mName = name;
    }
    public String getmName(){
        return mName;
    }
    public void setmJobTitle(String title){
        this.mJobTitle=title;
    }
    public String getmJobTitle(){
        return mJobTitle;
    }
    public void setmDescriptionString(String description){
        this.mDescriptionString= description;
    }
    public String getmDescriptionString(){
        return mDescriptionString;
    }

}
