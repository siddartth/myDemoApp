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

    public static final String ENDPOINT_GET_MEMBERS = "https://api.drund.com/members/";
    ListView lv;
    String[] displayname={"tom","Jack","Jhon Wick", "joson Stathum"};
    String[] jobtitle={"Android dev","IOS dev","IOS dev","Android dev"};
    String[] description={"works well","lets check","lets check","lets check"};


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
        //Initiate service call to fetch data.
        onFetchData();
        //list view id is linked with the listView container.

        //lv = findViewById(R.id.listview_main);

    }

    // Hitting the get method to get data from the URL.
    public void onFetchData()
    {
        RequestSimulator.get(this, ENDPOINT_GET_MEMBERS, new RequestSimulatorCallback() {


       public void onSuccess(String response) {
        String Str = response;//response provides a GSON string.
           myDataParsing(Str);//calling parsing function.
     }
        @Override
        public void onFailure(String response) {
                              }});

    }

    //To create the Json object into Array.

    public void myDataParsing(String Str)
    {
        //creating json parsing object.
        JsonParser parser = new JsonParser();
        //json object to store the parsed response.
        JsonObject json = (JsonObject) parser.parse(Str);
        //storing the data[] into the a json Array.
        JsonArray Members = json.getAsJsonArray("data");

        /* Using a for loop to fetch each of the Display_name - Job_Title - Description and updating them in an Array. */
        //for(int i=0;i<Members.size();i++)
        //{
            JsonObject Single_member = (JsonObject)Members.get(3);
            //displayname[0]=Single_member.get("display_name").toString().trim();
            //jobtitle[0]=Single_member.get("job_title").toString().trim();
            //description[0]=Single_member.get("description").toString().trim();
        //}
        // toast to check the if the values are properly stored.
        Toast.makeText(this,"Display name : "+Single_member.get("display_name").toString().trim()+"jobtitle : "+Single_member.get("job_title").toString().trim()+"display name 2: "+Single_member.get("description").toString().trim(),Toast.LENGTH_LONG).show();
        /*CustomListView customListView;
        customListView = new CustomListView(this, displayname,jobtitle,description);
        lv.setAdapter(customListView);*/
    }
}
