package com.lx.jessica.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 所有Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewResid());
        ButterKnife.bind(this);
        init();
        loadDatas();
    }


    /**
     * 初始化方法，具体实现应该交给子类
     */
    protected void init() {}

    /**
     * 加载数据方法，具体实现交给子类
     */
    protected void loadDatas() {}

    /**
     * 该方法由子类去实现，返回需要显示的布局ID
     * @return
     */
    protected abstract int getViewResid();

    /**
     * 启动Activity的过场动画
     * @param intent
     * @param animin
     * @param animout
     */
    public void startActivity(Intent intent , int animin, int animout){
        super.startActivity(intent);
        overridePendingTransition(animin, animout);
    }
}
