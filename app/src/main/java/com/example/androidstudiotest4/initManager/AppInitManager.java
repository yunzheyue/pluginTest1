package com.example.androidstudiotest4.initManager;

public class AppInitManager {
    private static final String baseInit = "com.example.base.init.BaseAppInit";
    private static final String homeInit = "com.example.home.init.HomeAppInit";

    public static String[] initModules = {
            baseInit,
            homeInit
    };

}
