package khangtran.preferenceshelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import khangtran.preferenceshelper.PrefHelper;

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
    private static final String KEY_MAP = "KEY_MAP";

    private static final String TAG = "PreferencesHelperDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValueToPreferences();

        getValueFromPreferences();
    }

    private void setValueToPreferences() {
        PrefHelper.setVal(KEY_BOOLEAN, true);
        PrefHelper.setVal(KEY_DOUBLE, 123.123);
        PrefHelper.setVal(KEY_FLOAT, 234.234f);
        PrefHelper.setVal(KEY_INT, 345);
        PrefHelper.setVal(KEY_LONG, Long.MAX_VALUE);
        PrefHelper.setVal(KEY_STRING, "Khang");

        UserModel userModel = new UserModel("KhangTran", 27);
        PrefHelper.setVal(KEY_OBJECT, userModel);

        List<String> stringList = Arrays.asList("Tran", "Nguyen", "Thai", "Khang");
        PrefHelper.setVal(KEY_ARRAY_LIST, stringList);

        String[] arr = new String[4];
        arr[0] = "Tran 2";
        arr[1] = "Nguyen 2";
        arr[2] = "Thai 2";
        arr[3] = "Khang 2";
        PrefHelper.setVal(KEY_ARRAY, arr);

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Tr", "Tran");
        stringMap.put("N", "Nguyen");
        stringMap.put("Th", "Thai");
        stringMap.put("K", "Khang");
        PrefHelper.setVal(KEY_MAP, stringMap);
    }

    private void getValueFromPreferences() {
        boolean booleanValue = PrefHelper.getBooleanVal(KEY_BOOLEAN, false);
        double doubleValue = PrefHelper.getDoubleVal(KEY_DOUBLE, Double.MIN_VALUE);
        float floatValue = PrefHelper.getFloatVal(KEY_FLOAT, Float.MIN_VALUE);
        int intValue = PrefHelper.getIntVal(KEY_INT, Integer.MIN_VALUE);
        long longValue = PrefHelper.getLongVal(KEY_LONG, Long.MIN_VALUE);
        String stringValue = PrefHelper.getStringVal(KEY_STRING, "Empty");
        UserModel userModel = PrefHelper.getObjectVal(KEY_OBJECT, UserModel.class);
        List<String> stringList = PrefHelper.getListVal(KEY_ARRAY_LIST);
        String[] strings = PrefHelper.getArrayVal(KEY_ARRAY);
        Map<String, String> stringMap = PrefHelper.getMapVal(KEY_MAP);
    }
}
