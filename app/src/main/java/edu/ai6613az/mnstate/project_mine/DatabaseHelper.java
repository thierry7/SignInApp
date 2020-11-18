package edu.ai6613az.mnstate.project_mine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "emp.db";
    public static final String TABLE_NAME = "empTable";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table " + TABLE_NAME + "(id INTEGER PRIMARY KEY, fname text, mname text, lname text, phone text )");
        } catch (SQLiteAbortException e) {
            try {
                throw new IOException(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insert(String s, String s1, String s2, String s3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("fname", s);
        contentValues.put("mname", s1);
        contentValues.put("lname", s2);
        contentValues.put("phone", s3);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public ArrayList retrievementEmployees() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor result = db.rawQuery("select* from " + TABLE_NAME, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            String lnameStr = result.getString(result.getColumnIndex("fname"));
            String mnameStr = result.getString(result.getColumnIndex("mname"));
            String fnameStr = result.getString(result.getColumnIndex("lname"));
            String phoneStr = result.getString(result.getColumnIndex("phone"));

            arrayList.add(lnameStr);
            arrayList.add(mnameStr);
            arrayList.add(fnameStr);
            arrayList.add(phoneStr);

            result.moveToNext();
        }

        return arrayList;
    }

    public ArrayList retrievementNameEmployees() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor result = db.rawQuery("select* from " + TABLE_NAME, null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            String lnameStr = result.getString(result.getColumnIndex("fname"));
            arrayList.add(lnameStr);
            result.moveToNext();
        }

        return arrayList;
    }

    public ArrayList SortNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor result = db.query(TABLE_NAME, null, null,
                null, null, null, "fname" + " DESC", null);
        result.moveToFirst();
        while (result.isAfterLast() == false) {
            String lnameStr = result.getString(result.getColumnIndex("fname"));
            arrayList.add(lnameStr);
            result.moveToNext();
        }

        return arrayList;
    }


    public void deleteRow(String value) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + "fname" + " = '" + value + "'";

        Log.d(TAG, "deleteName: Deleting " + value + " from database.");
        db.execSQL(query);
    }
    public long getProfilesCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();
        return count;
    }

}