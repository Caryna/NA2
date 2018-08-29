package com.example.android.bookstoreapp;

/**
 * Created by Carin on 8/29/2018.
 */


import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bookstoreapp.data.BookContract.BookEntry;

/**
 * {@link BookCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of product data as its data source. This adapter knows
 * how to create list items for each row of pet data in the {@link Cursor}.
 */

public class BookCursorAdapter extends CursorAdapter {
    public BookCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        // Find each individual view that we want to modify in the list item layout
        TextView textViewName = (TextView) view.findViewById(R.id.name);
        TextView textViewQuantity = (TextView) view.findViewById(R.id.quantity_textview);
        TextView textViewPrice = (TextView) view.findViewById(R.id.price);

        // Find the columns of product attributes that we're interested in
        String name = cursor.getString(cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRODUCT_NAME));
        double price = cursor.getDouble(cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE));
        int quantity = cursor.getInt(cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY));
        final int position = cursor.getPosition();

        //Sale Button
        Button buttonSale = (Button) view.findViewById(R.id.button_sale);
        buttonSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor.moveToPosition(position);
                int currentQuantity = cursor.getInt(cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY));
                if (currentQuantity > 0) {
                    long id = cursor.getLong(cursor.getColumnIndex(BookEntry._ID));
                    Uri bookUri = ContentUris.withAppendedId(BookEntry.CONTENT_URI, id);
                    ContentValues values = new ContentValues();
                    values.put(BookEntry.COLUMN_BOOK_QUANTITY, currentQuantity - 1);
                    context.getContentResolver().update(bookUri, values, null, null);
                    Toast.makeText(context, "The sale was successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "This book is out of stock", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textViewName.setText(name);
        textViewQuantity.setText(String.valueOf(quantity) + " in stock");
        textViewPrice.setText("$" + String.valueOf(price));

    }
}
