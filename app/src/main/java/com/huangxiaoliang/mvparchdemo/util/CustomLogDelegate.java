package com.huangxiaoliang.mvparchdemo.util;

import android.util.Log;

import com.huangxiaoliang.mvplib.manager.log.UILog;

/**
 * <pre>@author HHotHeart</pre>
 * <pre>@date 2021/9/24 10:01</pre>
 * <pre>@desc 自定义Log代理</pre>
 */
public class CustomLogDelegate implements UILog.LogDelegate {

    @Override
    public String getTag() {
        return "日志Tag";
    }

    @Override
    public UILog.LogDelegate init() {
        //做一些初始化工作
        return this;
    }

    @Override
    public void v(String tag, String msg, Object... obj) {
        Log.v(tag, msg);
    }

    @Override
    public void d(String tag, String msg, Object... obj) {
        //自己的Log库
        Log.d(tag, msg);

    }

    @Override
    public void i(String tag, String msg, Object... obj) {
        //自己的Log库
        Log.i(tag, msg);

    }

    @Override
    public void w(String tag, String msg, Object... obj) {
        //自己的Log库
        Log.w(tag, msg);

    }

    @Override
    public void e(String tag, String msg, Object... obj) {
        //自己的Log库
        Log.e(tag, msg);

    }

    @Override
    public void xml(String tag, String msg) {
        //自己的Log库

    }

    @Override
    public void json(String tag, String msg) {
        //自己的Log库

    }

    @Override
    public void printErrStackTrace(String tag, Throwable throwable) {
        //自己的Log库

    }
}
