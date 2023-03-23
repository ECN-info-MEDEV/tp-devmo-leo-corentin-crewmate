package com.example.devmocorentinleo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ListViewHolder> {
    Context context;
    private final LinkedList<String> mEventList;
    private final LinkedList<String> mDateList;
    private final LinkedList<String> mAuthorList;
    private final LinkedList<String> mDescriptionList;
    private LayoutInflater mInflater;

    public static final String EXTRA_MESSAGE="com.example.devmocorentinleo.extra.MESSAGE";

    public static final String EXTRA_DATE="com.example.devmocorentinleo.extra.DATE";
    public static final String EXTRA_AUTHOR="com.example.devmocorentinleo.extra.AUTHOR";
    public static final String EXTRA_DESCRIPTION="com.example.devmocorentinleo.extra.DESCRIPTION";


    public EventListAdapter(Context context,
                            LinkedList<String> eventList, LinkedList<String> dateList, LinkedList<String> authorList, LinkedList<String> descriptionList) {
        mInflater = LayoutInflater.from(context);
        this.mEventList = eventList;
        this.mDateList = dateList;
        this.mAuthorList = authorList;
        this.mDescriptionList = descriptionList;
        this.context = context;
    }

    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView listItemView;
        public final TextView dateItemView;
        public final TextView authorItemView;
        final EventListAdapter mAdapter;

        public ListViewHolder(View itemView, EventListAdapter adapter) {
            super(itemView);
            listItemView = itemView.findViewById(R.id.event_title);
            dateItemView = itemView.findViewById(R.id.event_date);
            authorItemView = itemView.findViewById(R.id.event_author);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            String title = mEventList.get(mPosition);
            String date = mDateList.get(mPosition);
            String author = mAuthorList.get(mPosition);
            String description = mDescriptionList.get(mPosition);
            Intent intent = new Intent(context, EventActivity.class);
            intent.putExtra(EXTRA_MESSAGE,title);
            intent.putExtra(EXTRA_DATE, date);
            intent.putExtra(EXTRA_AUTHOR, author);
            intent.putExtra(EXTRA_DESCRIPTION, description);
            context.startActivity(intent);
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
        String mCurrentDate = mDateList.get(position);
        String mCurrentAuthor = mAuthorList.get(position);
        holder.listItemView.setText(mCurrent);
        holder.dateItemView.setText(mCurrentDate);
        holder.authorItemView.setText(mCurrentAuthor);
    }


    @Override
    public int getItemCount() {
        return mEventList.size();
    }
}
