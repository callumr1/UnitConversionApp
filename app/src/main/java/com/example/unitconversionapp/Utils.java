package com.example.unitconversionapp;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Callum on 18/03/2018.
 *
 * Handles the changing of themes which is called from the settingsActivity
 */

class Utils {
    private static int sTheme;
    final static int  NORMAL_THEME = 0;
    final static int DARK_THEME = 1;
    private static int textSize;
    final static int SMALL_TEXT = 0;
    final static int MEDIUM_TEXT = 1;
    final static int LARGE_TEXT = 2;

    static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }
    /** Set the theme of the activity, according to the configuration. */
    static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case NORMAL_THEME:
                activity.setTheme(R.style.NormalTheme);
                break;
            case DARK_THEME:
                activity.setTheme(R.style.DarkTheme);
                break;
        }
    }
}
