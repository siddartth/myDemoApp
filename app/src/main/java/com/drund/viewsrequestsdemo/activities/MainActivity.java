package com.drund.viewsrequestsdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.drund.viewsrequestsdemo.Create_Member;
import com.drund.viewsrequestsdemo.R;

public class MainActivity extends AppCompatActivity {

    public boolean onCreateOption(Menu menu)
    { //creating a menu button on the tool bar.
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button moveToCreateMember = (Button) findViewById(R.id.createMember);
        moveToCreateMember.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view)
            {
                Intent intent= new Intent(MainActivity.this, Create_Member.class);
                startActivity(intent);
            }
        });
    }
}
