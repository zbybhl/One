package com.zhixing.staffid.service;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.zhixing.staffid.widget.floatwindow.FloatStateListener;

/**
 * created by zhaobiying
 * on 2018/7/31
 * 浮窗的类，builder模式创建
 */
public class FloatWindow {

    private static Builder mBuilder = null;
    private View mView;
    private FloatStateListener mViewStateListener;
    private boolean mShow = false;
    private boolean mDesktopShow;
    int gravity;
    int xOffset;
    int yOffset;

    public static FloatWindow instance=null;

    private FloatWindow(Builder builder) {
        mView= builder.mView;
        mViewStateListener=builder.mViewStateListener;
        mShow =builder.mShow ;
        mDesktopShow=builder.mDesktopShow;
        gravity = builder.gravity;
        xOffset=builder.xOffset;
        yOffset=builder.xOffset;
    }

    public static Builder with(Context applicationContext) {
        return mBuilder = new Builder(applicationContext);
    }
    public static FloatWindow get() {
        return instance == null ? null :instance;
    }

    public static Builder getmBuilder() {
        return mBuilder;
    }

    public View getmView() {
        return mView;
    }

    public FloatStateListener getmViewStateListener() {
        return mViewStateListener;
    }

    public boolean ismShow() {
        return mShow;
    }

    public boolean ismDesktopShow() {
        return mDesktopShow;
    }


    public static class Builder{
        Context mApplicationContext;
        View mView;
        FloatStateListener mViewStateListener;
        boolean mShow = true;
        boolean mDesktopShow;
        int gravity = Gravity.RIGHT | Gravity.TOP;
        int xOffset;
        int yOffset;

        /**
         * @param gravity 窗口位置
         * @return
         */
        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        /**
         * @param xOffset 窗口x轴偏移
         * @return
         */
        public Builder setxOffset(int xOffset) {
            this.xOffset = xOffset;
            return this;
        }

        /**
         * @param yOffset 窗口y轴偏移
         * @return
         */
        public Builder setyOffset(int yOffset) {
            this.yOffset = yOffset;
            return this;
        }

        public Builder(Context mApplicationContext) {
            this.mApplicationContext = mApplicationContext;
        }

        /**
         * @param mView 窗口内的view
         * @return
         */
        public Builder setmView(View mView) {
            this.mView = mView;
            return this;
        }

        public Builder setmViewStateListener(FloatStateListener mViewStateListener) {
            this.mViewStateListener = mViewStateListener;
            return this;
        }

        /**
         * @param mShow 是否显示
         * @return
         */
        public Builder setmShow(boolean mShow) {
            this.mShow = mShow;
            return this;
        }

        /**
         * @param mDesktopShow 是否在桌面显示
         * @return
         */
        public Builder setmDesktopShow(boolean mDesktopShow) {
            this.mDesktopShow = mDesktopShow;
            return this;
        }

        /**
         *  创建FloatWindow对象
         */
        public void build() {
            instance =new FloatWindow(this);
        }

    }

}
