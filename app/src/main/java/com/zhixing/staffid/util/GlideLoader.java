package com.zhixing.staffid.util;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhixing.staffid.R;

import java.io.File;

import cn.lightsky.infiniteindicator.ImageLoader;


/**
 * Created by lightsky on 16/1/31.
 */
public class GlideLoader implements ImageLoader {

    public void initLoader(Context context) {

    }

    @Override
    public void load(Context context, ImageView targetView, Object res) {
        if (res instanceof String){
            Glide.with(context)
                    .load((String) res)
                    .centerCrop()
                    .placeholder(R.mipmap.a)
                    .crossFade()
                    .into(targetView);
        } else if (res instanceof File) {
            Glide.with(context)
                    .load((File) res)
                    .centerCrop()
                    .placeholder(R.mipmap.a)
                    .crossFade()
                    .into(targetView);
        } else if (res instanceof Integer) {
            Glide.with(context)
                    .load((Integer) res)
                    .centerCrop()
                    .placeholder(R.mipmap.a)
                    .crossFade()
                    .into(targetView);
        }

    }
}
