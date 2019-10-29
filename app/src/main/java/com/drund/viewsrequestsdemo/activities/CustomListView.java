package com.drund.viewsrequestsdemo.activities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.drund.viewsrequestsdemo.R;

public class CustomListView extends ArrayAdapter<String> {

    private String[] displayname;
    private String[] jobtitle;
    private String[] description;
    private Activity context;
    public CustomListView(Activity context, String[] displayname, String[] jobtitle, String[] description) {
        super(context, R.layout.listview_layout,displayname);
        this.context=context;
        this.displayname=displayname;
        this.jobtitle=jobtitle;
        this.description=description;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){

            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) r.getTag();
        }
        viewHolder.disname.setText(displayname[position]);
        viewHolder.jtitle.setText(jobtitle[position]);
        viewHolder.des.setText(description[position]);

        return super.getView(position, convertView, parent);
    }

}
class ViewHolder
{
    TextView disname;
    TextView jtitle;
    TextView des;
    ViewHolder(View v){
        disname = v.findViewById(R.id.display_name);
        jtitle  = v.findViewById(R.id.job_title);
        des = v.findViewById(R.id.job_description);
    }
}