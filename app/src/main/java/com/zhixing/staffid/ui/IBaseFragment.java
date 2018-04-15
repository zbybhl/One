package com.zhixing.staffid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * created by zhaobiying
 * on 2018/4/12
 */
public abstract class IBaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutRes = getFragmentLayout();
        return inflater.inflate(layoutRes, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    protected ActionBar getSupportActionBar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }

    protected void setTitle(int resId) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(resId);
        }
    }

    protected void setTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
    /**
     * 每个Fragment自己的布局
     */
    protected abstract int getFragmentLayout();
}
