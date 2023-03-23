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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mEvents = findViewById(R.id.button_event_profileScreen);
        mMy_profile = findViewById(R.id.button_profile_profileScreen);
        mChat = findViewById(R.id.button_chat_profileScreen);
        Intent intent = getIntent();
        String user = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_user);
        textView.setText(user);
    }

    public void stay_profile(){
        Log.d(LOG_TAG, "Stay in prfile");
        mMy_profile.setChecked(true);
        Context context = getApplicationContext();
        CharSequence text = "You're already there";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void goToEvents(View view){
        Log.d(LOG_TAG, "From profile to events");
        mEvents.setChecked(true);
        mChat.setChecked(false);
        mMy_profile.setChecked(false);
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }

    public void goToChat(View view){
        Log.d(LOG_TAG, "From profile to chat");
        mEvents.setChecked(false);
        mChat.setChecked(true);
        mMy_profile.setChecked(false);
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);

    }
}
