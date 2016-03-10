package com.lx.jessica.util;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Administrator on 2016/3/5.
 */
public class APPContext extends Application {

    private ImageLoader mImageLoader;
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpUtil.initOkHttp();
        FrescoUtil.initFresco(this);
        initImageDisplay();
    }

    private void initImageDisplay(){
        //创建ImageLoader
        mImageLoader = ImageLoader.getInstance();

    }

    public ImageLoader getImageLoader(){
        return this.mImageLoader;
    }
}
