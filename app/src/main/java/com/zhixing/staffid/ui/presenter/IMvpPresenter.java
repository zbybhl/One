package com.zhixing.staffid.ui.presenter;

import android.os.Bundle;

import com.zhixing.staffid.ui.IBaseView;

/**
 * Created by zhaobiying
 * 2018/4/1
 */

public interface IMvpPresenter<T extends IBaseView> {

      T getView();

      void setView(T view);

      void destroy();


}
