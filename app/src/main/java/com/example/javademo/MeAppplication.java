package com.example.javademo;

import android.app.Application;

public class MeAppplication extends Application {
    // 获取全局实例
    public static MeAppplication getInstance() {
        return Instance;
    }
    private static MeAppplication Instance;


    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
    }
}
