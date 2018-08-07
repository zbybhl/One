package com.zhixing.staffid.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.FrameLayout;

import com.zhixing.staffid.R;
import com.zhixing.staffid.ui.BaseMvpActivity;
import com.zhixing.staffid.ui.fragment.AllFragment;
import com.zhixing.staffid.ui.fragment.MeFragment;
import com.zhixing.staffid.ui.fragment.OneFragment;
import com.zhixing.staffid.ui.presenter.MainPresenter;
import com.zhixing.staffid.util.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseMvpActivity<MainPresenter> {

    @Bind(R.id.home_container)
    FrameLayout homeContainer;
    @Bind(R.id.bottom_tab_layout)
    BottomNavigationView bottomTabLayout;


    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private List<Fragment> fragments;
    private Fragment mOneFragment;
    private Fragment mAllFragment;
    private Fragment mMeFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        updateFragment();
    }

    private void initView() {

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragments = new ArrayList<>();
        mOneFragment = new OneFragment();
        mAllFragment = new AllFragment();
        mMeFragment = new MeFragment();
        fragments.add(mOneFragment);
        fragments.add(mAllFragment);
        fragments.add(mMeFragment);

        transaction.add(R.id.home_container, mOneFragment);
        transaction.add(R.id.home_container, mAllFragment);
        transaction.add(R.id.home_container, mMeFragment);

        BottomNavigationViewHelper.disableShiftMode(bottomTabLayout);
        bottomTabLayout.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onTabItemSelected(item.getItemId());
                return true;
            }
        });
    }

    private void onTabItemSelected(int id) {
        switch (id) {
            case R.id.item_one:
                switchFragment(0);
                break;
            case R.id.item_all:
                switchFragment(1);
                break;
            case R.id.item_me:
                switchFragment(2);
                break;
        }
    }

    void updateFragment() {
        transaction.show(mOneFragment).hide(mAllFragment).hide(mMeFragment);
        transaction.commit();
        currentFragment=mOneFragment;
        if(currentFragment instanceof OneFragment) {
            ((OneFragment) currentFragment).hideFooterCallBack(new OneFragment.HideFooterCallBack() {
                @Override
                public void hide() {
                    bottomTabLayout.animate().translationY(bottomTabLayout.getHeight());

                }

                @Override
                public void show() {
                    bottomTabLayout.animate().translationY(0);

                }
            });
//            View view=currentFragment.getView();
//            PullToRefreshScrollView pullToRefreshScrollView= (PullToRefreshScrollView)view.findViewById(R.id.main_ptfv);
        }
    }

    private void switchFragment(int index) {
        transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        for (int i = 0; i < fragments.size(); i++) {
            if (index == i) {
                transaction.show(fragments.get(index));

            } else {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();

    }


    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {


    }

    @Override
    public void showdata(Object object) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


}
