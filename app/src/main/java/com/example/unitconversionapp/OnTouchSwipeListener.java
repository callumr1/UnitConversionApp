package com.example.unitconversionapp;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Callum Robertson on 21/03/2018.
 */

public class OnTouchSwipeListener implements View.OnTouchListener {
    private final GestureDetector gestureDetector;
    private Context context;

    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    // Gets the gesture detector
    public GestureDetector getGestureDetector(){
        return  gestureDetector;
    }

    // Initiates a new on swipe touch listener
    public OnTouchSwipeListener(Context context) {
        super();
        this.context = context;
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getRawY() - e1.getRawY();
                float diffX = e2.getRawX() - e1.getRawX();
                if ((Math.abs(diffX) - Math.abs(diffY)) > SWIPE_THRESHOLD) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeBottom();
                        } else {
                            onSwipeTop();
                        }
                    }
                }
            } catch (Exception e) {

            }
            return result;
        }
    }

    /**
     * On swipe right.
     */
    public void onSwipeRight() {
    }

    /**
     * On swipe left.
     */
    public void onSwipeLeft() {
    }

    /**
     * On swipe top.
     */
    public void onSwipeTop() {
    }

    /**
     * On swipe bottom.
     */
    public void onSwipeBottom() {
    }
}
