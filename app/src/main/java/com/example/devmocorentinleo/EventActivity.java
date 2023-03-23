package com.example.devmocorentinleo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Intent intent = getIntent();
        String message= intent.getStringExtra(EventListAdapter.EXTRA_MESSAGE);
        String date = intent.getStringExtra(EventListAdapter.EXTRA_DATE);
        String author = intent.getStringExtra(EventListAdapter.EXTRA_AUTHOR);
        String description = intent.getStringExtra(EventListAdapter.EXTRA_DESCRIPTION);
        TextView textView = findViewById(R.id.Event_page_title);
        TextView textView_date = findViewById(R.id.event_page_date);
        TextView textView_author = findViewById(R.id.event_page_author);
        TextView textView_description = findViewById(R.id.event_page_description);
        textView.setText(message);
        textView_date.setText(date);
        textView_author.setText(author);
        textView_description.setText(description);
    }

}