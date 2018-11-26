# preferences-helper

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-PreferencesHelper-green.svg?style=flat )]( https://android-arsenal.com/details/1/6595 )

[ ![Download](https://api.bintray.com/packages/tntkhang/maven/preferences-helper/images/download.svg) ](https://bintray.com/tntkhang/maven/preferences-helper/_latestVersion)

SharePreferences is very popular with any project and all most all project has SharePreferences for saving data. This library will help you faster in configuration and use SharePreferences in your project. Let's setup and enjoy!

# Setup
1. Add to build.gradle in app level
```
implementation 'com.github.tntkhang:preferences-helper:1.2.0'
```


2. Init the PreferencesHelper in your CustomApplication.java extend from Application with 2 ways:
   
   - Will use app name as of Preferences file name ```PrefHelper.initHelper(this);```
   
   - Will use ```CustomName``` as the name of SharePreferences file ```PrefHelper.initHelper(this, "CustomName");```
   
3. How to use

   ### SET VALUE:
```
   
  PrefHelper.getInstance().setValue(KEY_BOOLEAN, true)

  PrefHelper.getInstance().setValue(KEY_DOUBLE, 123.123);
  
  PrefHelper.getInstance().setValue(KEY_FLOAT, 234.234f);
  
  PrefHelper.getInstance().setValue(KEY_INT, 345);
  
  PrefHelper.getInstance().setValue(KEY_LONG, Long.MAX_VALUE);
  
  PrefHelper.getInstance().setValue(KEY_STRING, "Khang");

  UserModel userModel = new UserModel("KhangTran", 27);
  PrefHelper.getInstance().setValue(KEY_OBJECT, userModel);

  List<String> stringList =  Arrays.asList("Tran", "Nguyen", "Thai", "Khang");
  PrefHelper.getInstance().setValue(KEY_ARRAY_LIST, stringList);

  String[] arr = new String[4];
  arr[0] = "Tran 2";
  arr[1] = "Nguyen 2";
  arr[2] = "Thai 2";
  arr[3] = "Khang 2";
  PrefHelper.getInstance().setValue(KEY_ARRAY, arr);
   ```
   
   ### GET VALUE:
   
  ``` 
   
  boolean booleanValue = PrefHelper.getInstance().getBooleanValue(KEY_BOOLEAN, false);
  
  double doubleValue = PrefHelper.getInstance().getDoubleValue(KEY_DOUBLE, Double.MIN_VALUE);
  
  float floatValue = PrefHelper.getInstance().getFloatValue(KEY_FLOAT, Float.MIN_VALUE);
  
  int intValue = PrefHelper.getInstance().getIntValue(KEY_INT, Integer.MIN_VALUE);
  
  long longValue = PrefHelper.getInstance().getLongValue(KEY_LONG, Long.MIN_VALUE);
  
  String stringValue = PrefHelper.getInstance().getStringValue(KEY_STRING, "Empty");
  
  UserModel userModel = PrefHelper.getInstance().getObjectValue(KEY_OBJECT, UserModel.class);
  
  List<String> stringList = PrefHelper.getInstance().getListValue(KEY_ARRAY_LIST);
  
  String[] strings = PrefHelper.getInstance().getArrayValue(KEY_ARRAY);
  
   ```
   # DEMO

   Download and run project for simple demo

   **That is, let's enjoy!**
