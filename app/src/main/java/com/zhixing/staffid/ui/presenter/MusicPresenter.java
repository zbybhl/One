package com.zhixing.staffid.ui.presenter;

import com.zhixing.staffid.network.IMvpCallback;
import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.MusicList;
import com.zhixing.staffid.ui.BaseMvpActivity;
import com.zhixing.staffid.ui.activity.MusicListActivity;
import com.zhixing.staffid.util.AppLog;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * created by zhaobiying
 * on 2018/7/26
 */
public class MusicPresenter  extends MvpPresenter<MusicListActivity> {
    private CompositeSubscription compositeSubscription;
    private MusicList musiclist;
    @Override
    public void setView(MusicListActivity view) {
        super.setView(view);
        compositeSubscription = new CompositeSubscription();
    }

    public void getMusicList(String channel, String version, String uuid, String paltform , final  IMvpCallback callback)  {
        compositeSubscription.add(dataManager.getMusicList(channel, version, uuid, paltform)//将请求封装成的observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicList>() {
                    @Override
                    public void onCompleted() {
                        if (musiclist != null){
                            getView().showdata( musiclist);
                        }
                        AppLog.d("Completed!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        AppLog.d("Error!");
                    }

                    @Override
                    public void onNext(MusicList musicList) {
                        callback.onSuccess(musicList.getData());
                        musiclist =musicList;
                        AppLog.d("Item: " +musicList);
                    }
                })

        );
    }
}
