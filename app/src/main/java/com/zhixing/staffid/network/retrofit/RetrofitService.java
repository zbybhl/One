package com.zhixing.staffid.network.retrofit;

import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.ResponseBody;

import retrofit2.http.GET;
import rx.Observable;

/**
 *描述网络请求的接口
 */
public interface RetrofitService {

    @GET("onelist/idlist/?channel=wdj&version=4.2.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Observable<IdList> getIdList();
}
