package com.trekking.tatvaevents.eventhandler.callbackhandler;

import android.view.View;

/**
 * @interface EventItemCallback
 * @desc Interface for {@link com.trekking.tatvaevents.eventhandler.listener.EventListViewItelListener} callbacks.
 */
public interface EventItemCallback {

    /**
     * @param view
     * @param tag
     * @method onEventItemClicked
     */
    public void onEventItemClicked(View view, int tag);

}
