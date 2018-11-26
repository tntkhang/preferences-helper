package khangtran.preferenceshelper;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by khang on 11/14/2017.
 */

public class PrefHelper {
    private static PrefHelper instance;
    private SharedPreferences prefs;

    public static PrefHelper getInstance() {
        if (instance == null) {
            throw new IllegalArgumentException("PrefHelper must be call initHelper on Application before using.");
        }
        return instance;
    }

    private PrefHelper(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    private PrefHelper(Context context, String sharePreferencesName) {
        prefs = context.getApplicationContext().getSharedPreferences(sharePreferencesName, Context.MODE_PRIVATE);
    }

    public static PrefHelper initHelper(Context context) {
        if (instance == null)
            instance = new PrefHelper(context);
        return instance;
    }

    public static PrefHelper initHelper(Context context, String sharePreferencesName) {
        if (instance == null)
            instance = new PrefHelper(context, sharePreferencesName);
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

    public <T> void setValue(String KEY, List<T> strings) {
        setValue(KEY, new Gson().toJson(strings));
    }

    public <T> void setValue(String KEY, T[] array) {
        JSONArray jArray = new JSONArray();
            for (T t : array) {
                jArray.put(t);
            }
        prefs.edit().putString(KEY, new Gson().toJson(jArray)).apply();
    }

    public <T> T[] getArrayValue(String KEY) {
        T[] results = null;
        try {
            JSONArray jArray = new JSONArray(prefs.getString(KEY, ""));
            for (int i = 0; i < jArray.length(); i++) {
                results[i] = (T) jArray.get(i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public <T> List<T> getListValue(String KEY) {
        List<T> objects = null;
        try {
            String obj = prefs.getString(KEY, "");
            objects = new Gson().fromJson(obj, new TypeToken<List<T>>() {}.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objects;
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

    public void removeKey(String KEY) {
        prefs.edit().remove(KEY).apply();
    }
    
    public void removeAllKeys() {
        prefs.edit().clear().apply();
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
