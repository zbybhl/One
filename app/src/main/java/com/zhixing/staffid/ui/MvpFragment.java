package com.zhixing.staffid.ui;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.zhixing.staffid.ui.presenter.MvpPresenter;
import com.zhixing.staffid.util.AppLog;

import butterknife.ButterKnife;

/**
 * created by zhaobiying
 * on 2018/4/12
 */
public abstract class MvpFragment<P extends MvpPresenter> extends IBaseFragment implements IMvpView{
    protected BaseMvpActivity mvpActivity;
    protected P presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpActivity = (BaseMvpActivity) getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutRes = getFragmentLayout();
        return inflater.inflate(layoutRes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        onMvpInit();
        if (presenter != null) {
            //注册Fragment
            presenter.setView(this);
            presenter.registerEventBusListener(this);
        }
    }
    /**
     * 每个Fragment自己的布局
     */
    protected abstract int getFragmentLayout();

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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
