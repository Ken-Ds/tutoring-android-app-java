package com.example.finalsapplication.dataType;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String ACCOUNT_TABLE = "ACCOUNT_TABLE";
    public static final String COLUMN_ACCOUNT_ID = "ACCOUNT_ID";
    public static final String COLUMN_ACCOUNT_EMAIL = "ACCOUNT_EMAIL";
    public static final String COLUMN_ACCOUNT_PASSWORD = "ACCOUNT_PASSWORD";
    public static final String COLUMN_ACCOUNT_LNAME = "ACCOUNT_LNAME";
    public static final String COLUMN_ACCOUNT_FNAME = "ACCOUNT_FNAME";
    public static final String COLUMN_ACCOUNT_GENDER = "ACCOUNT_GENDER";
    public static final String COLUMN_ACCOUNT_DATEOFBIRTH = "ACCOUNT_DATEOFBIRTH";
    public static final String COLUMN_ACCOUNT_DATEHIRED = "ACCOUNT_DATEHIRED";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = " CREATE TABLE " + ACCOUNT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ACCOUNT_ID + " INT , " + COLUMN_ACCOUNT_EMAIL + "TEXT, " + COLUMN_ACCOUNT_PASSWORD + " TEXT, " + COLUMN_ACCOUNT_LNAME + " TEXT, " + COLUMN_ACCOUNT_FNAME + " TEXT, " + COLUMN_ACCOUNT_GENDER + " TEXT, " + COLUMN_ACCOUNT_DATEOFBIRTH + " TEXT, " + COLUMN_ACCOUNT_DATEHIRED  +  " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(AccountInfo accountInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ACCOUNT_ID,accountInfo.getId());
        cv.put(COLUMN_ACCOUNT_EMAIL,accountInfo.getEmail());
        cv.put(COLUMN_ACCOUNT_PASSWORD,accountInfo.getPassword());
        cv.put(COLUMN_ACCOUNT_LNAME,accountInfo.getlName());
        cv.put(COLUMN_ACCOUNT_FNAME,accountInfo.getfName());
        cv.put(COLUMN_ACCOUNT_GENDER,accountInfo.getGender());
        cv.put(COLUMN_ACCOUNT_DATEOFBIRTH,accountInfo.getDateOfBirth());
        cv.put(COLUMN_ACCOUNT_DATEHIRED,accountInfo.getDateHired());

        long insert = db.insert(ACCOUNT_TABLE, null, cv);
        if (insert == -1){
            return false;
        }else
            return true;
    }
}
