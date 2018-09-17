package com.example.ajay.newsapp;

public class TechNews {

    //Title of the news
    private String mNewsTitle;

    //date of publication
    private String mPublicationDate;

    //url of the publication
    private String mWebUrl;

    //sectionName of the publication
    private String msectionName;

    //AuthorName of the publication
    private String mAuthorName;


    public TechNews(String mNewsTitle, String mPublicationDate, String mWebUrl, String msectionName, String mAuthorName) {
        this.mNewsTitle = mNewsTitle;
        this.mPublicationDate = mPublicationDate;
        this.mWebUrl = mWebUrl;
        this.msectionName = msectionName;
        this.mAuthorName = mAuthorName;
    }

    public String getmNewsTitle() {
        return mNewsTitle;
    }


    public String getmPublicationDate() {
        return mPublicationDate;
    }

    public String getmWebUrl() {
        return mWebUrl;
    }

    public String getMsectionName() {
        return msectionName;
    }

    public String getmAuthorName() {
        return mAuthorName;
    }
}
