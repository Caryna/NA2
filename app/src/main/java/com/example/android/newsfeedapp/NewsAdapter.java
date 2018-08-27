package com.example.android.newsfeedapp;

/**
 * Created by Carin on 8/24/2018.
 */

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;

public class NewsAdapter extends ArrayAdapter<News> {


    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TextView sectionView = (TextView) listItemView.findViewById(R.id.sectionName);
        TextView webTitleView = (TextView) listItemView.findViewById(R.id.webTitle);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);

        // Find the article at the given position in the list of news
        News currentNews = getItem(position);

        sectionView.setText(currentNews.getSectionName());
        webTitleView.setText(currentNews.getWebTitle());
        dateView.setText(currentNews.getDate());
        authorView.setText(currentNews.getAuthor());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
