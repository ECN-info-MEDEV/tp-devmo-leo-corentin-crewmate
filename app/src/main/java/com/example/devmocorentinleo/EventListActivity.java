package com.example.devmocorentinleo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.LinkedList;

public class EventListActivity extends AppCompatActivity {
    private final LinkedList<String> mEventList = new LinkedList<>();
    private final LinkedList<String> mDateList = new LinkedList<>();
    private final LinkedList<String> mAuthorList = new LinkedList<>();
    private final LinkedList<String> mDescriptionList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private EventListAdapter mAdapter;

    private ToggleButton mEvents;
    private ToggleButton mMy_profile;
    private ToggleButton mChat;

    public static final String EXTRA_MESSAGE="com.example.devmocorentinleo.extra.MESSAGE";

    private TextView mMessageEventTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
        mEvents = findViewById(R.id.button_event);
        mMy_profile = findViewById(R.id.button_profile);
        mChat = findViewById(R.id.button_chat);
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


}
