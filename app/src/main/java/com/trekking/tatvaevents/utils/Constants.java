package com.trekking.tatvaevents.utils;

import com.trekking.tatvaevents.activity.EventsActivity;
import com.trekking.tatvaevents.model.Event;

import java.util.ArrayList;

/**
 * @class Constants
 * @desc Constants class to hold static data for application lifespan.
 */
public class Constants {

    /**
     * Static final Constants.
     */
    public static final String DB_REF_URL = "https://tatvaevents-a5f2a.firebaseio.com/events";

    public static ArrayList<Event> eventArrayList = new ArrayList<>();

    public static EventsActivity eventsActivity = null;
}
