package com.trekking.tatvaevents.application;

import android.app.Application;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trekking.tatvaevents.model.Event;
import com.trekking.tatvaevents.utils.Constants;

import java.util.Iterator;

/**
 * @class TatvaEventsApplication
 * @desc {@link Application} class for this application lifecycle events callback for override methods.
 */
public class TatvaEventsApplication extends Application implements ValueEventListener {

    /**
     * Global data members.
     */
    private FirebaseDatabase m_eventDatabase = null;
    private DatabaseReference m_eventDbRef = null;

    /**
     * Global final data members.
     */
    private final String TAG = "TatvaEventsApplication";

    /**
     * {@link Application} override methods.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
    }

    @Override
    public void onTerminate() {

        Constants.eventArrayList = null;
        super.onTerminate();
    }

    /**
     * @method initFirebase
     * @desc Method to initialize Firebase Database reference for Application.
     */
    private void initFirebase() {

        m_eventDatabase = FirebaseDatabase.getInstance();
        m_eventDbRef = m_eventDatabase.getReferenceFromUrl(Constants.DB_REF_URL);
        m_eventDbRef.addValueEventListener(this);
    }

    /**
     * {@link ValueEventListener} interface callbacks.
     */
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
        Constants.eventArrayList.clear();
        while (iterator.hasNext()) {
            Event event = iterator.next().getValue(Event.class);
            Constants.eventArrayList.add(event);
            Log.d(TAG, "Value is: " + event.getTitle());
        }
        if (Constants.eventsActivity != null) {
            Constants.eventsActivity.refreshList();
        }
    }

    @Override
    public void onCancelled(DatabaseError error) {

        Log.w(TAG, "Failed to read value: ", error.toException());
    }
}
