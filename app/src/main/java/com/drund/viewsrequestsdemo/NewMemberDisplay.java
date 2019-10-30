package com.drund.viewsrequestsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.drund.viewsrequestsdemo.activities.RecyclerViewAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class NewMemberDisplay extends AppCompatActivity {

    public static final String ENDPOINT_GET_MEMBERS = "https://api.drund.com/members/";
    private static final String TAG = "NewMemberDisplay";
    private ArrayList<String> listName = new ArrayList<>();
    private ArrayList<String> listJobtitle = new ArrayList<>();
    private ArrayList<String> listDes = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent= new Intent(NewMemberDisplay.this, CreateMember.class);
        intent.putExtra("caller", "NewMemberDisplay");
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_member_display);
        Toast.makeText(this,"NewMember",Toast.LENGTH_SHORT).show();
        String json_string = getIntent().getExtras().getString("json_string");
        String name = getIntent().getExtras().getString("NewName");
        String title = getIntent().getExtras().getString("NewTitle");
        String des = getIntent().getExtras().getString("NewDes");
        dataParsing(json_string,name,title,des);
    }

    public void dataParsing(String Str,String name,String title,String des) {
        //creating json parsing object.
        JsonParser parser = new JsonParser();

        //json object to store the parsed response.
        JsonObject json = (JsonObject) parser.parse(Str);

        //storing the data[] into the a json Array.
        JsonArray Members = json.getAsJsonArray("data");


        listName.add(name);
        listJobtitle.add(title);
        listDes.add(des);
            Log.d(TAG, "myDataParsing: NewMember.");

        /* Using a for loop to fetch each of the Display_name - Job_Title - Description and updating them in an Array. */
        for(int i=0;i<Members.size();i++)
        {
            JsonObject Single_member = (JsonObject)Members.get(i);
            listName.add(Single_member.get("display_name").toString().trim());
            listJobtitle.add(Single_member.get("job_title").getAsString());
            listDes.add(Single_member.get("description").getAsString());


        }
        Log.d(TAG,"myDataParsing: value is parsed.");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView New MemberDisplay method: invoke.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view_display);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listName,listJobtitle,listDes,NewMemberDisplay.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
