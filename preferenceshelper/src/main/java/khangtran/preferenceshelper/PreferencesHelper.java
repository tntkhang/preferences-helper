package khangtran.preferenceshelper;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;

/**
 * Created by khang on 11/14/2017.
 */

public class PreferencesHelper {
    private static PreferencesHelper instance;
    private SharedPreferences prefs;

    public static PreferencesHelper getInstance() {
        return instance;
    }

    public PreferencesHelper(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    public PreferencesHelper(Context context, String sharePreferencesName) {
        prefs = context.getApplicationContext().getSharedPreferences(sharePreferencesName, Context.MODE_PRIVATE);
    }

    public static PreferencesHelper initHelper(Context context) {
        if (instance == null)
            instance = new PreferencesHelper(context);
        return instance;
    }

    public static PreferencesHelper initHelper(Context context, String sharePreferencesName) {
        if (instance == null)
            instance = new PreferencesHelper(context, sharePreferencesName);
        return instance;
    }

    public void setValue(String KEY, boolean value) {
        prefs.edit().putBoolean(KEY, value).apply();
    }

    public void setValue(String KEY, String value) {
        prefs.edit().putString(KEY, value).apply();
    }

    public void setValue(String KEY, Object value) {
        prefs.edit().putString(KEY, new Gson().toJson(value)).apply();
    }

    public void setValue(String KEY, int value) {
        prefs.edit().putInt(KEY, value).apply();
    }

    public void setValue(String KEY, long value) {
        prefs.edit().putLong(KEY, value).apply();
    }

    public void setValue(String KEY, float value) {
        prefs.edit().putFloat(KEY, value).apply();
    }

    public void setValue(String KEY, double defValue) {
        setValue(KEY, String.valueOf(defValue));
    }

    public boolean getBooleanValue(String KEY, boolean defvalue) {
        return prefs.getBoolean(KEY, defvalue);
    }

    public String getStringValue(String KEY, String defvalue) {
        return prefs.getString(KEY, defvalue);
    }

    public <T> T getObjectValue(String KEY, Class<T> mModelClass) {
        Object object = null;
        try {
            object = new Gson().fromJson(prefs.getString(KEY, ""), mModelClass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Primitives.wrap(mModelClass).cast(object);
    }

    public int getIntValue(String KEY, int defValue) {
        return prefs.getInt(KEY, defValue);
    }

    public long getLongValue(String KEY, long defValue) {
        return prefs.getLong(KEY, defValue);
    }

    public float getFloatValue(String KEY, float defValue) {
        return prefs.getFloat(KEY, defValue);
    }

    public double getDoubleValue(String KEY, double defValue) {
        return Double.parseDouble(getStringValue(KEY, String.valueOf(defValue)));
    }

    public void removeValue(String KEY) {
        prefs.edit().remove(KEY).apply();
    }

    public boolean contain(String KEY) {
        return prefs.contains(KEY);
    }

    public void registerChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        prefs.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
