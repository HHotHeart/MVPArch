package com.huangxiaoliang.mvparchdemo.activity.mvp;


import com.huangxiaoliang.mvplib.manager.toast.UIToast;
import com.huangxiaoliang.mvplib.mvp.BasePresenter;
import com.huangxiaoliang.mvplib.manager.log.UILog;
import com.huangxiaoliang.mvparchdemo.listener.NetCallback;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @Author : HHotHeart
 * @Time : 2021/6/11 11:53
 * @Description : Activity Presenter
 */
public class MvpDemoActivityPresenter extends BasePresenter<MvpDemoActivityModel, AContract.MyActivityView>
        implements AContract.MyActivityPresenter {
    private static final String TAG = "MvpDemoActivityPresenter";


    @Override
    public void loadData() {
        getMvpView().stateLoadingView();
        getMvpModel().requestNet(new NetCallback<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                getMvpView().addDispose(d);
            }

            @Override
            public void onSuccess(Long o) {
                getMvpView().stateContentView();
                getMvpView().showToast();
            }

            @Override
            public void onFailure(String msg) {
                getMvpView().stateErrorView();
                UIToast.showShort(msg);
            }
        });
    }

    @Override
    public void onReload() {
        getMvpView().stateLoadingView();
        getMvpModel().requestNet(new NetCallback<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                getMvpView().addDispose(d);
            }

            @Override
            public void onSuccess(Long aLong) {
                getMvpView().stateContentView();

            }

            @Override
            public void onFailure(String msg) {
                getMvpView().stateErrorView();
                UIToast.showShort(msg);
            }
        });
    }

    @Override
    public void onResume(@NonNull @NotNull LifecycleOwner owner) {
        super.onResume(owner);
    }


    /**
     * BasePresenter实现了和Activity或Fragment生命周期绑定，重写即可
     *
     * @param owner
     */
    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        super.onDestroy(owner);
        UILog.d(TAG, TAG + " onDestroy被调用");

    }

}