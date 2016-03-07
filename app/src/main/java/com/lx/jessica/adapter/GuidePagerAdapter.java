package com.lx.jessica.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lx.jessica.R;
import com.lx.jessica.activity.MainActivity;
import com.lx.jessica.util.L;

import java.util.List;

/**
 * Created by Administrator on 2016/3/7.
 */
public class GuidePagerAdapter extends PagerAdapter {
    /** 界面列表 */
    private List<View> views = null;
    /** 上下文内容 */
    private Context context = null;

    public GuidePagerAdapter(List<View> views, Context context){
        this.views = views;
        this.context = context;
    }

    /**
     * 获得当前界面数
     * @return
     */
    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    /**
     * 销毁position所在界面
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    /**
     * 初始化position所在界面
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        L.d("--instantiateItem-->");
        container.addView(views.get(position), 0);
        if (position == views.size() - 1){
            /** 若是最后一个界面 */
            Button guide_btn = (Button) container.findViewById(R.id.guide_btn);
            /** 设置图片按钮监听，做跳转操作 */
            guide_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }
            });
        }
        return views.get(position);
    }
}
