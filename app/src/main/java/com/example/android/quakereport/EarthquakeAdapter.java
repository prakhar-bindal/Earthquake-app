package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by prakhar on 16/10/16.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> words)
    {
        super(context,0,words);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Earthquake currentword = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentword.getmag());
        nameTextView.setText(output);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView loc1TextView = (TextView) listItemView.findViewById(R.id.location1);
        TextView loc2TextView = (TextView) listItemView.findViewById(R.id.location2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        String loc1 = currentword.getplace();
        String loc2;
        int o = loc1.indexOf("of");
        if(o!=-1)
        {
            loc2=loc1.substring(o+3);
            loc1=loc1.substring(0,o+2);
        }
        else
        {

            loc2=loc1;
            loc1=getContext().getString(R.string.near_the);
        }

        loc1TextView.setText(loc1);
        loc2TextView.setText(loc2);


        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        TextView TimeTextView = (TextView) listItemView.findViewById(R.id.time);

        long temp = currentword.getdate();
        Date dateObject = new Date(temp);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormat.format(dateObject);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        dateTextView.setText(dateToDisplay);
        TimeTextView.setText(timeToDisplay);

        return listItemView;
    }
}