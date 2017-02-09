package com.trekking.tatvaevents.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.trekking.tatvaevents.R;
import com.trekking.tatvaevents.model.Event;

import java.util.ArrayList;

/**
 * @class EventsListAdapter
 * @desc Adapter class for ListView to populate event items.
 */
public class EventsListAdapter extends ArrayAdapter<Event> {

    /**
     * Global data members.
     */
    private Activity activity = null;
    private ArrayList<Event> eventArrayList = null;
    private LayoutInflater layoutInflater = null;
    private int layoutResource;
    private TextView m_txtEventTitle = null;
    private TextView m_txtEventDate = null;

    /**
     * Global constants.
     */
    private final String TAG = "EventsListAdapter";

    /**
     * @class ViewHolder
     * @desc Holder class to hold instances of list view item.
     */
    static class ViewHolder {
        public TextView txtEventTitle = null;
        public TextView txtEventDate = null;
    }

    /**
     * EventsListAdapter: Constructor.
     */
    public EventsListAdapter(Activity activity, int layoutResource, ArrayList<Event> eventArrayList) {
        super(activity, layoutResource, eventArrayList);
        this.activity = activity;
        this.layoutInflater = activity.getLayoutInflater();
        this.eventArrayList = eventArrayList;
        this.layoutResource = layoutResource;
    }

    /**
     * {@link ArrayAdapter} override methods.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        View view = convertView;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(layoutResource, null);
            viewHolder.txtEventTitle = (TextView) view.findViewById(R.id.txt_event_title);
            viewHolder.txtEventDate = (TextView) view.findViewById(R.id.txt_event_date);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        m_txtEventTitle = viewHolder.txtEventTitle;
        m_txtEventDate = viewHolder.txtEventDate;
        Event event = eventArrayList.get(position);
        m_txtEventTitle.setText(event.getTitle());
        m_txtEventDate.setText(event.getDateTime());
        return view;
    }
}
