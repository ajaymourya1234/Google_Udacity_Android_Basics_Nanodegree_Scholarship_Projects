package com.example.ajay.inventoryapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ajay.inventoryapp.Data.InventoryContract.InventoryEntry;

public class InventoryDbHelper extends SQLiteOpenHelper {

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "inventory.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_INVENTORY_TABLE = "CREATE TABLE " + InventoryEntry.TABLE_NAME + " ("
                + InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + InventoryEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + InventoryEntry.COLUMN_PRICE + " INTEGER NOT NULL, "
                + InventoryEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0, "
                + InventoryEntry.COLUMN_SUPPLIER_NAME + " TEXT, "
                + InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER + " TEXT );";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_INVENTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}