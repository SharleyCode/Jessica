package com.lx.jessica.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lx.jessica.R;
import com.lx.jessica.adapter.GuidePagerAdapter;
import com.lx.jessica.util.Contacts;
import com.lx.jessica.util.L;
import com.lx.jessica.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * 实现引导页的Activity
 */
public class GuideActivity extends AppCompatActivity {

    /** SharedPreferences操作，用来设置不再首次运行 */
    private SharedPreferencesUtil spu;
    /** 已知的引导页个数 */
    private int pageCount;
    /** 底部小点图片 */
    private ImageView[] dots;
    /** 保存每次引导上一种状态变量 */
    private int currentIndex;
    /** 适配器数据源 */
    private List<View> views;
    /** viewpager设置,显示各种图片*/
    private ViewPager viewPager_guide;
    /** viewPager适配器 */
    private GuidePagerAdapter guidePagerAdapter;
    /** 引导页小点 */
    private LinearLayout ll_guide_dots;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        L.d("--onCreate--");
        initData();
        initLayout();
    }

    /**
     * 初始化数据
     */
    public void initData() {
        L.d("--init--");
        /** 设置标识，表示不再启动这个引导页 */
        spu = new SharedPreferencesUtil(GuideActivity.this);
        spu.putInt(Contacts.IS_FIRST_RUN,Contacts.NOT_FIRST);
        /** 小点数据源 */
        pageCount = 4;
        dots = new ImageView[pageCount];
        currentIndex = 0;
        /** 设置ViewPager数据源*/
        views = new ArrayList<View>();
    }

    /**
     * 初始化布局
     */
    private void initLayout(){
        L.d("--initLayout--");
        /** viewPager设置 */
        viewPager_guide = (ViewPager) findViewById(R.id.vp_guide);
        LayoutInflater inflater = LayoutInflater.from(this);
        Class<R.drawable> cls = R.drawable.class;//准备反射R.drawable下资源
        for (int i = 0; i < pageCount; i++){
            View view = inflater.inflate(R.layout.guide_content, null);
            LinearLayout ll_guide_showImg = (LinearLayout) view.findViewById(R.id.ll_guide_showImg);
            int imageId = 0;
            try {
                imageId = cls.getDeclaredField("load" + (i + 1)).getInt(R.drawable.load1);
            } catch (Exception e) {
                imageId = R.drawable.load1;
                e.printStackTrace();
            }
            L.d("测试--imageId-->" + imageId + " views-->" + views);
            ll_guide_showImg.setBackgroundResource(imageId);
            views.add(view);
        }
        guidePagerAdapter = new GuidePagerAdapter(views, this);
        viewPager_guide.setAdapter(guidePagerAdapter);
        viewPager_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dots[position].setEnabled(false);
                dots[currentIndex].setEnabled(true);
                currentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //引导小点设置
        ll_guide_dots = (LinearLayout) findViewById(R.id.ll_guide_dots);
        for (int i = 0; i < pageCount; i++){//循环取得小点
            dots[i] = (ImageView) ll_guide_dots.getChildAt(i);
            if (i == 0){
                dots[i].setEnabled(false);//设置为蓝色，即选择状态
            } else {
                dots[i].setEnabled(true);//设置为白色，即未选中状态
            }
        }
    }

}
