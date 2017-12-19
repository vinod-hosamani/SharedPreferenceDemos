package com.example.client1.sharedpreferencethree;

/**
 * Created by client1 on 12/19/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    // UI References
    private TextView textViewTxt;
    private String text;
    private SharedPreference sharedPreference;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

        //Retrieve a value from SharedPreference
        text = sharedPreference.getValue(context);
        textViewTxt.setText(text);
    }

    private void initView() {
        sharedPreference = new SharedPreference(this);

        textViewTxt = (TextView) findViewById(R.id.txt_text);
    }
}