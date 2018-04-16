package com.zhixing.staffid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhixing.staffid.ui.BaseMvpActivity;
import com.zhixing.staffid.ui.IBaseFragment;
import com.zhixing.staffid.ui.IMvpView;
import com.zhixing.staffid.ui.presenter.MvpPresenter;


/**
 * created by zhaobiying
 * on 2018/4/12
 */
public abstract class MvpFragment<P extends MvpPresenter> extends IBaseFragment {
    protected BaseMvpActivity mvpActivity;
    protected P presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpActivity = (BaseMvpActivity) getActivity();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter != null) {
            //注册Fragment
            presenter.setView(mvpActivity);
            presenter.registerEventBusListener(this);
        }
    }


    @Override
    public void onDestroy() {
        if (presenter != null) {
            //反注册Fragment
            presenter.unregisterEventBusListener(this);
            presenter.destroy();
        }
        mvpActivity=null;
        presenter = null;
        super.onDestroy();
    }
}
