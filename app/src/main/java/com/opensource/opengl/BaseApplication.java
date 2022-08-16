package com.opensource.opengl;

import android.app.Application;

public class BaseApplication extends Application {
   @Override
   public void onCreate() {
      super.onCreate();
      AppCore.getInstance().init(this);
   }
}
