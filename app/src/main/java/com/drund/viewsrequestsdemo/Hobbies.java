package com.drund.viewsrequestsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.drund.viewsrequestsdemo.activities.RecyclerViewAdapter;
import com.drund.viewsrequestsdemo.activities.RecyclerViewAdapterHobbies;
import com.drund.viewsrequestsdemo.helpers.RequestSimulator;
import com.drund.viewsrequestsdemo.helpers.RequestSimulatorCallback;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class Hobbies extends AppCompatActivity {
    //this class is not used created for futer reference.

    private static final String TAG = "Hobbies";
    public static final String ENDPOINT_GET_MEMBER_HOBBIES = "https://api.drund.com/members/%d/hobbies/";
    private ArrayList<String> hobbiesType = new ArrayList<>();
    private ArrayList<String> hobbiesValue = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
    }
    public void onFetchData()
    {
        RequestSimulator.get(this, ENDPOINT_GET_MEMBER_HOBBIES, new RequestSimulatorCallback() {
            @Override
            public void onSuccess(String response) {

            }

            @Override
            public void onFailure(String response) {
                String Str = response;//response provides a GSON string.
                Log.d(TAG,"onFailer: response is recived.");
                dataParsing(Str);//calling parsing function.
            }
        });
    }

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
            hobbiesType.add(Single_member.get("title").toString().trim());
            hobbiesValue.add(Single_member.get("skill_level").getAsString());

        }
        Log.d(TAG,"myDataParsing: value is parsed.");

        initRecyclerView();
        /* toast to check the if the values are properly stored. */
        //Toast.makeText(this,"values are added in list successfully",Toast.LENGTH_LONG).show();
    }
    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView method: invoke.");
        RecyclerView recyclerView = findViewById(R.id.hobbies);
        RecyclerViewAdapterHobbies adapter = new RecyclerViewAdapterHobbies(hobbiesValue,hobbiesValue,this);
        //recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
