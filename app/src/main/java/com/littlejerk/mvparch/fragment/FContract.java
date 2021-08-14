package com.littlejerk.mvparch.fragment;


import com.littlejerk.library.mvp.IView;

/**
 * @author : HHotHeart
 * @date : 2021/8/14 11:50
 * @desc : 描述
 */
public class FContract {

    public interface MyFragmentModel {
        void requestNet();
    }

    public interface MyFragmentView extends IView {
        void showToast();

    }

    public interface MyFragmentPresenter {
        void loadData();

        default void onReload() {

        }
    }


}
