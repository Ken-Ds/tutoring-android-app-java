package com.example.finalsapplication.dataType;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import java.io.ByteArrayOutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String ACCOUNT_TABLE = "ACCOUNT_TABLE";
    public static final String COLUMN_ACCOUNT_ID = "ACCOUNT_ID";
    public static final String COLUMN_ACCOUNT_EMAIL = "ACCOUNT_EMAIL";
    public static final String COLUMN_ACCOUNT_PASSWORD = "ACCOUNT_PASSWORD";
    public static final String COLUMN_ACCOUNT_NAME = "ACCOUNT_NAME";
    public static final String COLUMN_ACCOUNT_SEX = "ACCOUNT_SEX";
    public static final String COLUMN_ACCOUNT_DATEOFBIRTH = "ACCOUNT_DATEOFBIRTH";
    public static final String COLUMN_ACCOUNT_DATEHIRED = "ACCOUNT_DATEHIRED";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + ACCOUNT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ACCOUNT_ID + " INT, " + COLUMN_ACCOUNT_EMAIL + " TEXT, " + COLUMN_ACCOUNT_PASSWORD + " TEXT, " + COLUMN_ACCOUNT_NAME + " TEXT, " + COLUMN_ACCOUNT_SEX + " TEXT, " + COLUMN_ACCOUNT_DATEOFBIRTH + " TEXT, " + COLUMN_ACCOUNT_DATEHIRED  +  " TEXT)";

        db.execSQL(createTableStatement);

        String insertDefaultUserStatement = "INSERT INTO " + ACCOUNT_TABLE + "(" + COLUMN_ACCOUNT_ID + ", " + COLUMN_ACCOUNT_EMAIL + ", " + COLUMN_ACCOUNT_PASSWORD + ", " + COLUMN_ACCOUNT_NAME + ", " + COLUMN_ACCOUNT_SEX + ", " + COLUMN_ACCOUNT_DATEOFBIRTH + ", " + COLUMN_ACCOUNT_DATEHIRED + ") VALUES(2230908, 'emilysotelo@emicode.com', '12345', 'Emily Sotelo', 'F', '11/25/1993', '12/25/2023')";

        db.execSQL(insertDefaultUserStatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists ACCOUNT_TABLE");
    }

    public boolean addOne(AccountInfo accountInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ACCOUNT_ID,accountInfo.getId());
        cv.put(COLUMN_ACCOUNT_EMAIL,accountInfo.getEmail());
        cv.put(COLUMN_ACCOUNT_PASSWORD,accountInfo.getPassword());
        cv.put(COLUMN_ACCOUNT_NAME,accountInfo.getName());
        cv.put(COLUMN_ACCOUNT_SEX,accountInfo.getSex());
        cv.put(COLUMN_ACCOUNT_DATEOFBIRTH,accountInfo.getDateOfBirth());
        cv.put(COLUMN_ACCOUNT_DATEHIRED,accountInfo.getDateHired());

        long insert = db.insert(ACCOUNT_TABLE, null, cv);
        if (insert == -1){
            return false;
        }else
            return true;
    }

    public void updateAccount(String originalName, String newName, String newEmail, int newId){
        AccountInfo accountUpdate = new AccountInfo();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ACCOUNT_NAME, newName);
        cv.put(COLUMN_ACCOUNT_ID, newId);
        cv.put(COLUMN_ACCOUNT_EMAIL, newEmail);

        db.update(ACCOUNT_TABLE, cv," ACCOUNT_NAME = ? ", new String[]{originalName});
    }

    public Boolean checkUserEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        try (Cursor cursor = db.rawQuery("SELECT * FROM " + ACCOUNT_TABLE + " WHERE " + COLUMN_ACCOUNT_EMAIL + " = ?", new String[]{email})) {
            return cursor.getCount() > 0;
        }
    }

    public Boolean checkUserID(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        try (Cursor cursor = db.rawQuery("SELECT * FROM " + ACCOUNT_TABLE + " WHERE " + COLUMN_ACCOUNT_ID + " = ?", new String[]{id})) {
            return cursor.getCount() > 0;
        }
    }

    public Boolean checkLoginCredentials(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        try (Cursor cursor = db.rawQuery("SELECT * FROM " + ACCOUNT_TABLE + " WHERE " + COLUMN_ACCOUNT_EMAIL + " = ? AND " + COLUMN_ACCOUNT_PASSWORD + " = ?", new String[]{email, password})) {
            return cursor.getCount() > 0;
        }
    }

    public ArrayList<AccountInfo> fetchAccount(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                COLUMN_ACCOUNT_ID,
                COLUMN_ACCOUNT_EMAIL,
                COLUMN_ACCOUNT_NAME,
                COLUMN_ACCOUNT_SEX,
                COLUMN_ACCOUNT_DATEOFBIRTH,
                COLUMN_ACCOUNT_DATEHIRED
        };
        Cursor cursor = db.query(ACCOUNT_TABLE, projection, null, null, null, null, null);

        ArrayList<AccountInfo> accountInfos = new ArrayList<>();

        while (cursor.moveToNext()) {
            AccountInfo account = new AccountInfo();
            account.setId(cursor.getInt(0));
            account.setEmail(cursor.getString(1));
            account.setName(cursor.getString(2));
            account.setSex(cursor.getString(3));
            account.setDateOfBirth(cursor.getString(4));
            account.setDateHired(cursor.getString(5));

            accountInfos.add(account);
        }

        cursor.close();
        return accountInfos;
    }

    public AccountInfo getUserByEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        AccountInfo user = null;

        try (Cursor cursor = db.rawQuery("SELECT * FROM " + ACCOUNT_TABLE + " WHERE " + COLUMN_ACCOUNT_EMAIL + " = ?", new String[]{email})) {
            if (cursor.moveToFirst()) {
                int id = cursor.getInt(1);
                String password = cursor.getString(3);
                String name = cursor.getString(4);
                String sex = cursor.getString(5);
                String dateOfBirth = cursor.getString(6);
                String dateHired = cursor.getString(7);

                user = new AccountInfo(id, email, password, name, sex, dateOfBirth, dateHired);
            }
        }

        return user;
    }

        public void deleteAccount(int iD){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ACCOUNT_TABLE, " ACCOUNT_ID = ? ",new String[]{String.valueOf(iD)});
    }
}
