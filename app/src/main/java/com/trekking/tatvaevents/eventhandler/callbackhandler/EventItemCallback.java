package com.trekking.tatvaevents.eventhandler.callbackhandler;

import android.view.View;

import com.trekking.tatvaevents.eventhandler.listener.EventListViewItemListener;

/**
 * @interface EventItemCallback
 * @desc Interface for {@link EventListViewItemListener} callbacks.
 */
public interface EventItemCallback {

    /**
     * @param view
     * @param tag
     * @method onEventItemClicked
     */
    public void onEventItemClicked(View view, int tag);

}
