package com.zhixing.staffid.service;

import android.view.View;

/**
 * created by zhaobiying
 * on 2018/7/31
 */
public abstract class FloatView {
    abstract void setSize(int width, int height);

    abstract void setView(View view);

    abstract void setGravity(int gravity, int xOffset, int yOffset);

    abstract void init();

    abstract void dismiss();

    void updateXY(int x, int y) {
    }

    void updateX(int x) {
    }

    void updateY(int y) {
    }

    int getX() {
        return 0;
    }

    int getY() {
        return 0;
    }
}
