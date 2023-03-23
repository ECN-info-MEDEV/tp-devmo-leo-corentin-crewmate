package com.example.devmocorentinleo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ListViewHolder> {

    private final LinkedList<String> mEventList;
    private LayoutInflater mInflater;

    public EventListAdapter(Context context,
                            LinkedList<String> eventList) {
        mInflater = LayoutInflater.from(context);
        this.mEventList = eventList;
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        public final TextView listItemView;
        final EventListAdapter mAdapter;

        public ListViewHolder(View itemView, EventListAdapter adapter) {
            super(itemView);
            listItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
        }

    }



    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View mItemView = mInflater.inflate(R.layout.eventlist_item,
                parent, false);
        return new ListViewHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        String mCurrent = mEventList.get(position);
        holder.listItemView.setText(mCurrent);
    }


    @Override
    public int getItemCount() {
        return mEventList.size();
    }
}
