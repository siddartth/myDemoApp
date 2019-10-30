package com.drund.viewsrequestsdemo;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.drund.viewsrequestsdemo.helpers.RequestSimulator;
import com.drund.viewsrequestsdemo.helpers.RequestSimulatorCallback;
import com.google.gson.Gson;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.drund.viewsrequestsdemo.activities.MainActivity;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class CreateMember extends AppCompatActivity {
    private TextInputLayout mDisplayName;
    private TextInputLayout mJobTitle;
    private TextInputLayout mDescription;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.backarrow, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent= new Intent(CreateMember.this,MainActivity.class );
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_member);

        mDisplayName = findViewById(R.id.text_display_name);
        mJobTitle = findViewById(R.id.text_job_Title);
        mDescription = findViewById(R.id.text_description);
    }
    private boolean validateDisplayName()
    {
        String displayName = mDisplayName.getEditText().getText().toString().trim();
        if(displayName.isEmpty()){
            mDisplayName.setError("This field is required.");
            return false;
        }
        else {
            mDisplayName.setError(null);
            mDisplayName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateJobTitle()
    {
        String jobTitle = mJobTitle.getEditText().getText().toString().trim();
        if(jobTitle.isEmpty()){
            mJobTitle.setError("This field is required.");
            return false;
        }
        else {
            mJobTitle.setError(null);
            mJobTitle.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateDescription()
    {
        String description = mDescription.getEditText().getText().toString().trim();
        if(description.isEmpty()){
            mDescription.setError("This field is required.");
            return false;
        }
        else {
            mDescription.setError(null);
            mDescription.setErrorEnabled(false);
            return true;
        }
    }
    public void createMember(View v){
        if(!validateDescription() | !validateDisplayName() | !validateJobTitle())
        {
            return;
        }
        //MemberArray m = new MemberArray(mDisplayName.getEditText().getText().toString().trim(), mJobTitle.getEditText().getText().toString().trim(),mDescription.getEditText().getText().toString().trim());

        Intent intent = new Intent(CreateMember.this, MainActivity.class);
        String input = "Display Name: "+ mDisplayName.getEditText().getText().toString().trim();
        input += "\n";
        input += "Job Title: "+ mJobTitle.getEditText().getText().toString().trim();
        input += "\n";
        input += "Description: "+ mDescription.getEditText().getText().toString().trim();
        //Toast.makeText(this,input,Toast.LENGTH_SHORT).show();

        Map<String,String> request_param= new HashMap<String,String>();
        request_param.put("display_name", mDisplayName.getEditText().getText().toString().trim());
        request_param.put("job_title", mJobTitle.getEditText().getText().toString().trim());
        request_param.put("description", mDescription.getEditText().getText().toString().trim());
        RequestSimulator.post(this,request_param,"https://api.drund.com/members/create/",new RequestSimulatorCallback() {
            public void onSuccess(String response) {

                JsonParser parser = new JsonParser();
                JsonObject json_response = (JsonObject) parser.parse(response);
                String str = json_response.get("display_name").toString().trim();
                json_response.get("job_title");
                json_response.get("description");
                Display(str);
            }
            public void onFailure(String response) {
            }
        });

        startActivity(intent);
        //intent.setExtrasClassLoader();
    }
    public void Display(String str)
    {

        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();

    }
}

