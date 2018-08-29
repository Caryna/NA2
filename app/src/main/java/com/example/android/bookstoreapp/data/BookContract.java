package com.example.android.bookstoreapp.data;

import android.provider.BaseColumns;
import android.content.ContentResolver;
import android.net.Uri;

/**
 * Created by Carin on 8/28/2018.
 */

/**
 * API Contract for the BookApp2.
 */
public final class BookContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.bookstoreapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_BOOKS = "books";

    public static final class BookEntry implements BaseColumns {

        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);


        /** Name of database table for books */
        public final static String TABLE_NAME = "books";

        /**
         * Unique ID number for the book (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_PRODUCT_NAME = "product";

        /**
         * Price of the book.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_PRICE = "name";

        /**
         * Quantity of the books.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Supplier name of the books.
         *
         * Type: STRING
         */
        public final static String COLUMN_BOOK_SUPPLIER_NAME = "supplier_name";

        /**
         * Supplier phone number of the books.
         *
         * Type: STRING
         */
        public final static String COLUMN_BOOK_SUPPLIER_PHONE_NUMBER = "supplier_phone";
    }

}

