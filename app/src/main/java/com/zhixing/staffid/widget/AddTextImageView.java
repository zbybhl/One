package com.zhixing.staffid.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhixing.staffid.R;

/**
 * created by zhaobiying
 * on 2018/7/7
 */
public class AddTextImageView extends FrameLayout {
    private Context mContext;
    private ImageView mImageView = null;
    private TextView mTextView = null;
    private int mColor = Color.BLACK;  //背景颜色
    private int imageId;
    private String text;

    public AddTextImageView(@NonNull Context context) {
        this(context, null);
    }

    public AddTextImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public AddTextImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;

        if (mImageView == null) {
            mImageView = new ImageView(context);
        }
        if (mTextView == null) {
            mTextView = new TextView(context);
        }
        if (attrs == null)
            return;
        mImageView.setCropToPadding(true);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL;
        mTextView.setLayoutParams(lp);
        initAttr(attrs);
        init();

    }
    /**
     * 初始化状态
     */
    private void init() {
        this.setText(text);
        mTextView.setGravity(Gravity.CENTER);//字在textview里面居中
        this.setTextColor(mColor);
        this.setImgResource(imageId);
        addView(mImageView);//将图片控件加入到布局中
        addView(mTextView);//将文字控件加入到布局中
    }
    private void initAttr(AttributeSet attrs) {
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.AddTextImageView);
        mColor = ta.getColor(R.styleable.AddTextImageView_txt_color, Color.WHITE);
        text= ta.getString(R.styleable.AddTextImageView_txt_content);
        imageId= ta.getResourceId(R.styleable.AddTextImageView_img_src,0);
        ta.recycle();
    }
    /**
     * 设置显示的图片
     *
     * @param resourceID 图片ID
     */
    private void setImgResource(int resourceID) {
        if (resourceID == 0) {
            this.mImageView.setImageResource(0);
        } else {
            this.mImageView.setImageResource(resourceID);
        }
    }

    /**
     * 设置显示的文字
     *
     * @param text
     */
    public void setText(String text) {
        this.mTextView.setText(text);
    }

    /**
     * 设置字体颜色(默认为白色)
     *
     * @param color
     */
    private void setTextColor(int color) {
        if (color == 0) {
            this.mTextView.setTextColor(Color.WHITE);
        } else {
            this.mTextView.setTextColor(color);
        }
    }

}
