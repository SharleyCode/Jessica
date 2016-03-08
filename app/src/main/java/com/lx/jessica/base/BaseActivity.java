package com.lx.jessica.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 所有Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment showFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
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

    /**
     * fragment管理——不包含过场动画的方式
     */
    public void fragmentManager(int fl_resid, Class fclass){
        fragmentManager(fl_resid, 0, 0, fclass);
    }
    /**
     * 包含动画的fragment管理
     * @param fl_resid 给fragment占位的布局id
     * @param fclass fragment进入的动画
     * @param inanim fragment退出的动画
     * @param outanim 需要显示的fragment的Class对象
     */
    public void fragmentManager(int fl_resid, int inanim, int outanim, Class<BaseFragment> fclass){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(inanim != 0 || outanim != 0){
            fragmentTransaction.setCustomAnimations(inanim, outanim);
        }

        Fragment fragmentByTag = fragmentManager.findFragmentByTag(fclass.getName());
        if(showFragment != null){
            fragmentTransaction.hide(showFragment);
        }
        if(fragmentByTag != null){
            fragmentTransaction.show(fragmentByTag);
            showFragment = fragmentByTag;
        } else {
            BaseFragment baseFragment = BaseFragment.getInstance(fclass);
            fragmentTransaction.add(fl_resid, baseFragment, fclass.getName());
            showFragment = baseFragment;
        }
        fragmentTransaction.commit();
    }
}
