package com.zhixing.staffid.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * created by zhaobiying
 * on 2018/7/31
 */
public class MusicFloatService extends Service {
    private FloatWindowManager mFloatView;

    @Override
    public void onCreate() {
        super.onCreate();
        mFloatView = new FloatWindowManager(this,FloatWindow.get());
        mFloatView.setView(FloatWindow.get().getmView());
        mFloatView.setGravity(FloatWindow.get().gravity,FloatWindow.get().xOffset,FloatWindow.get().yOffset);
        mFloatView.show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //移除悬浮窗
        mFloatView.dismiss();

    }


}
