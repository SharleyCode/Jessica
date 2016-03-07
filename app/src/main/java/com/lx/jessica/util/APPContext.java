package com.lx.jessica.util;

import android.app.Application;

/**
 * Created by Administrator on 2016/3/5.
 */
public class APPContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpUtil.initOkHttp();
        FrescoUtil.initFresco(this);
    }
}
