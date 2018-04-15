package com.zhixing.staffid.network;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.zhixing.staffid.network.retrofit.RetrofitService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Retrofit初始化
 */
public class RetrofitHelper {

    private Context mContext;
    OkHttpClient client = OkHttpUtil.newOkHttpClient();
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private volatile static RetrofitHelper instance = null;

    private Retrofit mRetrofit = null;

    private RetrofitHelper(Context context){
        this.mContext = context;
        init();
    }

    public static RetrofitHelper getInstance(Context context){
        if (instance == null){
            synchronized (RetrofitHelper.class){
                if (instance == null){
                    instance = new RetrofitHelper(context);
                }
            }
        }
        return instance;
    }

    /**
     * 创建retrofit对象
     */
    private void init(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://v3.wufazhuce.com:8000/api/")   //设置基本url
                .client(client)
                .addConverterFactory(factory) //设置GSON解析
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    public RetrofitService getService(){
        return mRetrofit.create(RetrofitService.class); //创建网络请求接口的实例
    }

}
