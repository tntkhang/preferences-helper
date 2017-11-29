# preferences-helper
This is a library help you faster on config and use SharePreferences

# Setting

1. Import module PreferencesHelper into your project

2. In your CustomApplication.java init the helper
   with
   
   PreferencesHelper.initHelper(this); 
   
   will use your application name as the name of SharePreferences file
   or
   
   PreferencesHelper.initHelper(this, "CustomName");
   
   will use "CustomName" as the name of SharePreferences file.
   
3. Let use it

   SET VALUE:
   
   PreferencesHelper.getInstance().setValue(KEY_BOOLEAN, true);
   PreferencesHelper.getInstance().setValue(KEY_DOUBLE, 123.123);
   PreferencesHelper.getInstance().setValue(KEY_FLOAT, 234.234f);
   PreferencesHelper.getInstance().setValue(KEY_INT, 345);
   PreferencesHelper.getInstance().setValue(KEY_LONG, Long.MAX_VALUE);
   PreferencesHelper.getInstance().setValue(KEY_STRING, "Khang");

   UserModel userModel = new UserModel("KhangTran", 27);
   PreferencesHelper.getInstance().setValue(KEY_OBJECT, userModel);
   
   
   GET VALUE:
   
   boolean booleanValue = PreferencesHelper.getInstance().getBooleanValue(KEY_BOOLEAN, false);
   double doubleValue = PreferencesHelper.getInstance().getDoubleValue(KEY_DOUBLE, Double.MIN_VALUE);
   float floatValue = PreferencesHelper.getInstance().getFloatValue(KEY_FLOAT, Float.MIN_VALUE);
   int intValue = PreferencesHelper.getInstance().getIntValue(KEY_INT, Integer.MIN_VALUE);
   long longValue = PreferencesHelper.getInstance().getLongValue(KEY_LONG, Long.MIN_VALUE);
   String stringValue = PreferencesHelper.getInstance().getStringValue(KEY_STRING, "Empty");
   UserModel userModel = PreferencesHelper.getInstance().getObjectValue(KEY_OBJECT, UserModel.class);
   
   ###### END ##############
