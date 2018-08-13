package com.mobicob.mobile.app.sql.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mobicob.mobile.app.model.Contractor;
import com.mobicob.mobile.app.model.Delegation;
import com.mobicob.mobile.app.model.Role;
import com.mobicob.mobile.app.model.User;
import com.mobicob.mobile.app.sql.DataBaseHelper;
import com.mobicob.mobile.app.util.DateUtilities;

import static com.mobicob.mobile.app.sql.MobicobContract.FeedUsers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO {

    private DataBaseHelper dbHelper;

    public UserDAO(DataBaseHelper dbHelper){
        this.dbHelper = dbHelper;
    }

    public void addUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID, user.getId());
        values.put(COLUMN_NAME_USER_NAME, user.getUsername());
        values.put(COLUMN_NAME_EMAIL, user.getEmail());
        values.put(COLUMN_NAME_NAME, user.getName());
        values.put(COLUMN_NAME_LAST_NAME, user.getLastname());
        values.put(COLUMN_NAME_CREATION, user.getCreation().toString());
        values.put(COLUMN_NAME_ID_NUMBER, user.getIdNumber());
        values.put(COLUMN_NAME_CONTRACTOR_ID, user.getContractorId().getId());
        values.put(COLUMN_NAME_ROLE_ID, user.getRoleId().getId());
        values.put(COLUMN_NAME_PHONE, user.getPhone());
        values.put(COLUMN_NAME_ADDRESS, user.getAddress());
        values.put(COLUMN_NAME_ACTIVE, user.isActive());
        values.put(COLUMN_NAME_LATITUDE, user.getLatitude());
        values.put(COLUMN_NAME_LONGITUDE, user.getLongitude());
        values.put(COLUMN_NAME_POSITION, user.getPosition());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<User> getAllUser() {
        String[] columns = {
                COLUMN_NAME_ID,
                COLUMN_NAME_USER_NAME,
                COLUMN_NAME_EMAIL,
                COLUMN_NAME_NAME,
                COLUMN_NAME_LAST_NAME,
                COLUMN_NAME_CREATION,
                COLUMN_NAME_ID_NUMBER,
                COLUMN_NAME_CONTRACTOR_ID,
                COLUMN_NAME_ROLE_ID,
                COLUMN_NAME_PHONE,
                COLUMN_NAME_ADDRESS,
                COLUMN_NAME_ACTIVE,
                COLUMN_NAME_LATITUDE,
                COLUMN_NAME_LONGITUDE,
                COLUMN_NAME_POSITION
        };
        String sortOrder = COLUMN_NAME_ID + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if (cursor.moveToFirst()) {
            do {
                User user = new User(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_USER_NAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_NAME)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_LAST_NAME)),
                        DateUtilities.stringToDate( cursor.getString(cursor.getColumnIndex(COLUMN_NAME_CREATION)) ),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_ID_NUMBER)),
                        new Contractor( cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_CONTRACTOR_ID)) ),
                        new Role( cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_ROLE_ID)) ),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_PHONE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_ADDRESS)),
                        cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_ACTIVE))==1,
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_LATITUDE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_LONGITUDE)),
                        new Delegation( cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_DELEGATION_ID)) ),
                        cursor.getString(cursor.getColumnIndex(COLUMN_NAME_POSITION))
                );
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }

    public void updateUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_ID, user.getId());
        values.put(COLUMN_NAME_USER_NAME, user.getUsername());
        values.put(COLUMN_NAME_EMAIL, user.getEmail());
        values.put(COLUMN_NAME_NAME, user.getName());
        values.put(COLUMN_NAME_LAST_NAME, user.getLastname());
        values.put(COLUMN_NAME_CREATION, user.getCreation().toString());
        values.put(COLUMN_NAME_ID_NUMBER, user.getIdNumber());
        values.put(COLUMN_NAME_CONTRACTOR_ID, user.getContractorId().getId());
        values.put(COLUMN_NAME_ROLE_ID, user.getRoleId().getId());
        values.put(COLUMN_NAME_PHONE, user.getPhone());
        values.put(COLUMN_NAME_ADDRESS, user.getAddress());
        values.put(COLUMN_NAME_ACTIVE, user.isActive());
        values.put(COLUMN_NAME_LATITUDE, user.getLatitude());
        values.put(COLUMN_NAME_LONGITUDE, user.getLongitude());
        values.put(COLUMN_NAME_POSITION, user.getPosition());

        // updating row
        db.update(TABLE_NAME, values, COLUMN_NAME_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_NAME_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }
}