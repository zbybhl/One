package com.zhixing.staffid.ui.presenter;

import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.ResponseBody;
import com.zhixing.staffid.network.callback.ResponseCallback;
import com.zhixing.staffid.network.manager.DataManager;
import com.zhixing.staffid.ui.activity.MvpActivity;
import com.zhixing.staffid.util.AppLog;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ResponsePresenter extends MvpPresenter<MvpActivity> {

    private DataManager dataManager;
    private CompositeSubscription compositeSubscription;
    private ResponseBody mResponseBody;
    private ResponseCallback responseCallback;

    public ResponsePresenter(MvpActivity view){
        super(view);
        dataManager = new DataManager(view);
        compositeSubscription = new CompositeSubscription();
    }

    public void attachCallback(ResponseCallback callback) {
        this.responseCallback = callback;
    }




    public void getIdList(){
        compositeSubscription.add(dataManager.getIdList()//将请求封装成的observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IdList>() {
                    @Override
                    public void onCompleted() {
                        AppLog.d("Completed!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        AppLog.d("Error!");
                    }

                    @Override
                    public void onNext(IdList idList) {
                        AppLog.d("Item: " +idList);
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
