package com.zhixing.staffid.ui.activity;

/**
 * Created by zhaobiying
 * 2018/4/2.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhixing.staffid.ui.IMvpView;
import com.zhixing.staffid.ui.presenter.MvpPresenter;
import com.zhixing.staffid.util.WidgetUtil;

public abstract class MvpActivity extends AppCompatActivity implements IMvpView {
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = WidgetUtil.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void  showdata(String string) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
