package com.drund.viewsrequestsdemo.activities;

import android.content.Context;
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
import android.widget.ListView;
import android.widget.ScrollView;
import com.google.gson.Gson;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.drund.viewsrequestsdemo.Create_Member;
import com.drund.viewsrequestsdemo.R;
import com.drund.viewsrequestsdemo.helpers.RequestSimulator;
import com.drund.viewsrequestsdemo.helpers.RequestSimulatorCallback;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    public static final String ENDPOINT_CREATE_MEMBER = "https://api.drund.com/members/create/";
    public static final String ENDPOINT_GET_MEMBERS = "https://api.drund.com/members/";
    public static final String ENDPOINT_GET_MEMBER_HOBBIES = "https://api.drund.com/members/%d/hobbies/";
    TextView name;
    TextView title;
    TextView des;
    SimpleCursorAdapter adapter;
    String str;
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

        onDisplay();

            name.setText("Display Name.");
            title.setText("please provide Job Title.");




    }
    public void onDisplay()
    {
        RequestSimulator.get(this, ENDPOINT_GET_MEMBERS, new RequestSimulatorCallback() {


       public void onSuccess(String response) {
           JsonParser parser = new JsonParser();
           JsonObject json = (JsonObject) parser.parse(response);
           JsonArray Members = json.getAsJsonArray("data");
           for(int i=0;i< 2;i++)
           {
               JsonObject Single_member=(JsonObject)Members.get(i);
               name.setText(Single_member.get("display_name").toString().trim());
               title.setText(Single_member.get("id").toString().trim());

           }
        String Str = response;
        displayToast(Str);
     }
        @Override
        public void onFailure(String response) {
         // TODO: Handle unsuccessful request response
                              }});

    }
    public void displayToast(String Str)
    {
        des = (TextView) findViewById(R.id.job_description);
        des.setText(Str);
        Toast.makeText(this,Str,Toast.LENGTH_LONG).show();
    }
}
