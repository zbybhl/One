package com.zhixing.staffid.ui.presenter;

import android.content.Context;

import com.zhixing.staffid.network.manager.DataManager;
import com.zhixing.staffid.ui.IMvpView;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.EventBusException;

/**
 * Created by zhaobiying
 * 2018/4/1
 */

public class MvpPresenter<V extends IMvpView> implements IMvpPresenter<V> {
    protected DataManager dataManager;
    protected V view;
    protected Context context;
    private EventBus eventBus;

    @Override
    public V getView() {
        return view;
    }


    @Override
    public void setView(V view) {
        this.view = view;
        this.context = view.getContext();
        dataManager = new DataManager(this.context);
    }

    /*
    所有子类通过此方法获取EventBus，这样子类可以通过复写此方法获取自己的EventBus
     */
    public EventBus getEventBus() {
        if (eventBus == null) {
            eventBus = EventBus.getDefault();
        }
        return eventBus;
    }

    public void registerEventBusListener(Object object) {
        if (getEventBus() != null) {
            try {
                getEventBus().register(object);
            } catch (EventBusException eventBusException) {
                // 如果object没有任何onEvent等订阅，会导致EventBusException，此处try-catch防止崩溃
            }
        }
    }

    public void unregisterEventBusListener(Object object) {
        if (getEventBus() != null) {
            getEventBus().unregister(object);
        }
    }

    public void onEvent(Object object) {
    }


    @Override
    public void destroy() {
        unregisterEventBusListener(this);
        this.view = null;
        this.context = null;
        this.eventBus = null;
    }

}
