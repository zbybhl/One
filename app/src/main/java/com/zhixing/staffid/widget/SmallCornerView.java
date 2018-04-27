package com.zhixing.staffid.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import android.widget.TextView;


import com.zhixing.staffid.R;

/**
 * created by zhaobiying
 * on 2018/4/26
 */
@SuppressLint("AppCompatCustomView")
public class SmallCornerView extends TextView {

    private Context mContext;

    private int width, height;         //view的宽，高

    private int mColor = Color.BLACK;  //背景颜色

    private int orientation = 0;       //角标的方向

    private Paint mPaint;              //画笔

    private float scale;               //屏幕密度

    public void setmColor(int mColor) {
        this.mColor = mColor;
        invalidate();
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
        invalidate();
    }

    public SmallCornerView(Context context) {
        super(context);
        this.mContext=context;
        initPaint();
    }

    public SmallCornerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        initAttr(attrs);
        initPaint();
    }

    public SmallCornerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        initAttr(attrs);
        initPaint();

    }

    private void initAttr(AttributeSet attrs) {
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.SmallCornerView);
        mColor = ta.getColor(R.styleable.SmallCornerView_scv_color, Color.RED);
        orientation = ta.getInt(R.styleable.SmallCornerView_scv_orientation, 0);
        ta.recycle();
    }
    private void initPaint() {
        scale= mContext.getResources().getDisplayMetrics().density;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.FILL);

    }


/*    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int   widthSpecMode =MeasureSpec.getMode(widthMeasureSpec);
        int   widthSpecSize =MeasureSpec.getSize(widthMeasureSpec);
        int   heightSpecMode =MeasureSpec.getMode(widthMeasureSpec);
        int   heightSpecSize =MeasureSpec.getSize(widthMeasureSpec);
        Rect rect = new Rect();
        String text = getText()+"";
        int length = text.length();
        if(length==0)return;
        Paint textPaint = new Paint();
        textPaint.setTextSize(getTextSize());
        textPaint.getTextBounds(text, 0, length, rect);
        int textWidth = rect.width();
        int textHeight = rect.height();

        if(widthSpecMode==MeasureSpec.AT_MOST&&heightSpecMode==MeasureSpec.AT_MOST){

            setMeasuredDimension(textWidth,textHeight);
        }
        else{
            setMeasuredDimension( widthSpecSize, heightSpecSize);
        }
    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mColor);
//        Rect rect = new Rect();
//        String text = getText().toString();
//        Paint textPaint = new Paint();
//        textPaint.setTextSize(getTextSize());
//        textPaint.getTextBounds(text, 0, text.length(), rect);
//        int width = rect.width();
//        int height = rect.height();

        int width=getWidth();
        int height=getHeight();
        Path p = new Path();

        if(width>=height) {
            if (orientation == 0) {
                p.moveTo(width, height);
                p.lineTo(width-height/2, height);
                p.lineTo(width, height/2);
                p.close();

            } else {
                p.moveTo(width-height/2, height);
                p.lineTo(width, height/2);
                p.lineTo(width-height/2, height/2);
                p.close();

            }
        }
        canvas.drawPath(p,mPaint);
    }
}
