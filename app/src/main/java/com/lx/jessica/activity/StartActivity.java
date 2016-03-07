package com.lx.jessica.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lx.jessica.R;
import com.lx.jessica.base.BaseActivity;
import com.lx.jessica.util.Contacts;
import com.lx.jessica.util.L;
import com.lx.jessica.util.SharedPreferencesUtil;

/**
 * 实现没洗启动软件显示3秒背景，并判断是否第一次运行，是否开启引导页
 */
public class StartActivity extends AppCompatActivity {

    /** SharedPreferences操作，判断是否首次运行 */
    private SharedPreferencesUtil spu;
    /** 跳转界面 */
    private Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();
    }

    /**
     * 数据初始化
     */
    private void init() {
        L.d("--init--");
        spu = new SharedPreferencesUtil(StartActivity.this);
        mHandler = new Handler(){
            /**
             * 0:跳转到首页；1：跳转到引导页
             */
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                L.d("--handleMessage-->" + msg);
                switch (msg.what){
                    case 0:
                        goActivity(MainActivity.class);
                        break;
                    case 1:
                        goActivity(GuideActivity.class);
                        break;
                }
            }
        };
        int isFirst = spu.getInt(Contacts.IS_FIRST_RUN);
        L.d("GuideActivity_Test-->" + isFirst);
        if (isFirst == Contacts.NOT_FIRST){
            mHandler.sendEmptyMessageDelayed(0, 3000);
        } else {
            mHandler.sendEmptyMessageDelayed(1, 3000);
        }
    }

    private void goActivity(Class<?> cls) {
        L.d("--GoActivity--");
        Intent i = new Intent(this, cls);
        startActivity(i);
        this.finish();
    }
}
