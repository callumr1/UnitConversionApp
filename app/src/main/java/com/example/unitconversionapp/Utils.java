package com.example.unitconversionapp;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Callum on 18/03/2018.
 */

class Utils {
    private static int sTheme;
    final static int  NORMAL_THEME = 0;
    final static int DARK_THEME = 1;

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
