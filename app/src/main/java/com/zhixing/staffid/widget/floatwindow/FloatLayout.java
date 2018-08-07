package com.zhixing.staffid.widget.floatwindow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zhixing.staffid.R;

/**
 * created by zhaobiying
 * on 2018/7/31
 */
public class FloatLayout extends FrameLayout {
    private WindowManager mWindowManager;
    private ImageView mFloatView;
    private long startTime;
    private float mTouchStartX;
    private float mTouchStartY;
    private boolean isclick;
    private WindowManager.LayoutParams mWmParams;
    private Context mContext;
    private long endTime;


    public FloatLayout(@NonNull Context context) {
        this(context, null);
        mContext = context;
    }

    public FloatLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.float_window_music, this);
        //浮动窗口按钮
        mFloatView = (ImageView) findViewById(R.id.iv_music_cd);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // 获取相对屏幕的坐标，即以屏幕左上角为原点
//        int x = (int) event.getRawX();
//        int y = (int) event.getRawY();
//        //下面的这些事件，跟图标的移动无关，为了区分开拖动和点击事件
//        int action = event.getAction();
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                startTime = System.currentTimeMillis();
//                mTouchStartX = event.getX();
//                mTouchStartY = event.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                //图标移动的逻辑在这里
//                float mMoveStartX = event.getX();
//                float mMoveStartY = event.getY();
//                // 如果移动量大于3才移动
//                if (Math.abs(mTouchStartX - mMoveStartX) > 3
//                        && Math.abs(mTouchStartY - mMoveStartY) > 3) {
//                    // 更新浮动窗口位置参数
//                    mWmParams.x = (int) (x - mTouchStartX);
//                    mWmParams.y = (int) (y - mTouchStartY);
//                    mWindowManager.updateViewLayout(this, mWmParams);
//                    return false;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                endTime = System.currentTimeMillis();
//                //当从点击到弹起小于半秒的时候,则判断为点击,如果超过则不响应点击事件
//                if ((endTime - startTime) > 0.1 * 1000L) {
//                    isclick = false;
//                } else {
//                    isclick = true;
//                }
//                break;
//        }
//        //响应点击事件
//        if (isclick) {
//
//        }
//        return true;
//    }

//    /**
//     * 将小悬浮窗的参数传入，用于更新小悬浮窗的位置。
//     *
//     * @param params 小悬浮窗的参数
//     */
//    public void setParams(WindowManager.LayoutParams params) {
//        mWmParams = params;
//    }

}
