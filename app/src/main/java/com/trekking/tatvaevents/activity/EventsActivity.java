package com.trekking.tatvaevents.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.trekking.tatvaevents.R;
import com.trekking.tatvaevents.adapter.EventsListAdapter;
import com.trekking.tatvaevents.model.Event;

import java.util.ArrayList;

/**
 * @class EventsActivity
 * @desc {@link AppCompatActivity} class to handle event activity.
 */
public class EventsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /**
     * Global data members.
     */
    private ListView m_eventListView = null;
    private FloatingActionButton m_callFab = null;
    private ArrayList<Event> m_eventsArrayList = null;
    private EventsListAdapter m_eveEventsListAdapter = null;

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
        m_callFab = (FloatingActionButton) findViewById(R.id.calling_fab);

        m_eventsArrayList = new ArrayList<>();
        for (int nEventNo = 0; nEventNo < 30; nEventNo++) {
            Event event = new Event();
            event.setTitle("Event Title " + nEventNo);
            event.setDateTime("2017-03-25 08:00 PM");
            m_eventsArrayList.add(event);
        }
        m_eveEventsListAdapter = new EventsListAdapter(this, R.layout.item_event, m_eventsArrayList);
        m_eventListView.setAdapter(m_eveEventsListAdapter);

        m_eventListView.setOnItemClickListener(this);
        m_eventListView.setOnItemLongClickListener(this);
        m_callFab.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearMemory();
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.events, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * {@link NavigationView.OnNavigationItemSelectedListener} callback methods
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * {@link View.OnClickListener} callback methods.
     */
    @Override
    public void onClick(View clickedView) {

        switch (clickedView.getId()) {
            case R.id.calling_fab:

                Snackbar.make(clickedView, "Item clicked.", Snackbar.LENGTH_LONG).show();
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

    }

    /**
     * {@link AdapterView.OnItemClickListener} callback method.
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


        return true;
    }

    /**
     * @method clearMemory
     * @desc Method to clear the occupied memory.
     */
    private void clearMemory() {
        removeCallbacks();
        m_callFab = null;
        m_eventsArrayList = null;
    }

    /**
     * @method removeCallbacks
     * @desc Method to remove callbacks.
     */
    private void removeCallbacks() {

    }


}
