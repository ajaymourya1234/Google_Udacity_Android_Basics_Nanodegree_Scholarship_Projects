package com.example.ajay.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TechNewsAdapter extends ArrayAdapter<TechNews> {

    public TechNewsAdapter(Activity context, ArrayList<TechNews> techNews) {
        super(context, 0, techNews);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //get the object located at this position in thr list
        TechNews currentTechNews = getItem(position);

        //find the TextView in the list_item.xml layout with the ID title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);

        //Get the publication title from the current TechNews Object
        //set this on the TextView
        titleTextView.setText(currentTechNews.getmNewsTitle());


        //find the TextView in the list_item.xml layout with the ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        String convertedDateTime = "";
        String originalDateTime = currentTechNews.getmPublicationDate();
        String substringDateTime = originalDateTime.substring(0, 16);
        String convertedDateTime1 = substringDateTime.replace("-", ".");
        convertedDateTime = convertedDateTime1.replace("T", ", ");

        dateTextView.setText(convertedDateTime);

        //find the TextView in the list_item.xml layout with the ID section
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section);

        sectionTextView.setText(currentTechNews.getMsectionName());

        //find the TextView in the list_item.xml layout with the ID author
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.author);

        authorTextView.setText(currentTechNews.getmAuthorName());

        return listItemView;

    }

}
