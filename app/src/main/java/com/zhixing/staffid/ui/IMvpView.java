package com.zhixing.staffid.ui;

/**
 * Created by zhaobiying
 * 2018/4/1.
 */

public interface IMvpView extends IBaseView {

    /**
     * 显示loading对话框
     */
    void showLoading();

    /**
     * 隐藏所有正在显示的loading对话框
     */
    void hideLoading();


}
