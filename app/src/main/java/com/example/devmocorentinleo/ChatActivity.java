package com.example.devmocorentinleo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    private ToggleButton mEvents;
    private ToggleButton mMy_profile;
    private ToggleButton mChat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mEvents = findViewById(R.id.button_event_chatScreen);
        mMy_profile = findViewById(R.id.button_profile_chatScreen);
        mChat = findViewById(R.id.button_chat_chatScreen);
        }

    public void stay_chat(View view){
        mChat.setChecked(true);
        Context context = getApplicationContext();
        CharSequence text = "You're already there";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void goToEvents(View view){
        mEvents.setChecked(true);
        mChat.setChecked(false);
        mMy_profile.setChecked(false);
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }
}
