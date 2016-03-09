package com.lx.jessica.fragment;



import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.lx.jessica.R;
import com.lx.jessica.adapter.SliderLayoutAdapter;
import com.lx.jessica.base.BaseFragment;
import com.lx.jessica.bean.SliderViewEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页fragment
 */
public class HomeFragment extends BaseFragment {

    //图片轮播
    private SliderLayout msliderLayout;
    private SliderLayoutAdapter mAdapter;
    private List<SliderViewEntity>msliderViewList;

    @Override
    protected int getViewResid() {
        return R.layout.fragment_home;

    }

    @Override
    protected void init(View view) {
        super.init(view);
        msliderLayout = (SliderLayout) view.findViewById(R.id.slider);

        msliderViewList = new ArrayList<SliderViewEntity>();

        mAdapter = new SliderLayoutAdapter(msliderViewList,getContext());

    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
    }
}
