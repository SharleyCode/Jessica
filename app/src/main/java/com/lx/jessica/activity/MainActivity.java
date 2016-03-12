package com.lx.jessica.activity;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lx.jessica.R;
import com.lx.jessica.base.BaseActivity;
import com.lx.jessica.fragment.ClassFragment;
import com.lx.jessica.fragment.HomeFragment;
import com.lx.jessica.fragment.MemoFragment;
import com.lx.jessica.fragment.MyFragment;
import com.lx.jessica.fragment.PriceFragment;
import com.lx.jessica.fragment.ShopFragment;
import com.lx.jessica.util.L;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private long mExitTime = 0;
    public static final int EXIT_TIME_GAP = 2000;
    @Override
    protected int getViewResid() {
        return R.layout.activity_main;
    }

    /**
     * 初始化方法
     */
    @Override
    protected void init() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        radioGroup.setOnCheckedChangeListener(this);
        //模拟点击home页面按钮
        radioGroup.getChildAt(2).performClick();

        L.d("屏幕宽高：" + getResources().getDisplayMetrics().widthPixels + " "
                + getResources().getDisplayMetrics().heightPixels);

    }

    /**
     * RadioButton导航选择事件
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_price://全球比价
                fragmentManager(R.id.fl_main, PriceFragment.class);
                break;
            case R.id.rb_shop://目的地商城
                fragmentManager(R.id.fl_main, ShopFragment.class);
                break;
            case R.id.rb_home://首页
                fragmentManager(R.id.fl_main, HomeFragment.class);
                break;
            case R.id.rb_memo://旅游便笺
                fragmentManager(R.id.fl_main, MemoFragment.class);
                break;
            case R.id.rb_mine://个人中心
                fragmentManager(R.id.fl_main, MyFragment.class);
                break;
        }
    }

    /**
     * 实现按两次back键退出程序的功能
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode){
            goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void goBack() {
        if (SystemClock.uptimeMillis() - mExitTime > EXIT_TIME_GAP){
            Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
            mExitTime = SystemClock.uptimeMillis();
        }else{
            MainActivity.this.finish();
        }
    }

}
