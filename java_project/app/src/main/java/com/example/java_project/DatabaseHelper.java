package com.example.java_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * Bu sınıf uygulamanın yerel SQLite database işlemlerini yönetir.
 * Register sayfasında kullanıcı ekler.
 * Login sayfasında kullanıcı kontrol eder.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hotelia.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USERS = "users";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
     * Database ilk oluşturulduğunda çalışır.
     * users tablosunu burada oluşturuyoruz.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable =
                "CREATE TABLE " + TABLE_USERS + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_FIRST_NAME + " TEXT, " +
                        COLUMN_LAST_NAME + " TEXT, " +
                        COLUMN_EMAIL + " TEXT UNIQUE, " +
                        COLUMN_PHONE + " TEXT, " +
                        COLUMN_PASSWORD + " TEXT" +
                        ")";

        db.execSQL(createUsersTable);
    }

    /*
     * Database versiyonu değişirse çalışır.
     * Demo için eski tabloyu silip yeniden oluşturuyoruz.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    /*
     * Register sayfasından gelen kullanıcı bilgilerini database'e ekler.
     */
    public boolean registerUser(String firstName, String lastName, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, firstName);
        values.put(COLUMN_LAST_NAME, lastName);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
        values.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_USERS, null, values);
        db.close();

        return result != -1;
    }

    /*
     * Login sayfasında email ve password eşleşiyor mu diye kontrol eder.
     */
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query =
                "SELECT * FROM " + TABLE_USERS +
                        " WHERE " + COLUMN_EMAIL + " = ?" +
                        " AND " + COLUMN_PASSWORD + " = ?";

        Cursor cursor = db.rawQuery(query, new String[]{email, password});

        boolean userExists = cursor.getCount() > 0;

        cursor.close();
        db.close();

        return userExists;
    }

    /*
     * Aynı email daha önce kayıt edilmiş mi diye kontrol eder.
     */
    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query =
                "SELECT * FROM " + TABLE_USERS +
                        " WHERE " + COLUMN_EMAIL + " = ?";

        Cursor cursor = db.rawQuery(query, new String[]{email});

        boolean exists = cursor.getCount() > 0;

        cursor.close();
        db.close();

        return exists;
    }

    /*
     * Email'e göre kullanıcının adını ve soyadını döndürür.
     */
    public String getFullNameByEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query =
                "SELECT " + COLUMN_FIRST_NAME + ", " + COLUMN_LAST_NAME +
                        " FROM " + TABLE_USERS +
                        " WHERE " + COLUMN_EMAIL + " = ?";

        Cursor cursor = db.rawQuery(query, new String[]{email});

        String fullName = "Guest User";

        if (cursor.moveToFirst()) {
            String firstName = cursor.getString(0);
            String lastName = cursor.getString(1);
            fullName = firstName + " " + lastName;
        }

        cursor.close();
        db.close();

        return fullName;
    }
}