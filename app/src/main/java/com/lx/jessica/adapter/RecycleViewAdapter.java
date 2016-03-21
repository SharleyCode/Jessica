package com.lx.jessica.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lx.jessica.R;
import com.lx.jessica.activity.MainActivity;
import com.lx.jessica.bean.BannerEntity;
import com.lx.jessica.customView.ItemLine;


/**
 * Created by lvhao on 2016/3/16 0016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int SLIDER_ITEM = 0;
    private static final int CLASSBRAND_ITEM = 1;
    private RecyclerView.ViewHolder holder;
    private  Context mContent;
    private BannerEntity bannerEntity;
    private LayoutInflater mLayoutInflater;
    boolean slider = false;


    public RecycleViewAdapter(Context mContext, BannerEntity bannerEntity) {
        this.mContent = mContext;
        this.bannerEntity = bannerEntity;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == SLIDER_ITEM){
            return new SliderHolder(mLayoutInflater.inflate(R.layout.home_fragment_slider_brand_class,parent,false));
        }
        if (viewType == CLASSBRAND_ITEM){
            return new ClassicalHolder(mLayoutInflater.inflate(R.layout.home_fragment_classical_brand,parent,false));
        }

        return new ClassicalHolder(mLayoutInflater.inflate(R.layout.home_fragment_classical_brand,parent,false));

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SliderHolder){
            SliderHolder viewholder = (SliderHolder) holder;
            if (!slider){
                for (int i = 0; i < (bannerEntity.getObj().getIndexBanner().getBrannerList().size()); i++) {
                    TextSliderView textSliderView = new TextSliderView(mContent);
                    textSliderView.description(bannerEntity.getObj().getIndexBanner().getBrannerList().get(i).getTitle())
                            .image(bannerEntity.getObj().getIndexBanner().getBrannerList().get(i).getPic());
                    viewholder.sliderLayout.addSlider(textSliderView);
                    slider = true;
                }
            }
        }else if (holder instanceof ClassicalHolder) {
            ClassicalHolder classicalHolder = (ClassicalHolder) holder;
            Uri uri = Uri.parse(bannerEntity.getObj().getIndexBrandRecomment().getBrandList().get(0).getHomePic());
            classicalHolder.iv1.setImageURI(uri);
            uri = Uri.parse(bannerEntity.getObj().getIndexBrandRecomment().getBrandList().get(1).getHomePic());
            classicalHolder.iv2.setImageURI(uri);


            ClassicalHolder_recycle_Adapter recycleAdapter;

            recycleAdapter = new ClassicalHolder_recycle_Adapter(mContent , bannerEntity);
            LinearLayoutManager rc_manager = new LinearLayoutManager(mContent);
            rc_manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            classicalHolder.recyclerView.setLayoutManager(rc_manager);
            classicalHolder.recyclerView.setAdapter(recycleAdapter);
        }

    }


    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return SLIDER_ITEM;
        }else if (position == 1){
            return CLASSBRAND_ITEM;
        }
        return super.getItemViewType(position);
    }

    /**
     * slider轮播和brand & class分类列表按钮
     */
    public class SliderHolder extends RecyclerView.ViewHolder {

        SliderLayout sliderLayout;
        ImageView iv_brand,iv_class;

        public SliderHolder(final View itemView) {
            super(itemView);
            sliderLayout = (SliderLayout) itemView.findViewById(R.id.sl_pager);
            iv_brand = (ImageView) itemView.findViewById(R.id.iv1_classical_brand);
            iv_class = (ImageView) itemView.findViewById(R.id.iv_classification);
            itemView.findViewById(R.id.home_fragment_slider_brand_class).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity mainActivity = (MainActivity) mContent;
                    RadioButton rb = (RadioButton) mainActivity.findViewById(R.id.rb_price);
                    rb.performClick();
                }
            });
        }
    }

    /**
     * 经典大牌模块ViewHolder
     */
    public class ClassicalHolder extends RecyclerView.ViewHolder {
        private ImageView iv1,iv2;
        private RecyclerView recyclerView;

        public ClassicalHolder(View itemView) {
            super(itemView);
            iv1 = (ImageView) itemView.findViewById(R.id.iv1_classical_brand);
            iv2 = (ImageView) itemView.findViewById(R.id.iv2_classical_brand);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.classical_brand_list);


            itemView.findViewById(R.id.home_fragment_classical_brand).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContent,"aa",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public class ClassicalHolder_recycle_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private Context mcontext;
        private BannerEntity bannerEntity;

        public  ClassicalHolder_recycle_Adapter(Context mcontext, BannerEntity bannerEntity) {
            this.mcontext = mcontext;
            this.bannerEntity = bannerEntity;

        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
            return new Classical_Recycle_Holder(mLayoutInflater.inflate(R.layout.home_frgment_classical_brand_recycle,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Classical_Recycle_Holder recycle_holder = (Classical_Recycle_Holder) holder;

                recycle_holder.tv_title.setText(bannerEntity.getObj().getIndexBrandRecomment().getGoodsList().get(position).getGoodLable());
                Uri uri = Uri.parse(bannerEntity.getObj().getIndexBrandRecomment().getGoodsList().get(position).getGoodPic());
                recycle_holder.sv.setImageURI(uri);

        }

        @Override
        public int getItemCount() {
            return bannerEntity.getObj().getIndexBrandRecomment().getGoodsList().size();
        }

        public class Classical_Recycle_Holder extends RecyclerView.ViewHolder {

            private TextView tv_title;
            private SimpleDraweeView sv;

            public Classical_Recycle_Holder(View itemView) {
                super(itemView);
                tv_title = (TextView) itemView.findViewById(R.id.tv);
                sv = (SimpleDraweeView) itemView.findViewById(R.id.sm);
                itemView.findViewById(R.id.recycle_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        }
    }


}
