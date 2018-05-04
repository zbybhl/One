package com.zhixing.staffid.ui.fragment;

import com.zhixing.staffid.R;
import com.zhixing.staffid.ui.MvpFragment;
import com.zhixing.staffid.ui.presenter.AllPresenter;


/**
 * created by zhaobiying
 * on 2018/4/12
 */
public class AllFragment extends MvpFragment<AllPresenter> {

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_all;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
