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
//this is not used - for future reference.
public class RecyclerViewAdapterHobbies {

    private static final String TAG = "RecyclerViewAdapterHobb";
    private ArrayList<String> hobbiesType =  new ArrayList<>();
    private ArrayList<String> hobbiesValue =  new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterHobbies(ArrayList<String> hobbiesType, ArrayList<String> hobbiesValue, Context context) {
        this.hobbiesType = hobbiesType;
        this.hobbiesValue = hobbiesValue;
        this.context = context;
    }

    @NonNull

    public RecyclerViewAdapterHobbies.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_hobbies,parent,false);
        RecyclerViewAdapterHobbies.ViewHolder holder = new RecyclerViewAdapterHobbies.ViewHolder(view);

        return holder;
    }


    public void onBindViewHolder(@NonNull RecyclerViewAdapterHobbies.ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: is called.");
        viewHolder.hobbtype.setText(hobbiesType.get(i));
        viewHolder.hobbvalue.setText(hobbiesValue.get(i));

    }


    public int getItemCount() {
        return hobbiesType.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView hobbtype;
        TextView hobbvalue;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hobbtype = itemView.findViewById(R.id.hobbyType);
            hobbvalue = itemView.findViewById(R.id.mjobtitle);
            parentLayout = itemView.findViewById(R.id.parent_layout_hobby);
        }
    }

}
