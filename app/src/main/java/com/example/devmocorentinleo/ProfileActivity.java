package com.example.devmocorentinleo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private static final String LOG_TAG = ProfileActivity.class.getSimpleName();
    private ToggleButton mEvents;
    private ToggleButton mMy_profile;
    private ToggleButton mChat;
    private String user;
    public static final String EXTRA_MESSAGE = "com.example.devmocorentinleo.extra.MESSAGE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mEvents = findViewById(R.id.button_event_profileScreen);
        mMy_profile = findViewById(R.id.button_profile_profileScreen);
        mChat = findViewById(R.id.button_chat_profileScreen);
        Intent intent = getIntent();
        user = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_user);
        textView.setText("Bonjour, "+ user);
    }

    public void stay_profile(View view){
        Log.d(LOG_TAG, "Stay in profile");
        mMy_profile.setChecked(true);
        Context context = getApplicationContext();
        CharSequence text = "You're already there";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void goToEvents_from_profile(View view){
        Log.d(LOG_TAG, "From profile to events");
        mEvents.setChecked(true);
        mChat.setChecked(false);
        mMy_profile.setChecked(false);
        Intent intent = new Intent(this, EventListActivity.class);
        intent.putExtra(EXTRA_MESSAGE, user);
        startActivity(intent);
    }

    public void goToChat_from_profile(View view){
        Log.d(LOG_TAG, "From profile to chat");
        mEvents.setChecked(false);
        mChat.setChecked(true);
        mMy_profile.setChecked(false);
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);

    }
}
