package com.example.android.newsfeedapp;

/**
 * Created by Carin on 8/24/2018.
 */

/**
 * This object contains information related to a single news
 */

public class News {

    private String mSectionName;
    private String mWebTitle;
    private String mUrl;
    private String mDate;
    private String mAuthor;

    /**
     * Constructs a new {@link News} object.
     */

    public News(String sectionName, String webTitle, String date, String author, String url) {
        mSectionName = sectionName;
        mWebTitle = webTitle;
        mDate=date;
        mAuthor=author;
        mUrl = url;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getWebTitle() {
        return mWebTitle;
    }

    public String getDate() {
        return mDate;
    }

    public String getAuthor() {
        return mAuthor;
    }
    /**
     * Returns the website URL to find more information about the article.
     */
    public String getUrl() {
        return mUrl;
    }
}
