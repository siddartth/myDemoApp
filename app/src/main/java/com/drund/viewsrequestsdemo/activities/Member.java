package com.drund.viewsrequestsdemo.activities;

public class Member {

    private  String name;
    private String title;
    private String mdescription;

    public Member(String name, String title, String mdescription) {
        this.name = name;
        this.title = title;
        this.mdescription = mdescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMdescription(String mdescription) {
        this.mdescription = mdescription;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getMdescription() {
        return mdescription;
    }
}
