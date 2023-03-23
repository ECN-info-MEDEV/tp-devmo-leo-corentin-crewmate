package com.example.devmocorentinleo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import android.view.View;

import android.widget.ToggleButton;

import android.view.View;

import java.util.LinkedList;

public class EventListActivity extends AppCompatActivity {
    private static final String LOG_TAG = EventListActivity.class.getSimpleName();
    private final LinkedList<String> mEventList = new LinkedList<>();
    private final LinkedList<String> mDateList = new LinkedList<>();
    private final LinkedList<String> mAuthorList = new LinkedList<>();
    private final LinkedList<String> mDescriptionList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private EventListAdapter mAdapter;

    public static final String EXTRA_MESSAGE = "com.example.devmocorentinleo.extra.MESSAGE";

    private ToggleButton mEvents;
    private ToggleButton mMy_profile;
    private ToggleButton mChat;


    private String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
        mEvents = findViewById(R.id.button_event_eventsScreen);
        mMy_profile = findViewById(R.id.button_profile_eventsScreen);
        mChat = findViewById(R.id.button_chat_eventsScreen);
        Intent intent = getIntent();
        user = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        for (int i = 0; i < 20; i++) {
            mEventList.addLast("Event number " + i);
            mDateList.addLast(i + "/01/2023");
            mAuthorList.addLast("Bob " + i);
            mDescriptionList.addLast("Ceci est la description n°" + i + ": Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ante in nibh mauris cursus mattis molestie a iaculis. Aliquam etiam erat velit scelerisque in dictum non consectetur a.");
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new EventListAdapter(this, mEventList, mDateList, mAuthorList, mDescriptionList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    public void goToChat(View view){
        Log.d(LOG_TAG, "From events to chat");
        mEvents.setChecked(false);
        mChat.setChecked(true);
        mMy_profile.setChecked(false);
        Intent intent = new Intent(this, ChatActivity.class);
        Log.d(LOG_TAG, user);
        intent.putExtra(EXTRA_MESSAGE, user);
        startActivity(intent);

    }

    public void goToProfile(View view) {
        Log.d(LOG_TAG, "From events to profile");
        mEvents.setChecked(false);
        mChat.setChecked(false);
        mMy_profile.setChecked(true);
        Intent intent = new Intent(this, ProfileActivity.class);
        Log.d(LOG_TAG, user);
        intent.putExtra(EXTRA_MESSAGE, user);
        startActivity(intent);
    }

    public void stay_events(View view){
        Log.d(LOG_TAG, "Stay in events");
        mEvents.setChecked(true);
        Context context = getApplicationContext();
        CharSequence text = "You're already there";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

}
