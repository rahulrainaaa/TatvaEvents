package com.trekking.tatvaevents.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.trekking.tatvaevents.R;
import com.trekking.tatvaevents.adapter.EventsListAdapter;
import com.trekking.tatvaevents.adapter.EventsPageAdapter;
import com.trekking.tatvaevents.eventhandler.callbackhandler.EventItemCallback;
import com.trekking.tatvaevents.eventhandler.listener.EventListViewItemListener;
import com.trekking.tatvaevents.model.Event;
import com.trekking.tatvaevents.utils.Constants;

import java.util.ArrayList;

/**
 * @class EventsActivity
 * @desc {@link AppCompatActivity} class to handle event activity.
 */
public class EventsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, EventItemCallback {

    /**
     * Global data members.
     */
    private DrawerLayout drawer = null;
    private ListView m_eventListView = null;
    private ViewPager mEventViewPager = null;
    private FloatingActionButton mBillingFab = null;
    private ArrayList<Event> m_eventsArrayList = null;
    private EventsListAdapter m_eveEventsListAdapter = null;
    private EventListViewItemListener m_ItemEventListener = null;

    /**
     * Global constants.
     */
    private final String TAG = "EventsActivity";

    /**
     * {@link AppCompatActivity} override methods.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        m_eventListView = (ListView) findViewById(R.id.events_list_view);
        mBillingFab = (FloatingActionButton) findViewById(R.id.billing_fab);
        mEventViewPager = (ViewPager) findViewById(R.id.viewpager);

        m_eventsArrayList = Constants.eventArrayList;
        m_ItemEventListener = new EventListViewItemListener();
        m_ItemEventListener.setCallback(this);
        m_eveEventsListAdapter = new EventsListAdapter(this, m_ItemEventListener, R.layout.item_event, m_eventsArrayList);
        m_eventListView.setAdapter(m_eveEventsListAdapter);
        mBillingFab.setOnClickListener(this);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mEventViewPager.setAdapter(new EventsPageAdapter(this, this, m_eventsArrayList));
        mEventViewPager.setCurrentItem(0);
        Constants.eventsActivity = this;
    }

    @Override
    protected void onDestroy() {

        clearMemory();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        closeDrawer();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.events, menu);
//        return true;
//    }

    /**
     * {@link View.OnClickListener} callback methods.
     */
    @Override
    public void onClick(View clickedView) {

        final int currentPosition = mEventViewPager.getCurrentItem();
        switch (clickedView.getId()) {
            case R.id.billing_fab:

                if (m_eventsArrayList.size() == 0) {
                    return;
                }
                Snackbar.make(clickedView, "You want join this event ?\nFee: " + m_eventsArrayList.get(currentPosition).getPrice(), Snackbar.LENGTH_LONG).setAction("Yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        try {
                            String url = "http://" + m_eventsArrayList.get(currentPosition).getBooking();
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                            Toast.makeText(EventsActivity.this, "Exception: Booking URL Error.", Toast.LENGTH_SHORT).show();
                        }

                    }
                }).show();
                break;
            case R.id.layout_calling:

                try {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + m_eventsArrayList.get(currentPosition).getPhone()));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                        return;
                    }
                    startActivity(callIntent);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    Toast.makeText(EventsActivity.this, "Exception: Contact Number Error.", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.layout_map:

                try {
                    String geoUri = "http://maps.google.com/maps?q=loc:" + m_eventsArrayList.get(currentPosition).getMapPlot();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                    startActivity(intent);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    Toast.makeText(EventsActivity.this, "Exception: Map URL Error.", Toast.LENGTH_SHORT).show();
                }

                break;
            default:

                Toast.makeText(this, "Warning: Unhandled OnClickListener found.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * {@link AdapterView.OnItemClickListener} callback method.
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this, "on item click listener", Toast.LENGTH_SHORT).show();
        drawer.closeDrawer(GravityCompat.START);
    }

    /**
     * {@link EventItemCallback} callback method.
     */
    @Override
    public void onEventItemClicked(View view, int tag) {

        mEventViewPager.setCurrentItem(tag);
        drawer.closeDrawers();
        Toast.makeText(this, "event item: " + tag, Toast.LENGTH_SHORT).show();
    }

    /**
     * @method refreshList
     * @desc Method to refresh the data in list. (Callback from Application).
     */
    public void refreshList() {
        mEventViewPager.setAdapter(new EventsPageAdapter(this, this, m_eventsArrayList));
        mEventViewPager.setCurrentItem(0);
        if (m_eveEventsListAdapter != null) {
            m_eveEventsListAdapter.notifyDataSetChanged();
        }
        Toast.makeText(this, "Events Refreshed...", Toast.LENGTH_SHORT).show();
    }

    /**
     * @method closeDrawer
     * @desc Method to close the Navigation Drawer.
     */
    private void closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * @method clearMemory
     * @desc Method to clear the occupied memory.
     */
    private void clearMemory() {
        removeCallbacks();
        mBillingFab = null;
        m_eventsArrayList = null;
    }

    /**
     * @method removeCallbacks
     * @desc Method to remove callbacks.
     */
    private void removeCallbacks() {
        Constants.eventsActivity = null;
    }
}
