package com.drund.viewsrequestsdemo.activities;

public class MemberArray {
    Member[] members = new Member[15];
    int j=0;


    public MemberArray(String name, String title, String Description)
    {
        members[j]=new Member(name, title, Description);
        j++;
    }
    public  MemberArray(){

    }

    public Member[] getMembers(){
        return members;
    }
}
