package com.zhixing.staffid.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhixing.staffid.R;
import com.zhixing.staffid.adapter.MusicAdapter;
import com.zhixing.staffid.app.StaffIDApplication;
import com.zhixing.staffid.network.IMvpCallback;
import com.zhixing.staffid.network.bean.MusicList;
import com.zhixing.staffid.ui.BaseMvpActivity;
import com.zhixing.staffid.ui.presenter.MusicPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by zhaobiying
 * on 2018/7/26
 */
public class MusicListActivity extends BaseMvpActivity<MusicPresenter> {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_archor)
    ImageView ivArchor;
    @Bind(R.id.music_toolbar)
    Toolbar musicToolbar;
    @Bind(R.id.listview_music)
    ListView listviewMusic;
    private MusicAdapter adapter;
    private List<MusicList.DataBean> musiclist;
    private volatile Boolean isShow=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        showLoading();
        initData();
    }

    public void initData() {
        presenter.getMusicList(StaffIDApplication.channel, StaffIDApplication.version, StaffIDApplication.uuid, StaffIDApplication.platform, new IMvpCallback() {

            @Override
            public void onSuccess(List<?> data) {
                musiclist = (List<MusicList.DataBean>) data;
                initview();
                hideLoading();

            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onError(String errorMsg) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void initview() {
        adapter = new MusicAdapter(this, musiclist);
        listviewMusic.setAdapter(adapter);
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

    @OnClick({R.id.iv_back, R.id.tv_title, R.id.listview_music})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_title:
                if(isShow){
                    ivArchor.setImageDrawable(getResources().getDrawable(R.drawable.arrow_up_black));
                }
                else {
                    ivArchor.setImageDrawable(getResources().getDrawable(R.drawable.arrow_down_black));
                }
                break;
            case R.id.listview_music:
                break;
        }
    }
}
