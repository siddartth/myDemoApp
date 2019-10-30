package com.drund.viewsrequestsdemo.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.drund.viewsrequestsdemo.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    //Array list variables created for the recyclerview.
    //private ArrayList<String> imageName =  new ArrayList<>();
    private ArrayList<String> displayName =  new ArrayList<>();
    private ArrayList<String> jobTitle =  new ArrayList<>();
    private ArrayList<String> description =  new ArrayList<>();
    private Context context;

    //View adapter created.
    public RecyclerViewAdapter(ArrayList<String> displayName, ArrayList<String> jobTitle, ArrayList<String> description, Context context) {
        //this.imageName = imageName;
        this.displayName = displayName;
        this.jobTitle = jobTitle;
        this.description = description;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_memberdetails,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: is called.");
        viewHolder.displayname.setText(displayName.get(i));
        viewHolder.jobtitle.setText(jobTitle.get(i));
        viewHolder.des.setText(description.get(i));
    }

    //determines the number of times the row is generated.
    @Override
    public int getItemCount() {
        return displayName.size();
    }

    //Creating text view and the parent layout for referencing the widget.
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView displayname;
        TextView jobtitle;
        TextView des;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            displayname = itemView.findViewById(R.id.mdisplayname);
            jobtitle = itemView.findViewById(R.id.mjobtitle);
            des = itemView.findViewById(R.id.mdescription);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
