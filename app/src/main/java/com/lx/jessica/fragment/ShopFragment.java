package com.lx.jessica.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.lx.jessica.R;
import com.lx.jessica.activity.SelecDesActivity;
import com.lx.jessica.base.BaseFragment;
import com.lx.jessica.util.Contacts;

/**
 * Created by Administrator on 2016/3/7.
 */
public class ShopFragment extends BaseFragment implements View.OnClickListener {
    private Button btn;
    @Override
    protected int getViewResid() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void init(View view) {
        btn= (Button) view.findViewById(R.id.btn_des);
        btn.setOnClickListener(this);
    }
     /**
     点击选择目的地
     */
    @Override
    public void onClick(View v) {
        startActivityForResult(new Intent(getActivity(),SelecDesActivity.class), Contacts.REQUEST_DES);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
