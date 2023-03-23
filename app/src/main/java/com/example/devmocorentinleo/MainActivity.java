package com.example.devmocorentinleo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText mLoginEditText;
    private EditText mPasswdEditText;
    public static final String EXTRA_MESSAGE = "com.example.devmocorentinleo.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginEditText = findViewById(R.id.editText_login);
        mPasswdEditText = findViewById(R.id.editText_passwd);
    }
    public void checkLogin(View view) {

        Log.d(LOG_TAG, "Button clicked");
        String login = mLoginEditText.getText().toString();

        String pass = mPasswdEditText.getText().toString();
        Log.d(LOG_TAG, "Comparison shall be done");
        Log.d(LOG_TAG, "Login is " + login);
        Log.d(LOG_TAG, "Passwd is " + pass);
        if (pass.equals("admin")) { //Yes, this isn't a good way to do it
            Log.d(LOG_TAG, "We are currently in the if");
            Intent intent = new Intent(this, EventListActivity.class);
            intent.putExtra(EXTRA_MESSAGE, login);
            startActivity(intent);

        }
        else {
            Log.d(LOG_TAG, "Incorrect user and/or password");
            mLoginEditText.setText("");
            mPasswdEditText.setText("");
        }

    }

}