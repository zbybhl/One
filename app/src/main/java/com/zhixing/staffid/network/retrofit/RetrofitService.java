package com.zhixing.staffid.network.retrofit;

import com.zhixing.staffid.network.bean.EssayComment;
import com.zhixing.staffid.network.bean.EssayContent;
import com.zhixing.staffid.network.bean.IdList;
import com.zhixing.staffid.network.bean.MovieComment;
import com.zhixing.staffid.network.bean.MovieContent;
import com.zhixing.staffid.network.bean.MoviePicture;
import com.zhixing.staffid.network.bean.MusicComment;
import com.zhixing.staffid.network.bean.MusicContent;
import com.zhixing.staffid.network.bean.MusicList;
import com.zhixing.staffid.network.bean.OneList;
import com.zhixing.staffid.network.bean.OneWeekChineseComment;
import com.zhixing.staffid.network.bean.OneWeekChineseContent;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 *描述网络请求的接口
 */
public interface RetrofitService {

    @GET("onelist/idlist")
    Observable<IdList> getIdList(@Query("channel") String channel,
                                 @Query("version") String version,
                                 @Query("uuid") String uuid,
                                 @Query("platform") String platform);

    @GET("onelist/{data}/0")
    Observable<OneList> getOneList(@Path("data") String data,
                                   @Query("channel") String channel,
                                   @Query("version") String version,
                                   @Query("uuid") String uuid,
                                   @Query("platform") String platform);

    @GET("essay/{item_id}")
    Observable<OneWeekChineseContent> getOneWeekChineseContent(@Path("item_id") String item_id,
                                                               @Query("channel") String channel,
                                                               @Query("source") String source,
                                                               @Query("source_id") String source_id,
                                                               @Query("version") String version,
                                                               @Query("uuid") String uuid,
                                                               @Query("platform") String platform);

    @GET("comment/praiseandtime/essay/{item_id}/0")
    Observable<OneWeekChineseComment> getOneWeekChineseComment(@Path("item_id") String item_id,
                                                               @Query("channel") String channel,
                                                               @Query("version") String version,
                                                               @Query("uuid") String uuid,
                                                               @Query("platform") String platform);

    @GET("essay/{item_id}")
    Observable<EssayContent> getEssayContent(@Path("item_id") String item_id,
                                             @Query("channel") String channel,
                                             @Query("source") String source,
                                             @Query("source_id") String source_id,
                                             @Query("version") String version,
                                             @Query("uuid") String uuid,
                                             @Query("platform") String platform);

    @GET("comment/praiseandtime/essay/{item_id}/0")
    Observable<EssayComment> getEssayComment(@Path("item_id") String item_id,
                                             @Query("channel") String channel,
                                             @Query("version") String version,
                                             @Query("uuid") String uuid,
                                             @Query("platform") String platform);
    @GET("channel/music/more/0")
    Observable<MusicList> getMusicList(
                                             @Query("channel") String channel,
                                             @Query("version") String version,
                                             @Query("uuid") String uuid,
                                             @Query("platform") String platform);
    @GET("music/detail/{item_id}")
    Observable<MusicContent> getMusicContent(@Path("item_id") String item_id,
                                             @Query("channel") String channel,
                                             @Query("version") String version,
                                             @Query("uuid") String uuid,
                                             @Query("platform") String platform);

    @GET("comment/praiseandtime/music/{item_id}/0")
    Observable<MusicComment> getMusicComment(@Path("item_id") String item_id,
                                               @Query("channel") String channel,
                                               @Query("version") String version,
                                               @Query("uuid") String uuid,
                                               @Query("platform") String platform);

    @GET("movie/{item_id}/story/1/0")
    Observable<MovieContent> getMovieContent(@Path("item_id") String item_id,
                                             @Query("channel") String channel,
                                             @Query("version") String version,
                                             @Query("uuid") String uuid,
                                             @Query("platform") String platform);

    @GET("movie/detail/{item_id}")
    Observable<MoviePicture> getMoviePicture(@Path("item_id") String item_id,
                                             @Query("channel") String channel,
                                             @Query("source") String source,
                                             @Query("source_id") String source_id,
                                             @Query("version") String version,
                                             @Query("uuid") String uuid,
                                             @Query("platform") String platform);

    @GET("comment/praiseandtime/movie/{item_id}/0")
    Observable<MovieComment> getMovieComment(@Path("item_id") String item_id,
                                             @Query("channel") String channel,
                                             @Query("version") String version,
                                             @Query("uuid") String uuid,
                                             @Query("platform") String platform);


}
