package com.zhixing.staffid.widget.floatwindow;

/**
 * created by zhaobiying
 * on 2018/7/31
 */
public interface FloatStateListener {

    void onShow();

    void onHide();

    void onDismiss();

    void onMoveAnimStart();

    void onMoveAnimEnd();

    void onBackToDesktop();
}
