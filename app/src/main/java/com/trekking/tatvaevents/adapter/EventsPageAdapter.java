package com.trekking.tatvaevents.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
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
    private View.OnClickListener mClickListener = null;

    /**
     * Constructor
     */
    public EventsPageAdapter(Activity activity, View.OnClickListener clickListener, ArrayList<Event> list) {

        this.mEventArrayList = list;
        this.mActivity = activity;
        this.mInflater = LayoutInflater.from(activity);
        this.mClickListener = clickListener;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        ViewGroup layout = (ViewGroup) mInflater.inflate(R.layout.event_page_view, collection, false);

        LinearLayout callLayout = (LinearLayout) layout.findViewById(R.id.layout_calling);
        LinearLayout mapLayout = (LinearLayout) layout.findViewById(R.id.layout_map);
        ImageView imgEvent = (ImageView) layout.findViewById(R.id.img_event);
        TextView txtEventTitle = (TextView) layout.findViewById(R.id.txt_event_title);
        TextView txtGoingTo = (TextView) layout.findViewById(R.id.txt_going_to);
        TextView txtStartOn = (TextView) layout.findViewById(R.id.txt_start_on);
        TextView txtStartFrom = (TextView) layout.findViewById(R.id.txt_start_from);
        TextView txtDescription = (TextView) layout.findViewById(R.id.txt_description);

        String imgUrl = mEventArrayList.get(position).getImgurl();
        Picasso.with(mActivity).load(imgUrl).into(imgEvent);
        txtEventTitle.setText(mEventArrayList.get(position).getTitle());
        txtGoingTo.setText(mEventArrayList.get(position).getPlace());
        txtStartOn.setText(mEventArrayList.get(position).getStartdt());
        txtStartFrom.setText(mEventArrayList.get(position).getStartPlace());
        txtDescription.setText(mEventArrayList.get(position).getDescription());

        callLayout.setOnClickListener(mClickListener);
        mapLayout.setOnClickListener(mClickListener);

        collection.addView(layout);
        return layout;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
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
