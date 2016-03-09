package com.lx.jessica.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lx.jessica.R;
import com.lx.jessica.bean.SliderViewEntity;
import com.lx.jessica.util.FrescoUtil;

import java.util.List;

/**
 * Created by lvhao on 2016/3/9 0009.
 */
public class SliderLayoutAdapter extends BaseAdapter{

    private List<SliderViewEntity>mdatas;
    private Context context;
    private LayoutInflater mInflater;


    public SliderLayoutAdapter(List<SliderViewEntity>datas,Context context){
        this.mdatas = datas;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mdatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mdatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final  ViewHolder mSliderViewHolder;
        if (convertView == null){
            mSliderViewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.fragment_home,null);
            mSliderViewHolder.pic = (ImageView) convertView.findViewById(R.id.slider);

            convertView.setTag(mSliderViewHolder);
        }
        else {
            mSliderViewHolder = (ViewHolder) convertView.getTag();
        }
        //获取图片对象
        SliderViewEntity sliderViewEntity = mdatas.get(position);

        mSliderViewHolder.pic.setImageURI(Uri.parse(sliderViewEntity.getPic()));
        return convertView;
    }

    public class ViewHolder{
        public ImageView pic;
    }
}
