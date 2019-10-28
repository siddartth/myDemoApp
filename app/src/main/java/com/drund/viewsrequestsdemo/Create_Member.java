package com.drund.viewsrequestsdemo;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.drund.viewsrequestsdemo.activities.MainActivity;
import com.drund.viewsrequestsdemo.activities.Member;
import com.drund.viewsrequestsdemo.activities.MemberArray;

public class Create_Member extends AppCompatActivity {
    private TextInputLayout mDisplayName;
    private TextInputLayout mJobTitle;
    private TextInputLayout mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__member);

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
        Member m = new Member();
        m.setmName(mDisplayName.getEditText().getText().toString().trim());
        m.setmJobTitle(mJobTitle.getEditText().getText().toString().trim());
        m.setmDescriptionString(mDescription.getEditText().getText().toString().trim());
        Intent intent = new Intent(Create_Member.this, MainActivity.class);
        String input = "Display Name: "+ mDisplayName.getEditText().getText().toString().trim();
        input += "\n";
        input += "Job Title: "+ mJobTitle.getEditText().getText().toString().trim();
        input += "\n";
        input += "Description: "+ mDescription.getEditText().getText().toString().trim();
        Toast.makeText(this,input,Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
