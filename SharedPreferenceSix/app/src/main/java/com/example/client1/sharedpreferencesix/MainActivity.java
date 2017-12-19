package com.example.client1.sharedpreferencesix;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener {
    CheckBox checkBox;
    EditText editText;
    Button button;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadSavedPreferences();
    }

    public void initView() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
        editText = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button1);
        setListener();
    }

    public void setListener() {
        button.setOnClickListener(this);
    }

    private void loadSavedPreferences() {
        boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
        String name = sharedPreferences.getString("storedName", "YourName");
        if (checkBoxValue) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        editText.setText(name);
    }

    private void savePreferences(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    private void savePreferences(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        savePreferences("CheckBox_Value", checkBox.isChecked());
        if (checkBox.isChecked()) savePreferences("storedName", editText.getText().toString());
        finish();
    }
}

