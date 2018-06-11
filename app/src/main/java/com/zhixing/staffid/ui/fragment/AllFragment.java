package com.zhixing.staffid.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.zhixing.staffid.R;
import com.zhixing.staffid.ui.MvpFragment;
import com.zhixing.staffid.ui.presenter.AllPresenter;
import com.zhixing.staffid.util.GlideLoader;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.lightsky.infiniteindicator.IndicatorConfiguration;
import cn.lightsky.infiniteindicator.InfiniteIndicator;

import cn.lightsky.infiniteindicator.Page;

import static cn.lightsky.infiniteindicator.IndicatorConfiguration.LEFT;


/**
 * created by zhaobiying
 * on 2018/4/12
 */
public class AllFragment extends MvpFragment<AllPresenter> implements ViewPager.OnPageChangeListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.all_toolbar)
    Toolbar allToolbar;
    @Bind(R.id.infinite_anim_circle)
    InfiniteIndicator infiniteAnimCircle;

    private ArrayList<Page> pageViews;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_all;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animCircleIndicator();
    }
    @Override
    public void onResume() {
        super.onResume();
        infiniteAnimCircle.start();
    }

    private void initData() {
        pageViews = new ArrayList<>();
        pageViews.add(new Page("A", R.mipmap.a));
        pageViews.add(new Page("B", R.mipmap.b));
        pageViews.add(new Page("C", R.mipmap.c));
        pageViews.add(new Page("D", R.mipmap.d));

        //TODO 真实图片未获取，只是示例

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    private void animCircleIndicator() {

        IndicatorConfiguration configuration = new IndicatorConfiguration.Builder()
                .imageLoader(new GlideLoader())
                .isStopWhileTouch(true)
                .onPageChangeListener(this)
                .direction(LEFT)
                .position(IndicatorConfiguration.IndicatorPosition.Right_Top)
                .build();
        infiniteAnimCircle.init(configuration);
        infiniteAnimCircle.notifyDataChange(pageViews);
        infiniteAnimCircle.setCurrentItem(2);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        Toast.makeText(this,"page selected"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPause() {
        super.onPause();
        infiniteAnimCircle.stop();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

}
