package com.example.ajay.newsapp;

public class TechNews {

    //Title of the news
    private String mNewsTitle;

    //date of publication
    private String mDate;

    public TechNews(String mNewsTitle, String mDate) {
        this.mNewsTitle = mNewsTitle;
        this.mDate = mDate;
    }

    public String getmNewsTitle() {
        return mNewsTitle;
    }


    public String getmDate() {
        return mDate;
    }


}
