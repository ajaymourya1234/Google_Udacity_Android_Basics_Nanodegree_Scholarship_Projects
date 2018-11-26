package com.example.ajay.inventoryapp;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajay.inventoryapp.Data.InventoryContract;

public class InventoryCursorAdapter extends CursorAdapter {

    private Context mContext;

    public InventoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        mContext = context;
        // Find fields to populate in inflated template
        TextView nameTextView = (TextView) view.findViewById(R.id.item_name);
        TextView priceTextView = (TextView) view.findViewById(R.id.item_cost);
        final TextView QuantityTextView = (TextView) view.findViewById(R.id.list_quantity);

        //int rowIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME);
        int priceColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_QUANTITY);
        int supplierColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME);
        int supplierPhoneColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER);

        //final int rowId = (int) cursor.getLong(rowIndex);
        final String itemName = cursor.getString(nameColumnIndex);
        final int itemPrice = cursor.getInt(priceColumnIndex);
        final int quantity = cursor.getInt(quantityColumnIndex);
        final String suppliername = cursor.getString(supplierColumnIndex);
        final String supplierPhone = cursor.getString(supplierPhoneColumnIndex);

        nameTextView.setText(itemName);
        priceTextView.setText(String.valueOf(itemPrice));
        QuantityTextView.setText(String.valueOf(quantity));

        Button sellButton = (Button) view.findViewById(R.id.sale_button);
        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view != null) {
                    Object obj = view.getTag();
                    String st = obj.toString();
                    ContentValues values = new ContentValues();
                    values.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME, itemName);
                    values.put(InventoryContract.InventoryEntry.COLUMN_PRICE, itemPrice);
                    values.put(InventoryContract.InventoryEntry.COLUMN_QUANTITY, quantity >= 1 ? quantity - 1 : 0);
                    values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME, suppliername);
                    values.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER, supplierPhone);

                    Uri currentPetUri = ContentUris.withAppendedId(InventoryContract.InventoryEntry.CONTENT_URI, Integer.parseInt(st));

                    int rowsAffected = mContext.getContentResolver().update(currentPetUri, values, null, null);
                    if (rowsAffected == 0 || quantity == 0) {
                        Toast.makeText(mContext, "failled", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Object obj = cursor.getInt(cursor.getColumnIndex(InventoryContract.InventoryEntry._ID));
        sellButton.setTag(obj);
    }

}