package com.lx.jessica.fragment;




import android.app.FragmentTransaction;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.lx.jessica.R;
import com.lx.jessica.activity.MainActivity;
import com.lx.jessica.base.BaseFragment;
import com.lx.jessica.bean.BannerEntity;

import com.lx.jessica.util.OkHttpUtil;

/**
 * 首页fragment
 */
public class HomeFragment extends BaseFragment {

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
        msliderLayout = (SliderLayout) view.findViewById(R.id.sl_pager);
        iv_band = (ImageView) view.findViewById(R.id.iv_brand);
        iv_class = (ImageView) view.findViewById(R.id.iv_classification);
        /**
         * 跳转品牌列表
         */
        iv_band.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                RadioButton rb = (RadioButton) mainActivity.findViewById(R.id.rb_price);
                rb.performClick();
            }
        });

        /**
         * 跳转分类列表
         */
        iv_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                RadioButton rb = (RadioButton) mainActivity.findViewById(R.id.rb_price);
                rb.performClick();
            }
        });
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        OkHttpUtil.downJSON("http://app.interface.jescard.com//index/indexInfo.html", new OkHttpUtil.onDownDataListener() {
            @Override
            public void onResponse(String url, String json) {
                BannerEntity bannerEntity = new Gson().fromJson(json.toString(), com.lx.jessica.bean.BannerEntity.class);
                for (int i = 0 ; i<((bannerEntity.getObj().getIndexBanner().getBrannerList()).size());i++) {
                    TextSliderView textSliderView = new TextSliderView(getContext());
                    textSliderView.description(bannerEntity.getObj().getIndexBanner().getBrannerList().get(i).getTitle())
                                  .image(bannerEntity.getObj().getIndexBanner().getBrannerList().get(i).getPic());
                    Log.d("print", String.valueOf(textSliderView));
                    msliderLayout.addSlider(textSliderView);
                }
            }

            @Override
            public void onFailure(String url, String error) {

            }
        });
    }




}

