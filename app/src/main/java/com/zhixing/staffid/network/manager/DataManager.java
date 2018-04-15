package com.zhixing.staffid.network.manager;

import android.content.Context;

import com.zhixing.staffid.network.RetrofitHelper;
import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.retrofit.RetrofitService;
import com.zhixing.staffid.network.bean.ResponseBody;

import rx.Observable;

public class DataManager {

    private RetrofitService mRetrofitService;

    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getService();
    }

    public Observable<IdList> getIdList(){
      return mRetrofitService.getIdList();
    }
}
