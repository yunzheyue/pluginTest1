package com.example.androidstudiotest4;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import com.example.androidstudiotest4.initManager.AppInitManager;
import com.example.base.init.IAppInit;

public class MyAppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "MyAppApplication====onCreate==");

//        利用反射去初始化其他module中的内容，对性能有些损害
        initApplicationPre();
        initApplicationAfter();
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    private void initApplicationPre() {
        for (String init : AppInitManager.initModules) {
            try {
                Class<IAppInit> aClass = (Class<IAppInit>) Class.forName(init);
                IAppInit iAppInit = aClass.newInstance();
                iAppInit.onInitPre(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initApplicationAfter() {
        for (String init : AppInitManager.initModules) {
            try {
                Class<IAppInit> aClass = (Class<IAppInit>) Class.forName(init);
                IAppInit iAppInit = aClass.newInstance();
                iAppInit.onInitAfter(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //终止应用程序对象时调用，不保证一定被调用，当
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.e("TAG", "onTerminate====");
    }

    //当后台程序终止且资源还匮乏时会调用这个方法，应该在这里释放一些资源
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e("TAG", "onLowMemory====");
    }

    /**
     * TRIM_MEMORY_COMPLETE,
     * TRIM_MEMORY_MODERATE,
     * TRIM_MEMORY_BACKGROUND,
     * TRIM_MEMORY_UI_HIDDEN, 一般返回这个
     * TRIM_MEMORY_RUNNING_CRITICAL,
     * TRIM_MEMORY_RUNNING_LOW,
     * TRIM_MEMORY_RUNNING_MODERATE,
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.e("TAG", "onTrimMemory====" + level);
    }

    //配置改变时出发这个方法，比如屏幕旋转
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("TAG", "onConfigurationChanged====");
    }


    private ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            Log.e("TAG", "onActivityCreated==activity==" + activity.getLocalClassName());
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.e("TAG", "onActivityStarted==activity==" + activity.getLocalClassName());
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.e("TAG", "onActivityResumed==activity==" + activity.getLocalClassName());
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Log.e("TAG", "onActivityPaused==activity==" + activity.getLocalClassName());
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.e("TAG", "onActivityStopped==activity==" + activity.getLocalClassName());
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Log.e("TAG", "onActivitySaveInstanceState==activity==" + activity.getLocalClassName());
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Log.e("TAG", "onActivityDestroyed==activity==" + activity.getLocalClassName());
        }
    };
}
