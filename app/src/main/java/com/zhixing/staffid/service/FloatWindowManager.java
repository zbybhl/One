package com.zhixing.staffid.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.Build;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zhixing.staffid.util.AppLog;

/**
 * created by zhaobiying
 * on 2018/7/31
 * 应用级浮窗管理类
 */
public class FloatWindowManager extends FloatView{
    private final Context mContext;
    private final WindowManager mWindowManager;
    private final WindowManager.LayoutParams mLayoutParams;
    private FloatWindow floatWindow;
    private View mView;

    private volatile boolean isRemove = false;
    private volatile boolean once = true;
    private volatile boolean isShow = false;

    FloatWindowManager(Context applicationContext,FloatWindow floatWindow){
        this.floatWindow=floatWindow;
        mContext = applicationContext;
        mWindowManager = (WindowManager) applicationContext.getSystemService(Context.WINDOW_SERVICE);
        mLayoutParams = new WindowManager.LayoutParams();
        mLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mLayoutParams.format = PixelFormat.RGBA_8888; //设置图片格式为透明
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        mLayoutParams.windowAnimations = 0;
        mLayoutParams.gravity = Gravity.RIGHT | Gravity.TOP;
    }

    @Override
    void setSize(int width, int height) {
        mLayoutParams.width = width;
        mLayoutParams.height = height;
    }

    @Override
    void setView(View view) {
        mView = view;
    }

    @Override
    void setGravity(int gravity, int xOffset, int yOffset) {
        mLayoutParams.gravity = gravity;
        mLayoutParams.x = xOffset;
        mLayoutParams.y = yOffset;
    }

    @Override
    void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ) {
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            mWindowManager.addView(mView, mLayoutParams);
        }
        else {
            try {
                mLayoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
                mWindowManager.addView(mView, mLayoutParams);
            } catch (Exception e) {
                mWindowManager.removeView(mView);
                AppLog.e("TYPE_TOAST 失败");
                req();
            }
        }
    }
    private void req() {
        String packname = mContext.getPackageName();
        PackageManager pm = mContext.getPackageManager();
        boolean permission = (PackageManager.PERMISSION_GRANTED == pm.checkPermission("android.permission.SYSTEM_ALERT_WINDOW", packname));
        if (permission) {
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            mWindowManager.addView(mView, mLayoutParams);
        } else {
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
            mWindowManager.addView(mView, mLayoutParams);
        }
    }
    @Override
    void dismiss() {
        isRemove = true;
        mWindowManager.removeView(mView);
    }

    public void show() {
        if (once) {
            init();
            once = false;
            isShow = true;
        } else {
            if (isShow) {
                return;
            }
            mView.setVisibility(View.VISIBLE);
            isShow = true;
        }
        if (floatWindow.getmViewStateListener() != null) {
            floatWindow.getmViewStateListener().onShow();
        }
    }

    public void hide() {
        if (once || !isShow) {
            return;
        }
        mView.setVisibility(View.INVISIBLE);
        isShow = false;
        if (floatWindow.getmViewStateListener() != null) {
            floatWindow.getmViewStateListener().onHide();
        }
    }
}
