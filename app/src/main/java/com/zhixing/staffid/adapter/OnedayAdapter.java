package com.zhixing.staffid.adapter;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhixing.staffid.R;
import com.zhixing.staffid.ui.pojo.DayList;
import com.zhixing.staffid.util.DateStyle;
import com.zhixing.staffid.util.DateUtil;

import java.util.List;

/**
 * created by zhaobiying
 * on 2018/4/27
 */
public class OnedayAdapter extends RecyclerView.Adapter<OnedayAdapter.ViewHolder>{
    private List<DayList> mData;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener = null;

    public OnedayAdapter(Context context,List<DayList> data) {
        this.mData = data;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_oneday,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide
                .with(mContext)
                .load( mData.get(position).getImg_url())
                .placeholder(R.mipmap.ic_preloading)
                .crossFade()
                .into(holder.mImageView);
//        String date = DateUtil.DateToString(mData.get(position).getDate(), DateStyle.YYYY_MM_DD_EN);
        holder.mTextView.setText(mData.get(position).getDate().split(" ")[0]);
        holder.mLinearLayout.setTag(position);
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    //注意这里使用getTag方法获取position
                    mOnItemClickListener.onItemClick(view,(int)view.getTag());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout mLinearLayout;
        public ImageView mImageView;
        public TextView mTextView;
        public ViewHolder(View v){
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_date);
            mLinearLayout = (LinearLayout) v.findViewById(R.id.llyt_oneday);
            mImageView=(ImageView) v.findViewById(R.id.iv_theme);
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
}
