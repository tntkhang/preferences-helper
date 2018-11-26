package khangtran.preferenceshelperdemo;

import android.app.Application;

import khangtran.preferenceshelper.PrefHelper;

/**
 * Created by khang on 11/29/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PrefHelper.initHelper(this);
        PrefHelper.initHelper(this, "CustomName");
    }
}
