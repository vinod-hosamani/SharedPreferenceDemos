package com.example.client1.sharedpreferencethree;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    // UI References
    private EditText editTextTxt;
    private Button buttonSave;
    private Button buttonGoToSecActivity;

    private String text;

    private SharedPreference sharedPreference;

    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        sharedPreference = new SharedPreference(this);

        editTextTxt = (EditText) findViewById(R.id.editTextTxt);
        buttonSave = (Button) findViewById(R.id.button_save);
        buttonGoToSecActivity = (Button) findViewById(R.id.button_second_activity);
        setListener();
    }

    public void setListener() {
        buttonSave.setOnClickListener(this);
        buttonGoToSecActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_save:
                text = editTextTxt.getText().toString();

                // Hides the soft keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextTxt.getWindowToken(), 0);

                // Save the text in SharedPreference
                sharedPreference.save(context, text);
                Toast.makeText(context, getResources().getString(R.string.saved), Toast.LENGTH_LONG).show();
                break;

            case R.id.button_second_activity:
                Intent intent = new Intent(context, SecondActivity.class);
                // Start next activity
                startActivity(intent);
                break;
        }
    }
}