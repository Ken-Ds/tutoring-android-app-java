package com.example.finalsapplication.dataType;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import com.example.finalsapplication.AddUser;

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
    public static final String COLUMN_ACCOUNT_IMAGE = "ACCOUNT_IMAGE";

    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageInBytes;

    public DatabaseHelper(@Nullable Context context) {
        super(context, "account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + ACCOUNT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ACCOUNT_ID + " INT, " + COLUMN_ACCOUNT_EMAIL + " TEXT, " + COLUMN_ACCOUNT_PASSWORD + " TEXT, " + COLUMN_ACCOUNT_NAME + " TEXT, " + COLUMN_ACCOUNT_SEX + " TEXT, " + COLUMN_ACCOUNT_DATEOFBIRTH + " TEXT, " + COLUMN_ACCOUNT_DATEHIRED  +  " TEXT ," + COLUMN_ACCOUNT_IMAGE + " BLOB)";

        db.execSQL(createTableStatement);


        String insertDefaultAdminStatement = "INSERT INTO " + ACCOUNT_TABLE + "(" + COLUMN_ACCOUNT_ID + ", " + COLUMN_ACCOUNT_EMAIL + ", " + COLUMN_ACCOUNT_PASSWORD + ", " + COLUMN_ACCOUNT_NAME + ", " + COLUMN_ACCOUNT_SEX+ ", " + COLUMN_ACCOUNT_DATEOFBIRTH + ", " + COLUMN_ACCOUNT_DATEHIRED + "," + COLUMN_ACCOUNT_IMAGE + ") VALUES(1, 'admin@emicode.com', '12345', 'Admin', 'Male', '01/01/2000', '01/01/2023', '')";

        db.execSQL(insertDefaultAdminStatement);

        String insertDefaultUserStatement = "INSERT INTO " + ACCOUNT_TABLE + "(" + COLUMN_ACCOUNT_ID + ", " + COLUMN_ACCOUNT_EMAIL + ", " + COLUMN_ACCOUNT_PASSWORD + ", " + COLUMN_ACCOUNT_NAME + ", " + COLUMN_ACCOUNT_SEX + ", " + COLUMN_ACCOUNT_DATEOFBIRTH + ", " + COLUMN_ACCOUNT_DATEHIRED + ", " + COLUMN_ACCOUNT_IMAGE + ") VALUES(2230908, 'emilysotelo@emicode.com', '12345', 'Emily Sotelo', 'F', '11/25/1993', '12/25/2023', '')";

        db.execSQL(insertDefaultUserStatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists ACCOUNT_TABLE");
    }

    public boolean addOne(AccountInfo accountInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        Bitmap imageToStoreBitmap = accountInfo.getProfileImage();

        byteArrayOutputStream = new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        imageInBytes = byteArrayOutputStream.toByteArray();

        cv.put(COLUMN_ACCOUNT_ID,accountInfo.getId());
        cv.put(COLUMN_ACCOUNT_EMAIL,accountInfo.getEmail());
        cv.put(COLUMN_ACCOUNT_PASSWORD,accountInfo.getPassword());
        cv.put(COLUMN_ACCOUNT_NAME,accountInfo.getName());
        cv.put(COLUMN_ACCOUNT_SEX,accountInfo.getSex());
        cv.put(COLUMN_ACCOUNT_DATEOFBIRTH,accountInfo.getDateOfBirth());
        cv.put(COLUMN_ACCOUNT_DATEHIRED,accountInfo.getDateHired());
        cv.put(COLUMN_ACCOUNT_IMAGE, imageInBytes);

        long insert = db.insert(ACCOUNT_TABLE, null, cv);
        if (insert == -1){
            return false;
        }else
            return true;
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
        Cursor cursor = db.rawQuery(" SELECT * FROM " + ACCOUNT_TABLE, null);

        ArrayList<AccountInfo> accountInfos = new ArrayList<>();

        while (cursor.moveToNext()){
            AccountInfo account = new AccountInfo();
            account.setId(cursor.getInt(1));
            account.setEmail(cursor.getString(2));
            account.setPassword(cursor.getString(3));
            account.setName(cursor.getString(4));
            account.setSex(cursor.getString(5));
            account.setDateOfBirth(cursor.getString(6));
            account.setDateHired(cursor.getString(7));
            accountInfos.add(account);
        }
        return accountInfos;
    }

    /*
    public Cursor getUser(){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from ACCOUNT_TABLE", null);
        return cursor;
    }

     */
}
