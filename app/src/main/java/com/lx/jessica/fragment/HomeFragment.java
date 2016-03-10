package com.lx.jessica.fragment;



import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.lx.jessica.R;
import com.lx.jessica.base.BaseFragment;
import com.lx.jessica.bean.BannerEntity;
import com.lx.jessica.util.Contacts;
import com.lx.jessica.util.OkHttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页fragment
 */
public class HomeFragment extends BaseFragment {

    //图片轮播
    private SliderLayout msliderLayout;

    @Override
    protected int getViewResid() {
        return R.layout.home_fragment;

    }

    @Override
    protected void init(View view) {
        super.init(view);
        msliderLayout = (SliderLayout) view.findViewById(R.id.sl_pager);

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
    //class SliderViewAdapter extends FragmentPagerAdapter{

}

