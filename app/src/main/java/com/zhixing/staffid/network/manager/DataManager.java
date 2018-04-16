package com.zhixing.staffid.network.manager;

import android.content.Context;

import com.zhixing.staffid.network.RetrofitHelper;
import com.zhixing.staffid.network.bean.EssayComment;
import com.zhixing.staffid.network.bean.EssayContent;
import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.MovieComment;
import com.zhixing.staffid.network.bean.MovieContent;
import com.zhixing.staffid.network.bean.MoviePicture;
import com.zhixing.staffid.network.bean.MusicComment;
import com.zhixing.staffid.network.bean.MusicContent;
import com.zhixing.staffid.network.bean.OneList;
import com.zhixing.staffid.network.bean.OneWeekChineseComment;
import com.zhixing.staffid.network.bean.OneWeekChineseContent;
import com.zhixing.staffid.network.retrofit.RetrofitService;

import rx.Observable;

public class DataManager {

    private RetrofitService mRetrofitService;

    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance(context).getService();
    }

    public Observable<IdList> getIdList(String channel, String version, String uuid, String paltform){
      return mRetrofitService.getIdList(channel, version, uuid, paltform);
    }

    public Observable<OneList> getOneList(String data, String channel, String version, String uuid, String paltform){
        return mRetrofitService.getOneList(data, channel, version, uuid, paltform);
    }

    public Observable<OneWeekChineseContent> getOneWeekChineseContent(String item_id, String channel, String source, String source_id, String version, String uuid, String paltform){
        return mRetrofitService.getOneWeekChineseContent(item_id, channel, source, source_id, version, uuid, paltform);
    }

    public Observable<OneWeekChineseComment> getOneWeekChineseComment(String item_id, String channel, String version, String uuid, String paltform){
        return mRetrofitService.getOneWeekChineseComment(item_id, channel, version, uuid, paltform);
    }

    public Observable<EssayContent> getEssayContent(String item_id, String channel, String source, String source_id, String version, String uuid, String paltform){
        return mRetrofitService.getEssayContent(item_id, channel, source, source_id, version, uuid, paltform);
    }

    public Observable<EssayComment> getEssayComment(String item_id, String channel, String version, String uuid, String paltform){
        return mRetrofitService.getEssayComment(item_id, channel, version, uuid, paltform);
    }

    public Observable<MusicContent> getMusicContent(String item_id, String channel, String version, String uuid, String paltform){
        return mRetrofitService.getMusicContent(item_id, channel, version, uuid, paltform);
    }

    public Observable<MusicComment> getMusicComment(String item_id, String channel, String version, String uuid, String paltform){
        return mRetrofitService.getMusicComment(item_id, channel, version, uuid, paltform);
    }

    public Observable<MovieContent> getMovieContent(String item_id, String channel, String version, String uuid, String paltform){
        return mRetrofitService.getMovieContent(item_id, channel, version, uuid, paltform);
    }

    public Observable<MoviePicture> getMoviePicture(String item_id, String channel, String source, String source_id, String version, String uuid, String paltform){
        return mRetrofitService.getMoviePicture(item_id, channel, source, source_id, version, uuid, paltform);
    }

    public Observable<MovieComment> getMovieComment(String item_id, String channel, String version, String uuid, String paltform){
        return mRetrofitService.getMovieComment(item_id, channel, version, uuid, paltform);
    }
}
