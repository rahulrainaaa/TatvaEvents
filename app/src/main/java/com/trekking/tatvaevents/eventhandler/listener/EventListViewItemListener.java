package com.trekking.tatvaevents.eventhandler.listener;

import android.view.View;

import com.trekking.tatvaevents.R;
import com.trekking.tatvaevents.eventhandler.callbackhandler.EventItemCallback;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @class EventListViewItemListener
 * @desc ListView Item click listener class.
 */
public class EventListViewItemListener implements View.OnClickListener {

    /**
     * Global data members.
     */
    private ArrayList<EventItemCallback> eventItemCallbackArrayList = null;

    /**
     * Constructor
     */
    public EventListViewItemListener() {
        eventItemCallbackArrayList = new ArrayList<>();
    }

    /**
     * @method destroy
     * @desc Method destroys the stored data, references for callback. (memory release)
     */
    public void destroy() {
        this.eventItemCallbackArrayList.clear();
        this.eventItemCallbackArrayList = null;
    }

    /**
     * {@link View.OnClickListener} callback methods
     */
    @Override
    public void onClick(View view) {

        int tag = Integer.parseInt(String.valueOf(view.getTag(R.string.event_item_view_tag)));

        //Iterate and do callback.
        Iterator<EventItemCallback> iterator = eventItemCallbackArrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next().onEventItemClicked(view, tag);
        }
    }

    /**
     * @param eventItemCallback
     * @method setCallback
     * @desc Method to set {@link EventItemCallback} for event callback.
     */

    public void setCallback(EventItemCallback eventItemCallback) {
        this.eventItemCallbackArrayList.add(eventItemCallback);
    }

    /**
     * @method removeCallback
     * @desc Method to remove callback.
     */
    public void removeCallback(EventItemCallback instance) {

        // Iterate and remove. the item.
        Iterator<EventItemCallback> iterator = eventItemCallbackArrayList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == instance) {
                iterator.remove();
            }
        }
    }
}

