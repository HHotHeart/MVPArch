package com.littlejerk.mvparch.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;

import com.blankj.utilcode.util.SPStaticUtils;
import com.blankj.utilcode.util.SPUtils;
import com.dylanc.loadinghelper.LoadingHelper;
import com.dylanc.loadinghelper.ViewType;
import com.littlejerk.library.manager.MVPArchConfig;
import com.littlejerk.library.manager.lcet.GEmptyAdapter;
import com.littlejerk.library.manager.lcet.GErrorAdapter;
import com.littlejerk.library.manager.lcet.GLoadingAdapter;
import com.littlejerk.library.manager.lcet.TitleParam;
import com.littlejerk.mvparch.R;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import kotlin.Unit;

/**
 * @Author : HHotHeart
 * @Time : 2021/6/1 19:02
 * @Description : 描述
 */
public class MVPArchAPP extends Application {

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
            return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> {
            //指定为经典Footer，默认是 BallPulseFooter
            return new ClassicsFooter(context).setDrawableSize(20);
        });

//        //设置代理对象
//        UILog.setDelegate(new UILogDelegate().init());
//        UIToast.setDelegate(new UIToastDelegate());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        MVPArchConfig.getInstance().setLightStatusBar(false)
                .setStatusBarColor(Color.BLACK)
                .setTitleParam(new TitleParam()
                        .setLeftIcon(R.drawable.ic_arrow_back_black)
                        .setMiddleTextSize(17f)
                        .setMiddleTextColor(Color.BLACK)
                        .setTitleBarHeight(60f)
                        .setTittleBarBgColor(Color.WHITE)
                        .setRightIconVisible(false)
                        .setBottomLineColor(Color.LTGRAY)
                        .setBottomLineHeight(0.5f));

        //设置全局LCE
        LoadingHelper.setDefaultAdapterPool(adapterPool -> {
            adapterPool.register(ViewType.LOADING, new GLoadingAdapter());
            adapterPool.register(ViewType.ERROR, new GErrorAdapter());
            adapterPool.register(ViewType.EMPTY, new GEmptyAdapter());
            return Unit.INSTANCE;
        });

        //设置全局sp文件名
        SPStaticUtils.setDefaultSPUtils(SPUtils.getInstance(MVPArchConfig.SP_TAG));
//        MVPArchConfig.getInstance().setImageLoader();
    }
}
