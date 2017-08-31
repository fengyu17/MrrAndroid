package com.alvin.architecture.mrr.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alvin.architecture.mrr.retrofit.RetrofitHelper;

import retrofit2.Retrofit;

/**
 * Created by dell on 2017/8/23.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Retrofit retrofit = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        retrofit = RetrofitHelper.getInstance().getRetrofit();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    protected abstract int layoutId();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void loadData();

}
