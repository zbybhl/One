package com.zhixing.staffid.ui.presenter;

import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.manager.DataManager;
import com.zhixing.staffid.ui.BaseMvpActivity;
import com.zhixing.staffid.util.AppLog;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainPresenter extends MvpPresenter<BaseMvpActivity> {

    private DataManager dataManager;
    private CompositeSubscription compositeSubscription;
    private IdList idListBody;


    @Override
    public void setView(BaseMvpActivity view) {
        super.setView(view);
        dataManager = new DataManager(view);
        compositeSubscription = new CompositeSubscription();
    }


    public void getIdList(String channel, String version, String uuid, String paltform){
        compositeSubscription.add(dataManager.getIdList(channel, version, uuid, paltform)//将请求封装成的observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IdList>() {
                    @Override
                    public void onCompleted() {
                        if (idListBody != null){
                            getView().showdata(idListBody);
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



    @Override
    public void destroy(){
        if (compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe();
        }
    }

}
