package com.example.ajay.newsapp;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

public class TechNewsLoader extends AsyncTaskLoader<List<TechNews>> {

    private static final String LOG_TAG = TechNewsLoader.class.getName();

    private String mUrl;

    public TechNewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<TechNews> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<TechNews> techNews = QueryUtils.fetchNewsData(mUrl);
        return techNews;
    }


}
