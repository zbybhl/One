package com.zhixing.staffid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhixing.staffid.R;
import com.zhixing.staffid.network.bean.MusicContent;
import com.zhixing.staffid.service.FloatWindow;
import com.zhixing.staffid.service.MusicFloatService;
import com.zhixing.staffid.ui.BaseMvpActivity;
import com.zhixing.staffid.ui.fragment.OneFragment;
import com.zhixing.staffid.ui.presenter.MusicContentPresenter;
import com.zhixing.staffid.util.ScreenUtil;
import com.zhixing.staffid.widget.floatwindow.FloatLayout;
import com.zhixing.staffid.widget.floatwindow.FloatStateListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by zhaobiying
 * on 2018/7/30
 * 单独音乐的activity
 */
public class MusicContentActivity extends BaseMvpActivity<MusicContentPresenter> {
    private static final String TAG = "MusicContentActivity";

    @Bind(R.id.iv_background)
    ImageView ivBackground;
    @Bind(R.id.iv_one_music)
    ImageView ivOneMusic;
    @Bind(R.id.iv_one_button)
    ImageView ivOneButton;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_song_info)
    TextView tvSongInfo;
    private String itemId;
    private MusicContent.Data musicContent;
    private volatile  Boolean isplay=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_news);
        ButterKnife.bind(this);
        itemId = getIntent().getStringExtra("item_id");
        presenter.getMusicContent(itemId, OneFragment.channel, OneFragment.version, OneFragment.uuid, OneFragment.platform);
    }

    public void showdata(MusicContent.Data data) {
        this.musicContent = data;
        initview();
    }
    @OnClick(R.id.iv_one_button)
    public synchronized void onViewClicked(View view) {
        if(!isplay){
            ivOneButton.setImageResource(R.drawable.pause_circle_24);
            isplay=true;
            FloatLayout mFloatLayout = new FloatLayout(getContext());
//
            int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();
            int screenHeight  = getWindowManager().getDefaultDisplay().getHeight();

            FloatWindow.with(getApplicationContext())
                    .setmView(mFloatLayout)
                    .setGravity(Gravity.RIGHT | Gravity.TOP)
                    .setxOffset(ScreenUtil.dip2px(this,10))
                    .setyOffset(ScreenUtil.dip2px(this,0))
                    .setmViewStateListener(mViewStateListener)
                    .build();

            Intent intent = new Intent(getContext(), MusicFloatService.class);
            startService(intent);
        }
        else {
            ivOneButton.setImageResource(R.drawable.play_circle_24);
            isplay=false;
        }
    }
    public void initview() {
        Glide
                .with(getContext())
                .load(musicContent.getCover())
                .placeholder(R.drawable.ic_music)
                .crossFade()
                .into(ivOneMusic);
        tvTitle.setText(musicContent.getStory_title());
        tvSongInfo.setText(musicContent.getTitle()+"|"+musicContent.getAuthor().getUser_name());
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.iv_one_music)
    public void onViewClicked() {

    }

    private FloatStateListener mViewStateListener = new FloatStateListener() {

        @Override
        public void onShow() {
            Log.d(TAG, "onShow");
        }

        @Override
        public void onHide() {
            Log.d(TAG, "onHide");
        }

        @Override
        public void onDismiss() {
            Log.d(TAG, "onDismiss");
        }

        @Override
        public void onMoveAnimStart() {
            Log.d(TAG, "onMoveAnimStart");
        }

        @Override
        public void onMoveAnimEnd() {
            Log.d(TAG, "onMoveAnimEnd");
        }

        @Override
        public void onBackToDesktop() {
            Log.d(TAG, "onBackToDesktop");
        }
    };
}
