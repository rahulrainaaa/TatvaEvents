package com.trekking.tatvaevents.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trekking.tatvaevents.R;
import com.trekking.tatvaevents.model.Event;

import java.util.ArrayList;

/**
 * @class EventsPageAdapter
 * @desc Adapter class for Event page View.
 */
public class EventsPageAdapter extends PagerAdapter {

    /**
     * Global data members.
     */
    private ArrayList<Event> mEventArrayList = null;
    private LayoutInflater mInflater = null;
    private Activity mActivity = null;

    /**
     * Constructor
     */
    public EventsPageAdapter(Activity activity, ArrayList<Event> list) {

        this.mEventArrayList = list;
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(activity);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        ViewGroup layout = (ViewGroup) mInflater.inflate(R.layout.event_page_view, collection, false);

        collection.addView(layout);
        return layout;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
        Toast.makeText(mActivity, "destroy:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getCount() {

        if (mEventArrayList != null) {
            return mEventArrayList.size();
        } else {
            return 0;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    /**
     * @method destroy
     * @desc Method to destroy data and clear memory.
     */
    public void destroy() {

    }
}
