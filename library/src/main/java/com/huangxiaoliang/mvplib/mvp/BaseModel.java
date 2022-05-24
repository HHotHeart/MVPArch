package com.huangxiaoliang.mvplib.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @Author : HHotHeart
 * @Time : 2021/6/11 11:18
 * @Description : Model基类
 */
public abstract class BaseModel<T> implements IModel {

    private Context mContext;

    /**
     * Activity页面数据
     */
    private Intent mIntent;

    /**
     * Fragment页面数据
     */
    private Bundle args;

    /**
     * 接收页面传递的数据
     */
    protected abstract void initData();

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context content) {
        this.mContext = content;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public void setIntent(Intent intent) {
        mIntent = intent;
    }

    public Bundle getArgs() {
        return args;
    }

    public void setArgs(Bundle args) {
        this.args = args;
    }

    @Override
    public void onDestroy() {

    }


}
