package com.zhixing.staffid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhixing.staffid.R;
import com.zhixing.staffid.network.bean.MusicList;

import java.util.List;

/**
 * created by zhaobiying
 * on 2018/7/26
 */
public class MusicAdapter extends BaseAdapter {
    private List<MusicList.DataBean> musiclist;
    private LayoutInflater mInflater;
    private Context context;
    public MusicAdapter(Context context, List<MusicList.DataBean> musiclist) {
        this.musiclist = musiclist;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return musiclist.size();
    }

    @Override
    public Object getItem(int i) {
        return musiclist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.item_music,null);
            holder.musicItem = (LinearLayout)view.findViewById(R.id.llyt_music);
            holder.musicImage = (ImageView)view.findViewById(R.id.iv_thumb_image);
            holder.musicTitle = (TextView)view.findViewById(R.id.tv_title);
            holder.musicSubTitle=(TextView)view.findViewById(R.id.tv_sub_title);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Glide
                .with(context)
                .load(musiclist.get(i).getImg_url())
                .placeholder(R.mipmap.ic_preloading)
                .crossFade()
                .into(holder.musicImage);
        holder.musicTitle.setText(musiclist.get(i).getTitle());
        holder.musicSubTitle.setText(musiclist.get(i).getMusic_name()+"|"+musiclist.get(i).getAudio_author());
        return view;
    }
    static class ViewHolder {
        public LinearLayout musicItem;
        public ImageView musicImage;
        public TextView musicTitle;
        public TextView musicSubTitle;
    }
}
