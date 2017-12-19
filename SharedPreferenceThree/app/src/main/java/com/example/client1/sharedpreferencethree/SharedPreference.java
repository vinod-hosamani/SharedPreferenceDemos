package com.example.client1.sharedpreferencethree;

/**
 * Created by client1 on 12/19/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedPreference
{
    Context context;
    public static final String PREFS_NAME = "AOP_PREFS";
    public static final String PREFS_KEY = "AOP_PREFS_String";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String text;

    public SharedPreference(Context context)
    {
        super();
        this.context=context;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

    }

    public void save(Context context, String text) {
        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit(); //2
        editor.putString(PREFS_KEY, text); //3
        editor.commit(); //4
    }

    public String getValue(Context context) {

        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        text = sharedPreferences.getString(PREFS_KEY, null);
        return text;
    }

    public void clearSharedPreference(Context context) {

        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void removeValue(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.remove(PREFS_KEY);
        editor.commit();
    }
}