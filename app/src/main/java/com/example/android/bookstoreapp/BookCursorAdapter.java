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
import com.example.android.bookstoreapp.data.BookContract.BookEntry;

public class BookCursorAdapter extends CursorAdapter {
    public BookCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context,final Cursor cursor) {
        TextView textViewName = (TextView) view.findViewById(R.id.name);
        TextView textViewQuantity = (TextView) view.findViewById(R.id.quantity_textview);
        TextView textViewPrice = (TextView) view.findViewById(R.id.price);

        String name = cursor.getString(cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRODUCT_NAME));
        double price = cursor.getDouble(cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE));
        int quantity = cursor.getInt(cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY));
        final int position = cursor.getPosition();

        ImageButton buttonSale = (ImageButton) view.findViewById(R.id.button_sale);
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
                } else {return;}
            }
        });

        textViewName.setText(name);
        textViewQuantity.setText(String.valueOf(quantity) + " in stock");
        textViewPrice.setText("$"+ String.valueOf(price));

    }
}
