package com.zhixing.staffid.ui.presenter;

import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.OneList;
import com.zhixing.staffid.network.callback.IdListCallback;
import com.zhixing.staffid.network.callback.OneListCallback;
import com.zhixing.staffid.network.manager.DataManager;
import com.zhixing.staffid.ui.BaseMvpActivity;
import com.zhixing.staffid.util.AppLog;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class OnePresenter extends MvpPresenter<BaseMvpActivity> {

    private DataManager dataManager;
    private CompositeSubscription compositeSubscription;
    private IdList idListBody;
    private IdListCallback idListCallback;
    private OneList oneListBody;
    private OneListCallback oneListCallback;

    public OnePresenter(BaseMvpActivity view){
        super(view);
        dataManager = new DataManager(view);
        compositeSubscription = new CompositeSubscription();
    }

    public void attachIdListCallback(IdListCallback callback) {
        this.idListCallback = callback;
    }

    public void attachOneListCallback(OneListCallback callback) {
        this.oneListCallback = callback;
    }

    public void getIdList(String channel, String version, String uuid, String platform){
        compositeSubscription.add(dataManager.getIdList(channel, version, uuid, platform)//将请求封装成的observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IdList>() {
                    @Override
                    public void onCompleted() {
                        if (idListBody != null){
                            idListCallback.onSuccess(idListBody);
                        }
                        AppLog.d("Completed!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        AppLog.d("Error!");
                    }

                    @Override
                    public void onNext(IdList idList) {
                        idListBody = idList;
                        AppLog.d("Item: " +idList);
                    }
                })

        );
    }

    public void getOneList(String data, String channel, String version, String uuid, String platform){
        compositeSubscription.add(dataManager.getOneList(data, channel, version, uuid, platform)//将请求封装成的observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OneList>() {
                    @Override
                    public void onCompleted() {
                        if (oneListBody != null){
                            oneListCallback.onSuccess(oneListBody);
                        }
                        AppLog.d("Completed!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        AppLog.d("Error!");
                    }

                    @Override
                    public void onNext(OneList oneList) {
                        oneListBody = oneList;
                        AppLog.d("Item: " +oneList);
                    }
                })

        );
    }

    @Override
    public void destroy(){
        if (compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe();
        }
    }
}
