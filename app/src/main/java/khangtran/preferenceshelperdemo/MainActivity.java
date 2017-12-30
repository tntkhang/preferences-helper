package khangtran.preferenceshelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import khangtran.preferenceshelper.PreferencesHelper;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_DOUBLE = "KEY_DOUBLE";
    private static final String KEY_INT = "KEY_INT";
    private static final String KEY_LONG = "KEY_LONG";
    private static final String KEY_STRING = "KEY_STRING";
    private static final String KEY_OBJECT = "KEY_OBJECT";
    private static final String KEY_FLOAT = "KEY_FLOAT";
    private static final String KEY_BOOLEAN = "KEY_BOOLEAN";
    private static final String KEY_ARRAY_LIST = "KEY_ARRAY_LIST";
    private static final String KEY_ARRAY = "KEY_ARRAY";

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

        List<String> stringList =  Arrays.asList("Tran", "Nguyen", "Thai", "Khang");
        PreferencesHelper.getInstance().setValue(KEY_ARRAY_LIST, stringList);

        String[] arr = new String[4];
        arr[0] = "Tran 2";
        arr[1] = "Nguyen 2";
        arr[2] = "Thai 2";
        arr[3] = "Khang 2";
        PreferencesHelper.getInstance().setValue(KEY_ARRAY, arr);
    }

    private void getValueFromPreferences() {
        boolean booleanValue = PreferencesHelper.getInstance().getBooleanValue(KEY_BOOLEAN, false);
        double doubleValue = PreferencesHelper.getInstance().getDoubleValue(KEY_DOUBLE, Double.MIN_VALUE);
        float floatValue = PreferencesHelper.getInstance().getFloatValue(KEY_FLOAT, Float.MIN_VALUE);
        int intValue = PreferencesHelper.getInstance().getIntValue(KEY_INT, Integer.MIN_VALUE);
        long longValue = PreferencesHelper.getInstance().getLongValue(KEY_LONG, Long.MIN_VALUE);
        String stringValue = PreferencesHelper.getInstance().getStringValue(KEY_STRING, "Empty");
        UserModel userModel = PreferencesHelper.getInstance().getObjectValue(KEY_OBJECT, UserModel.class);
        List<String> stringList = PreferencesHelper.getInstance().getListValue(KEY_ARRAY_LIST);
        String[] strings = PreferencesHelper.getInstance().getArrayValue(KEY_ARRAY);
    }
}
