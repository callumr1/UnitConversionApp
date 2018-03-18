package com.example.unitconversionapp;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Callum on 18/03/2018.
 */

public class Utils {
    private static int sTheme;
    public final static int  NORMAL_THEME= 0;
    public final static int DARK_THEME = 1;

    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }
    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
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
