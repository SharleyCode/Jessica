package com.lx.jessica.activity;

import android.widget.ListView;

import com.lx.jessica.R;
import com.lx.jessica.base.BaseActivity;

/***
 *  目的地选择页面activity ***/
public class SelecDesActivity extends BaseActivity{
    private ListView lvDes;
    @Override
    protected int getViewResid() {
        return R.layout.activity_selectdes;
    }

    @Override
    protected void init() {
        lvDes= (ListView) findViewById(R.id.lv_des);
    }
/**
 * 下载数据
  */
    @Override
    protected void loadDatas() {
    }
}
