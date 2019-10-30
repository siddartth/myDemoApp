package com.drund.viewsrequestsdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.drund.viewsrequestsdemo.CreateMember;
import com.drund.viewsrequestsdemo.R;
import com.drund.viewsrequestsdemo.helpers.RequestSimulator;
import com.drund.viewsrequestsdemo.helpers.RequestSimulatorCallback;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String ENDPOINT_GET_MEMBERS = "https://api.drund.com/members/";
    private static final String TAG = "MainActivity";
    private ArrayList<String> listname = new ArrayList<>();
    private ArrayList<String> listjobtitle = new ArrayList<>();
    private ArrayList<String> listdes = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent= new Intent(MainActivity.this, CreateMember.class);
        intent.putExtra("caller", "Activity_Main");
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    //Main method which creates the basic container.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity: invoked.");
        onFetchData();
    }


    //This method helps to hit the URL to get a response of JSON object.
    public void onFetchData()
    {
        RequestSimulator.get(this, ENDPOINT_GET_MEMBERS, new RequestSimulatorCallback() {

            public void onSuccess(String response) {
                String Str = response;//response provides a GSON string.
                Log.d(TAG,"onSucess: response is recived.");
                dataParsing(Str);//calling parsing function.
            }
            @Override
            public void onFailure(String response) {
            }});

    }
    //Data response is parsed and assigned to a Array-list.
    public void dataParsing(String Str)
    {
        //creating json parsing object.
        JsonParser parser = new JsonParser();

        //json object to store the parsed response.
        JsonObject json = (JsonObject) parser.parse(Str);

        //storing the data[] into the a json Array.
        JsonArray Members = json.getAsJsonArray("data");

        /* Using a for loop to fetch each of the Display_name - Job_Title - Description and updating them in an Array. */
        for(int i=0;i<Members.size();i++)
        {
            JsonObject Single_member = (JsonObject)Members.get(i);
            listname.add(Single_member.get("display_name").toString().trim());
            listjobtitle.add(Single_member.get("job_title").getAsString());
            listdes.add(Single_member.get("description").getAsString());


        }
        Log.d(TAG,"myDataParsing: value is parsed.");

        initRecyclerView();
        /* toast to check the if the values are properly stored. */
        //Toast.makeText(this,"values are added in list successfully",Toast.LENGTH_LONG).show();
    }
    //Creating recycling view and setting Recycler adapter.
    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView method: invoke.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listname,listjobtitle,listdes,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}


