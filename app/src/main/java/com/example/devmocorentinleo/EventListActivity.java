package com.example.devmocorentinleo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ToggleButton;

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
            mEventList.addLast("Event number " + i);
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
}
