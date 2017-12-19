package com.example.client1.sharedpreferencesevendelete;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private SharedPreferences prefs;
    private String prefName = "report";
    Button save, select, update, clear;
    EditText e_id;
    EditText e_name;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        editor = prefs.edit();

        save = (Button) findViewById(R.id.buttonSave);
        select = (Button) findViewById(R.id.buttonSelect);
        update = (Button) findViewById(R.id.buttonUpdate);
        clear = (Button) findViewById(R.id.buttonClear);
        e_id = (EditText) findViewById(R.id.editTextId);
        e_name = (EditText) findViewById(R.id.editTextName);
        setListener();
    }

    public void setListener() {
        save.setOnClickListener(this);
        select.setOnClickListener(this);
        update.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSave:
                //---save the values in the EditText view to preferences---
                editor.putInt("id", Integer.parseInt(e_id.getText().toString()));
                editor.putString("name", e_name.getText().toString());
                //---saves the values---
                editor.commit();
                Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSelect:
                Toast.makeText(getBaseContext(), String.valueOf(prefs.getInt("id", 100)), Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(), prefs.getString("name", "Balaji"), Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonUpdate:
                //---save the values in the EditText view to preferences---
                editor.putInt("id", Integer.parseInt(e_id.getText().toString()));
                editor.putString("name", e_name.getText().toString());

                //---saves and update the values both are same---
                editor.commit();
                Toast.makeText(getBaseContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonClear:
                editor.clear();
                editor.commit();
                e_id.setText("");
                e_name.setText("");
                Toast.makeText(getBaseContext(), "cleared Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}