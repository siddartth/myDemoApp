package com.drund.viewsrequestsdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.drund.viewsrequestsdemo.Create_Member;
import com.drund.viewsrequestsdemo.R;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView title;
    TextView des;
    SimpleCursorAdapter adapter;
    int j;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent= new Intent(MainActivity.this, Create_Member.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.display_name);
        title = (TextView) findViewById(R.id.job_title);
        des = (TextView) findViewById(R.id.job_description);
        //MemberArray m = new MemberArray();
        /*if(m.members[0].getmName()!=null){
            String n = m.members[0].getmName().toString().trim();
            String t = m.members[0].getmJobTitle().toString().trim();
            String d = m.members[0].getmDescriptionString().toString().trim();
            name.setText(n);
            title.setText(t);
            des.setText(d);
        }*/
        Member m = new Member();
        if(m.getmName()!=null)
        {
            name.setText(m.getmName());
            title.setText(m.getmJobTitle());
            des.setText(m.getmDescriptionString());
        }
        else{

            name.setText("Add Display Name.");
            title.setText("please provide Job Title.");
            des.setText("Add your own Description.");

        }

    }
}
