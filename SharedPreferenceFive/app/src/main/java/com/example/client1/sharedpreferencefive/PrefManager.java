package com.example.client1.sharedpreferencefive;

/**
 * Created by client1 on 12/19/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class for Shared Preference
 */
public class PrefManager
{
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    PrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveLoginDetails(String email, String password) {
        editor.putString("Email", email);
        editor.putString("Password", password);
        editor.commit();
    }

    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email", "");
    }

    public boolean isUserLogedOut() {
        boolean isEmailEmpty = sharedPreferences.getString("Email", "").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();
        return isEmailEmpty || isPasswordEmpty;
    }
}