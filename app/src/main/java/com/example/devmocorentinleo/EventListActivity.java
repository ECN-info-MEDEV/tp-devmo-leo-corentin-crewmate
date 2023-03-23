package com.example.devmocorentinleo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.ToggleButton;

import android.view.View;

import java.util.LinkedList;

public class EventListActivity extends AppCompatActivity {
    private final LinkedList<String> mEventList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private EventListAdapter mAdapter;

    private ToggleButton mEvents;
    private ToggleButton mMy_profile;
    private ToggleButton mChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
        mEvents = findViewById(R.id.button_event);
        mMy_profile = findViewById(R.id.button_profile);
        mChat = findViewById(R.id.button_chat);
        for (int i = 0; i < 20; i++) {
            mEventList.addLast("Word " + i);
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new EventListAdapter(this, mEventList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
    public void goToChat(View view){
        mEvents.setChecked(false);
        mChat.setChecked(true);
        mMy_profile.setChecked(false);
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);

    }

    public void goToProfile(View view) {
        mEvents.setChecked(false);
        mChat.setChecked(false);
        mMy_profile.setChecked(true);
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void stay(View view){
        mEvents.setChecked(true);
        Context context = getApplicationContext();
        CharSequence text = "You're there already";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
