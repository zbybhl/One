package com.zhixing.staffid.ui;

/**
 * Created by zhaobiying
 * 2018/4/2.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.zhixing.staffid.ui.presenter.MvpPresenter;
import com.zhixing.staffid.util.AppLog;
import com.zhixing.staffid.util.WidgetUtil;

import butterknife.ButterKnife;

public abstract class BaseMvpActivity<P extends MvpPresenter> extends AppCompatActivity implements IMvpView{
    protected P presenter;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onMvpInit();

        if (presenter != null) {
            //注册Activity
            presenter.setView(this);
            presenter.registerEventBusListener(this);
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void  showdata(Object object) {

    }

    protected void onMvpInit() {
        MvpHelper<P> mvpHelper = new MvpHelper<>(this);
        Class<P> pClass = mvpHelper.getPresenterClass();
        if (pClass != null) {
            try {
                presenter = pClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AppLog.d("presenter = " + presenter);
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
    protected void onDestroy() {
        if (presenter != null) {
            //反注册Activity
            presenter.unregisterEventBusListener(this);
            presenter.destroy();
        }
        mProgressDialog=null;
        presenter=null;
        super.onDestroy();

    }
}
