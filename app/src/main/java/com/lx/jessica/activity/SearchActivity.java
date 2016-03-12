package com.lx.jessica.activity;

import android.content.Intent;
import android.view.View;

import com.lx.jessica.R;
import com.lx.jessica.base.BaseActivity;

public class SearchActivity extends BaseActivity {


    @Override
    protected int getViewResid() {
        return R.layout.activity_search;
    }

    public void searchClick(View v) {
        switch (v.getId()){
            case R.id.ib_back:
            this.startActivity(new Intent(this, MainActivity.class));
            break;
            case R.id.ib_cancel:
                break;
            case R.id.btn_search:
                break;

        }
    }
}
