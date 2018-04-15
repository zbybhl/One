package com.zhixing.staffid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhixing.staffid.ui.activity.MvpActivity;
import com.zhixing.staffid.ui.IBaseFragment;


/**
 * created by zhaobiying
 * on 2018/4/12
 */
public abstract class MvpFragment extends IBaseFragment {
    protected MvpActivity mvpActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpActivity = (MvpActivity) getActivity();

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onDestroy() {

        mvpActivity=null;
        super.onDestroy();
    }
}
