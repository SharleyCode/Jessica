package com.lx.jessica.fragment;


import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.lx.jessica.R;
import com.lx.jessica.base.BaseFragment;
import com.lx.jessica.bean.SliderViewEntity;
import com.lx.jessica.util.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Home_Fragment extends BaseFragment implements OkHttpUtil.onDownDataListener{

    private SliderLayout sliderLayout;
    private SliderViewEntity sliderViewEntity;
    private List<SliderViewEntity>datas;


    @Override
    protected int getViewResid() {
        return R.layout.home_fragment;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        sliderLayout = (SliderLayout) view.findViewById(R.id.slider);
        OkHttpUtil.downJSON("http://app.interface.jescard.com//index/indexInfo.html",this);
    }



    public void initSliderPager(List<SliderViewEntity>datas){

        for (SliderViewEntity sliderViewEntity : datas){
            TextSliderView textSliderView = new TextSliderView(getContext());
            textSliderView.image(sliderViewEntity.getPic());
            textSliderView.description(sliderViewEntity.getTitle());
            textSliderView.setScaleType(BaseSliderView.ScaleType.Fit);
            sliderLayout.addSlider(textSliderView);
        }
//        TextSliderView textSliderView = new TextSliderView(this);
//        textSliderView
//                .description("英国boots")
//                .image("http://7xq1l6.com2.z0.glb.qiniucdn.com/Fq6CamTvTeBsCrBXAs1gEtXplYdB");
//
//
//        TextSliderView textSliderView2 = new TextSliderView(this);
//        textSliderView2
//                .description("路易威登")
//                .image("http://7xq1l6.com2.z0.glb.qiniucdn.com/FpeMSiFqs8Pbil2r04GkUwsVr8QE");
//
//
//        TextSliderView textSliderView3 = new TextSliderView(this);
//        textSliderView3
//                .description("日上免税店")
//                .image("http://7xq1l6.com2.z0.glb.qiniucdn.com/Fq40DJy6YtvBZJ-S93BklQdjad3c");
//
//        sliderLayout.addSlider(textSliderView);
//        sliderLayout.addSlider(textSliderView2);
//        sliderLayout.addSlider(textSliderView3);
//
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        sliderLayout.setCustomIndicator(pagerIndicator);
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);

    }

    @Override
    public void onResponse(String url, String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0;i<jsonArray.length();i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String title = jsonObject.getString("title");
                String pic = jsonObject.getString("pic");
                sliderViewEntity.setPic(pic);
                sliderViewEntity.setTitle(title);
                datas.add(sliderViewEntity);
                initSliderPager(datas);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(String url, String error) {

    }
}
