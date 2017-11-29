package khangtran.preferenceshelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import khangtran.preferenceshelper.PreferencesHelper;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_DOUBLE = "KEY_DOUBLE";
    private static final String KEY_INT = "KEY_INT";
    private static final String KEY_LONG = "KEY_LONG";
    private static final String KEY_STRING = "KEY_STRING";
    private static final String KEY_OBJECT = "KEY_OBJECT";
    private static final String KEY_FLOAT = "KEY_FLOAT";
    private static final String KEY_BOOLEAN = "KEY_BOOLEAN";

    private static final String TAG = "PreferencesHelperDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValueToPreferences();

        getValueFromPreferences();
    }

    private void setValueToPreferences() {
        PreferencesHelper.getInstance().setValue(KEY_BOOLEAN, true);
        PreferencesHelper.getInstance().setValue(KEY_DOUBLE, 123.123);
        PreferencesHelper.getInstance().setValue(KEY_FLOAT, 234.234f);
        PreferencesHelper.getInstance().setValue(KEY_INT, 345);
        PreferencesHelper.getInstance().setValue(KEY_LONG, Long.MAX_VALUE);
        PreferencesHelper.getInstance().setValue(KEY_STRING, "Khang");

        UserModel userModel = new UserModel("KhangTran", 27);
        PreferencesHelper.getInstance().setValue(KEY_OBJECT, userModel);
    }

    private void getValueFromPreferences() {
        boolean booleanValue = PreferencesHelper.getInstance().getBooleanValue(KEY_BOOLEAN, false);
        Log.i(TAG, "Boolean Value: " + booleanValue);

        double doubleValue = PreferencesHelper.getInstance().getDoubleValue(KEY_DOUBLE, Double.MIN_VALUE);
        Log.i(TAG, "Double Value: " + doubleValue);

        float floatValue = PreferencesHelper.getInstance().getFloatValue(KEY_FLOAT, Float.MIN_VALUE);
        Log.i(TAG, "Float Value: " + floatValue);

        int intValue = PreferencesHelper.getInstance().getIntValue(KEY_INT, Integer.MIN_VALUE);
        Log.i(TAG, "Integer Value: " + intValue);

        long longValue = PreferencesHelper.getInstance().getLongValue(KEY_LONG, Long.MIN_VALUE);
        Log.i(TAG, "Long Value: " + longValue);

        String stringValue = PreferencesHelper.getInstance().getStringValue(KEY_STRING, "Empty");
        Log.i(TAG, "String Value: " + stringValue);

        UserModel userModel = PreferencesHelper.getInstance().getObjectValue(KEY_OBJECT, UserModel.class);
        Log.i(TAG, "UserModel Value: " + userModel.toString());
    }
}
