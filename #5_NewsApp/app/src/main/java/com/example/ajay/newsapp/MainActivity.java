package com.example.ajay.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a ArrayList of TechNews objects
        ArrayList<TechNews> techNews = new ArrayList<TechNews>();
        techNews.add(new TechNews("my tech news 1","date and time"));
        techNews.add(new TechNews("my tech news 1","date and time"));
        techNews.add(new TechNews("my tech news 1","date and time"));
        techNews.add(new TechNews("my tech news 1","date and time"));
        techNews.add(new TechNews("my tech news 1","date and time"));
        techNews.add(new TechNews("my tech news 1","date and time"));
        techNews.add(new TechNews("my tech news 1","date and time"));


        TechNewsAdapter technewsAdapter =  new TechNewsAdapter(this,techNews);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView technewsListView = (ListView) findViewById(R.id.list);
        technewsListView.setAdapter(technewsAdapter);


    }
}
