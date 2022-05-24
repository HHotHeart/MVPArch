package com.huangxiaoliang.mvparchdemo.activity;

import android.os.Bundle;

import com.huangxiaoliang.mvparchdemo.R;
import com.huangxiaoliang.mvparchdemo.fragment.LazyLoadFragment;
import com.huangxiaoliang.mvplib.mvp.BaseActivity;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

/**
 * @Author : HHotHeart
 * @Time : 2021/9/21 23:21
 * @Description : 懒加载Demo
 */
public class LazyLoadActivity extends BaseActivity {


    @Override
    protected void initContentView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_lazy_load, "懒加载Fragment Demo");

    }

    @Override
    protected void onBusiness(Bundle savedInstanceState) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_content, new LazyLoadFragment());
        transaction.commit();
    }

}