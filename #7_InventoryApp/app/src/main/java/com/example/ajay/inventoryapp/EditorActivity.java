package com.example.ajay.inventoryapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajay.inventoryapp.Data.InventoryContract.InventoryEntry;

public class EditorActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    private static final int EXISTING_ITEM_LOADER = 0;

    private Uri mCurrentItemUri;

    private EditText mProductNameEditText;
    private EditText mPriceEditText;
    private EditText mQuantityEditText;
    private EditText mSupplierNameEditText;
    private EditText mSupplierPhoneNoEditText;

    private Button increamentButton;
    private Button decreamentButton;

    private Button contactButton;

    private int id;

    private boolean editmode = false;

    private boolean mItemHasChanged = false;

    private boolean saveSuccess = true;

    String productNameString;
    String productPriceString;
    String quantityString;
    String supplierNameString;
    String supplierPhoneNo;

    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mItemHasChanged = true;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        contactButton = (Button) findViewById(R.id.contact_supplier);
        contactButton.setVisibility(View.GONE);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);

        Intent intent = getIntent();
        mCurrentItemUri = intent.getData();

        id = (int) getIntent().getLongExtra("ROW_ID", -1);

        Log.v("message", "id value " + id);

        if (mCurrentItemUri == null) {
            setTitle(R.string.editor_activity_title_new_item);

            invalidateOptionsMenu();

        } else {
            contactButton.setVisibility(View.VISIBLE);
            editmode = true;
            setTitle(R.string.editor_activity_title_edit_item);
            getLoaderManager().initLoader(EXISTING_ITEM_LOADER, null, this);

        }
        mProductNameEditText = (EditText) findViewById(R.id.edit_product_name);
        mPriceEditText = (EditText) findViewById(R.id.edit_price);
        mQuantityEditText = (EditText) findViewById(R.id.edit_quantity);
        mSupplierNameEditText = (EditText) findViewById(R.id.edit_supplier_name);
        mSupplierPhoneNoEditText = (EditText) findViewById(R.id.edit_supplier_number);

        mProductNameEditText.setOnTouchListener(mTouchListener);
        mPriceEditText.setOnTouchListener(mTouchListener);
        mQuantityEditText.setOnTouchListener(mTouchListener);
        mSupplierNameEditText.setOnTouchListener(mTouchListener);
        mSupplierPhoneNoEditText.setOnTouchListener(mTouchListener);

        increamentButton = (Button) findViewById(R.id.increase_quantity);
        decreamentButton = (Button) findViewById(R.id.decrease_quantity);

        increamentButton.setOnClickListener(this);
        decreamentButton.setOnClickListener(this);

    }


    private void saveData() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        productNameString = mProductNameEditText.getText().toString().trim();
        productPriceString = mPriceEditText.getText().toString().trim();

        quantityString = mQuantityEditText.getText().toString().trim();

        supplierNameString = mSupplierNameEditText.getText().toString().trim();
        supplierPhoneNo = mSupplierPhoneNoEditText.getText().toString().trim();

        if (mCurrentItemUri == null &&
                TextUtils.isEmpty(productNameString) && TextUtils.isEmpty(productPriceString) &&
                TextUtils.isEmpty(quantityString) && TextUtils.isEmpty(supplierNameString) &&
                TextUtils.isEmpty(supplierPhoneNo)) {
            return;
        }

        if (TextUtils.isEmpty(productNameString)) {
            //set error accordingly
            mProductNameEditText.requestFocus();
            mProductNameEditText.setError(getString(R.string.name_error));
            Toast.makeText(this, R.string.name_error,
                    Toast.LENGTH_SHORT).show();             //indicate save wasn't successful
            saveSuccess = false;
            return;
        } else {
            //update save success flag if validation succeeds
            saveSuccess = true;
        }

        if (TextUtils.isEmpty(productPriceString)) {
            //set error accordingly
            mPriceEditText.requestFocus();
            mPriceEditText.setError(getString(R.string.price_error));
            Toast.makeText(this, R.string.price_error,
                    Toast.LENGTH_SHORT).show();            //indicate save wasn't successful
            saveSuccess = false;
            return;
        } else {
            //update save success flag if validation succeeds
            saveSuccess = true;
        }

        if (TextUtils.isEmpty(quantityString)) {
            //set error accordingly
            mQuantityEditText.requestFocus();
            mQuantityEditText.setError(getString(R.string.quantity_error));
            Toast.makeText(this, R.string.quantity_error,
                    Toast.LENGTH_SHORT).show();            //indicate save wasn't successful
            saveSuccess = false;
            return;
        } else {
            //update save success flag if validation succeeds
            saveSuccess = true;
        }

        if (TextUtils.isEmpty(supplierNameString)) {
            //set error accordingly
            mProductNameEditText.requestFocus();
            mSupplierNameEditText.setError(getString(R.string.supplier_name_error));
            Toast.makeText(this, R.string.supplier_name_error,
                    Toast.LENGTH_SHORT).show();            //indicate save wasn't successful
            saveSuccess = false;
            return;
        } else {
            //update save success flag if validation succeeds
            saveSuccess = true;
        }

        if (TextUtils.isEmpty(supplierPhoneNo)) {
            //set error accordingly
            mSupplierPhoneNoEditText.requestFocus();
            mSupplierPhoneNoEditText.setError(getString(R.string.supplier_phone_error));
            Toast.makeText(this, R.string.supplier_phone_error,
                    Toast.LENGTH_SHORT).show();            //indicate save wasn't successful
            saveSuccess = false;
            return;
        } else {
            //update save success flag if validation succeeds
            saveSuccess = true;
        }

        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_PRODUCT_NAME, productNameString);
        values.put(InventoryEntry.COLUMN_PRICE, productPriceString);
        values.put(InventoryEntry.COLUMN_QUANTITY, quantityString);
        values.put(InventoryEntry.COLUMN_SUPPLIER_NAME, supplierNameString);
        values.put(InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER, supplierPhoneNo);

        if (mCurrentItemUri == null) {

            Uri newUri = getContentResolver().insert(InventoryEntry.CONTENT_URI, values);

            // Show a toast message depending on whether or not the insertion was successful.
            if (newUri == null) {
                // If the new content URI is null, then there was an error with insertion.
                Toast.makeText(this, getString(R.string.editor_update_item_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                // Otherwise, the insertion was successful and we can display a toast.
                Toast.makeText(this, getString(R.string.editor_update_item_successful),
                        Toast.LENGTH_SHORT).show();
            }
        } else {

            int rowsAffected = getContentResolver().update(mCurrentItemUri, values, null, null);

            // Show a toast message depending on whether or not the update was successful.
            if (rowsAffected == 0) {
                // If no rows were affected, then there was an error with the update.
                Toast.makeText(this, getString(R.string.editor_update_item_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                // Otherwise, the update was successful and we can display a toast.
                Toast.makeText(this, getString(R.string.editor_update_item_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        if (mCurrentItemUri == null) {
            MenuItem menuItem = menu.findItem(R.id.action_delete);
            menuItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                saveData();
                if (saveSuccess) {
                    finish();
                    return true;
                }
                return false;

            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:

                showDeleteConfirmationDialog();

                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:

                if (!mItemHasChanged) {
                    NavUtils.navigateUpFromSameTask(EditorActivity.this);
                    return true;
                }
                // Otherwise if there are unsaved changes, setup a dialog to warn the user.
                // Create a click listener to handle the user confirming that
                // changes should be discarded.
                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // User clicked "Discard" button, navigate to parent activity.
                                NavUtils.navigateUpFromSameTask(EditorActivity.this);
                            }
                        };

                // Show a dialog that notifies the user they have unsaved changes
                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method is called when the back button is pressed.
     */
    @Override
    public void onBackPressed() {

        if (!mItemHasChanged) {
            super.onBackPressed();
            return;
        }
    }

    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Keep editing" button, so dismiss the dialog
                // and continue editing the Data.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void showDeleteConfirmationDialog() {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the postivie and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Delete" button, so delete the pet.
                deleteItem();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Cancel" button, so dismiss the dialog
                // and continue editing the Data.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * Perform the deletion of the pet in the database.
     */
    private void deleteItem() {

        if (mCurrentItemUri != null) {

            int rowsDeleted = getContentResolver().delete(mCurrentItemUri, null, null);
            // Show a toast message depending on whether or not the delete was successful.
            if (rowsDeleted == 0) {
                // If no rows were deleted, then there was an error with the delete.
                Toast.makeText(this, getString(R.string.editor_delete_item_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                // Otherwise, the delete was successful and we can display a toast.
                Toast.makeText(this, getString(R.string.editor_delete_item_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }

        finish();
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                InventoryEntry._ID,
                InventoryEntry.COLUMN_PRODUCT_NAME,
                InventoryEntry.COLUMN_PRICE,
                InventoryEntry.COLUMN_QUANTITY,
                InventoryEntry.COLUMN_SUPPLIER_NAME,
                InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER};

        return new CursorLoader(this,
                InventoryEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor != null && editmode) {
            cursor.moveToPosition(id - 1);
            // Find the columns of pet attributes that we're interested in
            int nameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRODUCT_NAME);
            int priceColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_QUANTITY);
            int supplierNameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_NAME);
            int supplierPhoneNoColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER);

            // Extract out the value from the Cursor for the given column index
            String name = cursor.getString(nameColumnIndex);
            String price = cursor.getString(priceColumnIndex);
            final String quantity = cursor.getString(quantityColumnIndex);
            String supplierName = cursor.getString(supplierNameColumnIndex);
            final String supplierPhoneNo = cursor.getString(supplierPhoneNoColumnIndex);

            // Update the views on the screen with the values from the database
            mProductNameEditText.setText(name);
            mPriceEditText.setText(String.valueOf(price));
            mQuantityEditText.setText(String.valueOf(quantity));
            mSupplierNameEditText.setText(supplierName);
            mSupplierPhoneNoEditText.setText(supplierPhoneNo);


            contactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + supplierPhoneNo));

                    if (ActivityCompat.checkSelfPermission(EditorActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Log.v("message", "intent permission error");
                        return;
                    }
                    startActivity(intent);
                }
            });
            cursor.close();
        } else if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            // Find the columns of pet attributes that we're interested in
            int nameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRODUCT_NAME);
            int priceColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_QUANTITY);
            int supplierNameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_NAME);
            int supplierPhoneNoColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_PHONE_NUMBER);

            // Extract out the value from the Cursor for the given column index
            String name = cursor.getString(nameColumnIndex);
            String price = cursor.getString(priceColumnIndex);
            final String quantity = cursor.getString(quantityColumnIndex);
            String supplierName = cursor.getString(supplierNameColumnIndex);
            final String supplierPhoneNo = cursor.getString(supplierPhoneNoColumnIndex);

            // Update the views on the screen with the values from the database
            mProductNameEditText.setText(name);
            mPriceEditText.setText(String.valueOf(price));
            mQuantityEditText.setText(String.valueOf(quantity));
            mSupplierNameEditText.setText(supplierName);
            mSupplierPhoneNoEditText.setText(supplierPhoneNo);

            cursor.close();
        }
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mProductNameEditText.setText("");
        mPriceEditText.setText("");
        mQuantityEditText.setText("");
        mSupplierNameEditText.setText("");
        mSupplierPhoneNoEditText.setText("");

    }


    @Override
    public void onClick(View view) {
        //declare and initialize variable to hold and update quantity
        int quantity = 0;
        if (mQuantityEditText.getText().length() > 0) {
            //fetch the quantity from the edit text
            quantity = Integer.parseInt(mQuantityEditText.getText().toString());
        }

        switch (view.getId()) {
            //handle incrementing the quantity
            case R.id.increase_quantity:
                quantity++;
                updateQuantity(quantity);
                break;
            //handle decrementing the quantity
            case R.id.decrease_quantity:
                if (quantity > 0) {
                    quantity--;
                    updateQuantity(quantity);
                } else {
                    Toast toast = Toast.makeText(this, "negative quantity error", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
        }
    }

    private void updateQuantity(int quantity) {
        //update the edit text with the new value, clear error alert if any
        mQuantityEditText.setText(String.valueOf(quantity));
        mQuantityEditText.setSelection(mQuantityEditText.getText().length());
        mQuantityEditText.setError(null);
    }
}