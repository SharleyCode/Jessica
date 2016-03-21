package com.lx.jessica.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lx.jessica.R;
import com.lx.jessica.activity.SearchActivity;
import com.lx.jessica.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 全球比价fragment
 */
public class PriceFragment extends BaseFragment implements View.OnClickListener {

    private ViewPager mPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    private TextView tv_brand, tv_class, tv_search;
    private View view, view_class, view_brand;

    @Override
    protected int getViewResid() {
        return R.layout.fragment_price;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_price, container, false);
        initLayout();

        tv_class.performClick();
        mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private  int currentIndex;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                        tv_class.setTextColor(Color.rgb(25, 209, 206));
                        tv_brand.setTextColor(Color.rgb(156,163,162));
                        view_class.setBackgroundColor(Color.rgb(25, 209, 206));
                        view_brand.setBackgroundColor(Color.rgb(156,163,162));
                        break;
                    case 1:
                        tv_brand.setTextColor(Color.rgb(25, 209, 206));
                        tv_class.setTextColor(Color.rgb(156,163,162));
                        view_brand.setBackgroundColor(Color.rgb(25, 209, 206));
                        view_class.setBackgroundColor(Color.rgb(156,163,162));
                        break;
                }
                currentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;

    }

    /**
     * 初始化布局
     */
    private void initLayout() {
        tv_class = (TextView) view.findViewById(R.id.tv_class);
        tv_brand = (TextView) view.findViewById(R.id.tv_brand);
        tv_search = (TextView) view.findViewById(R.id.tv_search);

        view_class = view.findViewById(R.id.view_class);
        view_brand = view.findViewById(R.id.view_brand);

        mPager = (ViewPager) view.findViewById(R.id.vp_tab);



        tv_brand.setOnClickListener(this);
        tv_class.setOnClickListener(this);
        tv_search.setOnClickListener(this);

        ClassFragment f1 = new ClassFragment();
        BrandFragment f2 = new BrandFragment();

        mFragments.add(f1);
        mFragments.add(f2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_class:
                tv_class.setTextColor(Color.rgb(25, 209, 206));
                tv_brand.setTextColor(Color.rgb(156,163,162));
                view_class.setBackgroundColor(Color.rgb(25, 209, 206));
                view_brand.setBackgroundColor(Color.rgb(156,163,162));
                mPager.setCurrentItem(0);
                break;
            case R.id.tv_brand:
                tv_brand.setTextColor(Color.rgb(25, 209, 206));
                tv_class.setTextColor(Color.rgb(156,163,162));
                view_brand.setBackgroundColor(Color.rgb(25, 209, 206));
                view_class.setBackgroundColor(Color.rgb(156,163,162));
                mPager.setCurrentItem(1);
                break;
            case R.id.tv_search:
                getActivity().startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            default:
                break;
        }
    }


}
