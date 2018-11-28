# preferences-helper

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-PreferencesHelper-green.svg?style=flat )]( https://android-arsenal.com/details/1/6595 )

[ ![Download](https://api.bintray.com/packages/tntkhang/maven/preferences-helper/images/download.svg) ](https://bintray.com/tntkhang/maven/preferences-helper/_latestVersion)

SharePreferences is very popular with any project and all most all project has SharePreferences for saving data. This library will help you faster in configuration and use SharePreferences in your project. Let's setup and enjoy!

# Setup
1. Add to build.gradle in app level
```
implementation 'com.github.tntkhang:preferences-helper:1.3.1'
```


2. Init the PreferencesHelper in your CustomApplication.java extend from Application with 2 ways:
   
   - Will use app name as of Preferences file name ```PrefHelper.initHelper(this);```
   
   - Will use ```CustomName``` as the name of SharePreferences file ```PrefHelper.initHelper(this, "CustomName");```
   
3. How to use

   ### SET VALUE:
```
        PrefHelper.setVal(KEY_BOOLEAN, true);
        PrefHelper.setVal(KEY_DOUBLE, 123.123);
        PrefHelper.setVal(KEY_FLOAT, 234.234f);
        PrefHelper.setVal(KEY_INT, 345);
        PrefHelper.setVal(KEY_LONG, Long.MAX_VALUE);
        PrefHelper.setVal(KEY_STRING, "Khang");

        UserModel userModel = new UserModel("KhangTran", 27);
        PrefHelper.setVal(KEY_OBJECT, userModel);

        List<String> stringList =  Arrays.asList("Tran", "Nguyen", "Thai", "Khang");
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
   ```
   
   ### GET VALUE:
   
  ```    
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
   ```
   # DEMO

   Download and run project for simple demo

   **That is, let's enjoy!**
