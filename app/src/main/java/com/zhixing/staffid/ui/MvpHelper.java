package com.zhixing.staffid.ui;

import com.zhixing.staffid.ui.presenter.MvpPresenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


class MvpHelper<P extends MvpPresenter> {

    Object target;

    public MvpHelper(Object target) {
        this.target = target;
    }

    /**
     * 利用反射机制，返回实现{@link P}的class，子类没有实现则为null
     */
    public Class<P> getPresenterClass() {
        Class<P> pClass = null;

        do {
            Type genType = target.getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)) {
                break;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if (params == null || params.length < 1) {
                break;
            }
            if (params[0] != null && params[0] instanceof Class) {
                pClass = (Class<P>) params[0];
            }
        } while (false);

        return pClass;
    }

}