package com.lx.jessica.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.daimajia.slider.library.SliderLayout;
import com.google.gson.Gson;
import com.lx.jessica.R;
import com.lx.jessica.activity.MainActivity;
import com.lx.jessica.adapter.RecycleViewAdapter;
import com.lx.jessica.base.BaseFragment;
import com.lx.jessica.bean.BannerEntity;

import com.lx.jessica.customView.ItemLine;
import com.lx.jessica.util.OkHttpUtil;

/**
 * 首页fragment
 */
public class HomeFragment extends BaseFragment {

    private Context context;
    private RecycleViewAdapter mrecycleViewAdapter;
    private RecyclerView mRecycleView;
    private RecyclerView classicalRecycleView;
    private LinearLayoutManager mlinearLayoutManager;
    //图片轮播
    private SliderLayout msliderLayout;
    //品牌列表，分类列表按钮
    private ImageView iv_band;
    private ImageView iv_class;



    @Override
    protected int getViewResid() {
        return R.layout.home_fragment;
    }



    @Override
    protected void init(View view) {
        super.init(view);
        mRecycleView = (RecyclerView) view.findViewById(R.id.rc_homefragment);
//        classicalRecycleView = (RecyclerView) view.findViewById(R.id.classical_brand_list);
//        mlinearLayoutManager = new LinearLayoutManager(context);
//        mlinearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
////        view = inflater.inflate(R.layout.home_fragment_slider_brand_class,null,false);
//        msliderLayout = (SliderLayout) view.findViewById(R.id.sl_pager);
//        iv_band = (ImageView) getActivity().findViewById(R.id.iv_brand);
//        iv_class = (ImageView) getActivity().findViewById(R.id.iv_classification);
//        /**
//         * 跳转品牌列表
//         */
//        iv_band.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity = (MainActivity) getActivity();
//                RadioButton rb = (RadioButton) mainActivity.findViewById(R.id.rb_price);
//                rb.performClick();
//
//
//            }
//        });
//
//        /**
//         * 跳转分类列表
//         */
//        iv_class.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity mainActivity = (MainActivity) getActivity();
//                RadioButton rb = (RadioButton) mainActivity.findViewById(R.id.rb_price);
//                rb.performClick();
//            }
//        });
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.downJSON("http://app.interface.jescard.com//index/indexInfo.html", new OkHttpUtil.onDownDataListener() {
            @Override
            public void onResponse(String url, String json) {
                BannerEntity bannerEntity = new Gson().fromJson(json.toString(), com.lx.jessica.bean.BannerEntity.class);

                mrecycleViewAdapter = new RecycleViewAdapter(getContext(),bannerEntity);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecycleView.setLayoutManager(layoutManager);
                mRecycleView.addItemDecoration(new ItemLine(getContext(),layoutManager.getOrientation()));
                mRecycleView.setAdapter(mrecycleViewAdapter);
            }

            @Override
            public void onFailure(String url, String error) {

            }
        });
    }




}

