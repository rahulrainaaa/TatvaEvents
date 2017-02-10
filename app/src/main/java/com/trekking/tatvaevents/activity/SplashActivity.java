package com.trekking.tatvaevents.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.trekking.tatvaevents.R;
import com.trekking.tatvaevents.utils.Constants;

/**
 * @class SplashActivity
 * @desc {@link FragmentActivity} class to show the splash screen.
 */
public class SplashActivity extends FragmentActivity implements Runnable {

    /**
     * Global data members.
     */
    private Handler m_handler = null;

    /**
     * Global constants.
     */
    private final String TAG = "SplashActivity";

    /**
     * {@link FragmentActivity} override methods.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        m_handler = new Handler();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_splash);
        layout.startAnimation(animation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        m_handler.postDelayed(this, 1500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeCallbacks();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearMemory();
    }

    /**
     * {@link Runnable} interface callback.
     */
    @Override
    public void run() {

        if (Constants.eventArrayList.size() < 1) {
            m_handler.removeCallbacks(this);
            m_handler.postDelayed(this, 500);
            return;
        }
        startActivity(new Intent(this, EventsActivity.class));
        finish();
    }

    /**
     * @method clearMemory
     * @desc Method to remove callbacks and clear memory (dealloc) on destroy.
     */
    public void clearMemory() {
        Log.d(TAG, "clearMemory():");
        removeCallbacks();
        m_handler = null;
    }

    /**
     * @method removeCallbacks
     * @desc Method to remove all callbacks
     */
    public void removeCallbacks() {
        m_handler.removeCallbacks(this);
    }
}
