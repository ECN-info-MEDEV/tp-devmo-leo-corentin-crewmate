package com.example.devmocorentinleo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    private static final String LOG_TAG = ChatActivity.class.getSimpleName();
    private ToggleButton mEvents;
    private ToggleButton mMy_profile;
    private ToggleButton mChat;
    public static final String EXTRA_MESSAGE = "com.example.devmocorentinleo.extra.MESSAGE";
    private String user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mEvents = findViewById(R.id.button_event_chatScreen);
        mMy_profile = findViewById(R.id.button_profile_chatScreen);
        mChat = findViewById(R.id.button_chat_chatScreen);
        Intent intent = getIntent();
        String user = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        }

    public void stay_chat(View view){
        Log.d(LOG_TAG, "Staying in chat");
        mChat.setChecked(true);
        Context context = getApplicationContext();
        CharSequence text = "You're already there";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void goToEvents(View view){
        Log.d(LOG_TAG, "From chat to events");
        mEvents.setChecked(true);
        mChat.setChecked(false);
        mMy_profile.setChecked(false);
        Intent intent = new Intent(this, EventListActivity.class);
        Log.d(LOG_TAG, user);
        intent.putExtra(EXTRA_MESSAGE, user);
        startActivity(intent);
    }

    public void goToProfile(View view) {
        Log.d(LOG_TAG, "From chat to profile");
        mEvents.setChecked(false);
        mChat.setChecked(false);
        mMy_profile.setChecked(true);
        Intent intent = new Intent(this, ProfileActivity.class);
        Log.d(LOG_TAG, user);
        intent.putExtra(EXTRA_MESSAGE, user);
        startActivity(intent);
    }
}
