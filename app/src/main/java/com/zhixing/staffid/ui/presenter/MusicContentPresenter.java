package com.zhixing.staffid.ui.presenter;

import com.zhixing.staffid.network.bean.MusicContent;
import com.zhixing.staffid.ui.activity.MusicContentActivity;
import com.zhixing.staffid.ui.activity.MusicListActivity;
import com.zhixing.staffid.util.AppLog;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * created by zhaobiying
 * on 2018/7/30
 */
public class MusicContentPresenter extends MvpPresenter<MusicContentActivity> {
//    private CompositeSubscription compositeSubscription;
    private MusicContent content;

    @Override
    public void setView(MusicContentActivity view) {
        super.setView(view);
//        compositeSubscription = new CompositeSubscription();
    }
    public void getMusicContent(String itemId,String channel, String version, String uuid, String platform)  {
        dataManager.getMusicContent(itemId,channel, version, uuid, platform)//将请求封装成的observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicContent>() {
                    @Override
                    public void onCompleted() {
                        if (content != null){
                            getView().showdata(content.getData());
                        }
                        AppLog.d("Completed!");
                    }

                    @Override
                    public void onError(Throwable e) {

                        AppLog.d("Error!");
                        AppLog.d("******************");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(MusicContent musicContent) {
                        content =musicContent;
                        AppLog.d("Item: " +musicContent);
                    }
                }

        );
    }
}
