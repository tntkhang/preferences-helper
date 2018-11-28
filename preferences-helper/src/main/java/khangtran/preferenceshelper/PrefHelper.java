package khangtran.preferenceshelper;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * Created by khang on 11/14/2017.
 */

public class PrefHelper {
    private static PrefHelper instance;
    private SharedPreferences prefs;

    private static PrefHelper getInstance() {
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

    public static void setVal(String KEY, boolean value) {
        getInstance().prefs.edit().putBoolean(KEY, value).apply();
    }

    public static void setVal(String KEY, String value) {
        getInstance().prefs.edit().putString(KEY, value).apply();
    }

    public static void setVal(String KEY, Object value) {
        getInstance().prefs.edit().putString(KEY, new Gson().toJson(value)).apply();
    }

    public static void setVal(String KEY, int value) {
        getInstance().prefs.edit().putInt(KEY, value).apply();
    }

    public static void setVal(String KEY, long value) {
        getInstance().prefs.edit().putLong(KEY, value).apply();
    }

    public static void setVal(String KEY, float value) {
        getInstance().prefs.edit().putFloat(KEY, value).apply();
    }

    public static void setVal(String KEY, double value) {
        setVal(KEY, String.valueOf(value));
    }

    public static <T> void setVal(String KEY, List<T> list) {
        setVal(KEY, new Gson().toJson(list));
    }

    public static <K,V> void setVal(String KEY, Map<K,V> map) {
        setVal(KEY, new Gson().toJson(map));
    }

    public static <T> void setVal(String KEY, T[] array) {
        JSONArray jArray = new JSONArray();
            for (T t : array) {
                jArray.put(t);
            }
        getInstance().prefs.edit().putString(KEY, new Gson().toJson(jArray)).apply();
    }

    public static <T> T[] getArrayVal(String KEY) {
        T[] results = null;
        try {
            JSONArray jArray = new JSONArray(getInstance().prefs.getString(KEY, ""));
            for (int i = 0; i < jArray.length(); i++) {
                results[i] = (T) jArray.get(i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public static <T> List<T> getListVal(String KEY) {
        List<T> objects = null;
        try {
            String obj = getInstance().prefs.getString(KEY, "");
            objects = new Gson().fromJson(obj, new TypeToken<List<T>>() {}.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objects;
    }

    public static <K,V> Map<K,V> getMapVal(String KEY) {
        Map<K,V> objects = null;
        try {
            String obj = getInstance().prefs.getString(KEY, "");
            objects = new Gson().fromJson(obj, new TypeToken<Map<K,V>>() {}.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objects;
    }

    public static boolean getBooleanVal(String KEY, boolean defvalue) {
        return getInstance().prefs.getBoolean(KEY, defvalue);
    }

    public static String getStringVal(String KEY, String defvalue) {
        return getInstance().prefs.getString(KEY, defvalue);
    }

    public static <T> T getObjectVal(String KEY, Class<T> mModelClass) {
        Object object = null;
        try {
            object = new Gson().fromJson(getInstance().prefs.getString(KEY, ""), mModelClass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Primitives.wrap(mModelClass).cast(object);
    }

    public static int getIntVal(String KEY, int defVal) {
        return getInstance().prefs.getInt(KEY, defVal);
    }

    public static long getLongVal(String KEY, long defVal) {
        return getInstance().prefs.getLong(KEY, defVal);
    }

    public static float getFloatVal(String KEY, float defVal) {
        return getInstance().prefs.getFloat(KEY, defVal);
    }

    public static double getDoubleVal(String KEY, double defVal) {
        return Double.parseDouble(getStringVal(KEY, String.valueOf(defVal)));
    }

    public static void removeKey(String KEY) {
        getInstance().prefs.edit().remove(KEY).apply();
    }
    
    public static void removeAllKeys() {
        getInstance().prefs.edit().clear().apply();
    }

    public static boolean contain(String KEY) {
        return getInstance().prefs.contains(KEY);
    }

    public static void registerChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        getInstance().prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public static void unregisterChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        getInstance().prefs.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
