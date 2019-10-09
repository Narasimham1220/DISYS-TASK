package com.example.disystask.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharePref {

    private static SharePref sharePref = new SharePref();
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;


    public static final String KEY_EID = "eid";
    public static final String KEY_NAME = "name";
    public static final String KEY_IDBARAHNO = "idbarahno";
    public static final String KEY_EMAIL = "emailaddress";
    public static final String KEY_UNIFIED = "unifiednumber";
    public static final String KEY_Mobile = "mobileno";

    /**
     * prevent creating multiple instances by making the constructor private
     */
    private SharePref() {
    }

    /**
     * The context passed into the getInstance should be application level context
     */

    public static SharePref getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
        return sharePref;
    }

    public void saveData(String keyName, String value) {
        editor.putString(keyName, value);
        editor.commit();
    }

    public String getData(String keyName) {
        return sharedPreferences.getString(keyName, "");
    }

    public void removeData(String keyName) {
        editor.remove(keyName);
        editor.commit();
    }

    public void clearAll() {
        editor.clear();
        editor.commit();
    }

}
