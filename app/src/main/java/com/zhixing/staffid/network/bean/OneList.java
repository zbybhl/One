package com.zhixing.staffid.network.bean;

import java.util.Date;
import java.util.List;

public class OneList {

    private int res;
    private Data data;

    public void setRes(int res){
        this.res = res;
    }
    public int getRes(){
        return this.res;
    }
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }

    public class Data
    {
        private String id;

        private Weather weather;

        private Date date;

        private List<Content_list> content_list;

        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return this.id;
        }
        public void setWeather(Weather weather){
            this.weather = weather;
        }
        public Weather getWeather(){
            return this.weather;
        }
        public void setDate(Date date){
            this.date = date;
        }
        public Date getDate(){
            return this.date;
        }
        public void setContent_list(List<Content_list> content_list){
            this.content_list = content_list;
        }
        public List<Content_list> getContent_list(){
            return this.content_list;
        }

        public class Weather
        {
            private String city_name;

            private Date date;

            private String temperature;

            private String humidity;

            private String climate;

            private String wind_direction;

            private String hurricane;

            private Icons icons;

            public void setCity_name(String city_name){
                this.city_name = city_name;
            }
            public String getCity_name(){
                return this.city_name;
            }
            public void setDate(Date date){
                this.date = date;
            }
            public Date getDate(){
                return this.date;
            }
            public void setTemperature(String temperature){
                this.temperature = temperature;
            }
            public String getTemperature(){
                return this.temperature;
            }
            public void setHumidity(String humidity){
                this.humidity = humidity;
            }
            public String getHumidity(){
                return this.humidity;
            }
            public void setClimate(String climate){
                this.climate = climate;
            }
            public String getClimate(){
                return this.climate;
            }
            public void setWind_direction(String wind_direction){
                this.wind_direction = wind_direction;
            }
            public String getWind_direction(){
                return this.wind_direction;
            }
            public void setHurricane(String hurricane){
                this.hurricane = hurricane;
            }
            public String getHurricane(){
                return this.hurricane;
            }
            public void setIcons(Icons icons){
                this.icons = icons;
            }
            public Icons getIcons(){
                return this.icons;
            }

            public class Icons
            {
                private String day;

                private String night;

                public void setDay(String day){
                    this.day = day;
                }
                public String getDay(){
                    return this.day;
                }
                public void setNight(String night){
                    this.night = night;
                }
                public String getNight(){
                    return this.night;
                }
            }
        }

        public class Content_list
        {
            private String id;

            private String category;

            private int display_category;

            private String item_id;

            private String title;

            private String forward;

            private String img_url;

            private int like_count;

            private Date post_date;

            private Date last_update_date;

            private Author author;

            private String video_url;

            private String audio_url;

            private int audio_platform;

            private String start_video;

            private String volume;

            private String pic_info;

            private String words_info;

            private String subtitle;

            private int number;

            private int serial_id;

            private List<String> serial_list;

            private int movie_story_id;

            private int ad_id;

            private int ad_type;

            private String ad_pvurl;

            private String ad_linkurl;

            private String ad_makettime;

            private String ad_closetime;

            private String ad_share_cnt;

            private String ad_pvurl_vendor;

            private String content_id;

            private String content_type;

            private String content_bgcolor;

            private String share_url;

            private Share_info share_info;

            private String orientation;

            public void setId(String id){
                this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setCategory(String category){
                this.category = category;
            }
            public String getCategory(){
                return this.category;
            }
            public void setDisplay_category(int display_category){
                this.display_category = display_category;
            }
            public int getDisplay_category(){
                return this.display_category;
            }
            public void setItem_id(String item_id){
                this.item_id = item_id;
            }
            public String getItem_id(){
                return this.item_id;
            }
            public void setTitle(String title){
                this.title = title;
            }
            public String getTitle(){
                return this.title;
            }
            public void setForward(String forward){
                this.forward = forward;
            }
            public String getForward(){
                return this.forward;
            }
            public void setImg_url(String img_url){
                this.img_url = img_url;
            }
            public String getImg_url(){
                return this.img_url;
            }
            public void setLike_count(int like_count){
                this.like_count = like_count;
            }
            public int getLike_count(){
                return this.like_count;
            }
            public void setPost_date(Date post_date){
                this.post_date = post_date;
            }
            public Date getPost_date(){
                return this.post_date;
            }
            public void setLast_update_date(Date last_update_date){
                this.last_update_date = last_update_date;
            }
            public Date getLast_update_date(){
                return this.last_update_date;
            }
            public void setAuthor(Author author){
                this.author = author;
            }
            public Author getAuthor(){
                return this.author;
            }
            public void setVideo_url(String video_url){
                this.video_url = video_url;
            }
            public String getVideo_url(){
                return this.video_url;
            }
            public void setAudio_url(String audio_url){
                this.audio_url = audio_url;
            }
            public String getAudio_url(){
                return this.audio_url;
            }
            public void setAudio_platform(int audio_platform){
                this.audio_platform = audio_platform;
            }
            public int getAudio_platform(){
                return this.audio_platform;
            }
            public void setStart_video(String start_video){
                this.start_video = start_video;
            }
            public String getStart_video(){
                return this.start_video;
            }
            public void setVolume(String volume){
                this.volume = volume;
            }
            public String getVolume(){
                return this.volume;
            }
            public void setPic_info(String pic_info){
                this.pic_info = pic_info;
            }
            public String getPic_info(){
                return this.pic_info;
            }
            public void setWords_info(String words_info){
                this.words_info = words_info;
            }
            public String getWords_info(){
                return this.words_info;
            }
            public void setSubtitle(String subtitle){
                this.subtitle = subtitle;
            }
            public String getSubtitle(){
                return this.subtitle;
            }
            public void setNumber(int number){
                this.number = number;
            }
            public int getNumber(){
                return this.number;
            }
            public void setSerial_id(int serial_id){
                this.serial_id = serial_id;
            }
            public int getSerial_id(){
                return this.serial_id;
            }
            public void setSerial_list(List<String> serial_list){
                this.serial_list = serial_list;
            }
            public List<String> getSerial_list(){
                return this.serial_list;
            }
            public void setMovie_story_id(int movie_story_id){
                this.movie_story_id = movie_story_id;
            }
            public int getMovie_story_id(){
                return this.movie_story_id;
            }
            public void setAd_id(int ad_id){
                this.ad_id = ad_id;
            }
            public int getAd_id(){
                return this.ad_id;
            }
            public void setAd_type(int ad_type){
                this.ad_type = ad_type;
            }
            public int getAd_type(){
                return this.ad_type;
            }
            public void setAd_pvurl(String ad_pvurl){
                this.ad_pvurl = ad_pvurl;
            }
            public String getAd_pvurl(){
                return this.ad_pvurl;
            }
            public void setAd_linkurl(String ad_linkurl){
                this.ad_linkurl = ad_linkurl;
            }
            public String getAd_linkurl(){
                return this.ad_linkurl;
            }
            public void setAd_makettime(String ad_makettime){
                this.ad_makettime = ad_makettime;
            }
            public String getAd_makettime(){
                return this.ad_makettime;
            }
            public void setAd_closetime(String ad_closetime){
                this.ad_closetime = ad_closetime;
            }
            public String getAd_closetime(){
                return this.ad_closetime;
            }
            public void setAd_share_cnt(String ad_share_cnt){
                this.ad_share_cnt = ad_share_cnt;
            }
            public String getAd_share_cnt(){
                return this.ad_share_cnt;
            }
            public void setAd_pvurl_vendor(String ad_pvurl_vendor){
                this.ad_pvurl_vendor = ad_pvurl_vendor;
            }
            public String getAd_pvurl_vendor(){
                return this.ad_pvurl_vendor;
            }
            public void setContent_id(String content_id){
                this.content_id = content_id;
            }
            public String getContent_id(){
                return this.content_id;
            }
            public void setContent_type(String content_type){
                this.content_type = content_type;
            }
            public String getContent_type(){
                return this.content_type;
            }
            public void setContent_bgcolor(String content_bgcolor){
                this.content_bgcolor = content_bgcolor;
            }
            public String getContent_bgcolor(){
                return this.content_bgcolor;
            }
            public void setShare_url(String share_url){
                this.share_url = share_url;
            }
            public String getShare_url(){
                return this.share_url;
            }
            public void setShare_info(Share_info share_info){
                this.share_info = share_info;
            }
            public Share_info getShare_info(){
                return this.share_info;
            }
            public void setOrientation(String orientation){
                this.orientation = orientation;
            }
            public String getOrientation(){
                return this.orientation;
            }

            public class Author
            {

            }

            public class Share_info
            {
                private String url;

                private String image;

                private String title;

                private String content;

                public void setUrl(String url){
                    this.url = url;
                }
                public String getUrl(){
                    return this.url;
                }
                public void setImage(String image){
                    this.image = image;
                }
                public String getImage(){
                    return this.image;
                }
                public void setTitle(String title){
                    this.title = title;
                }
                public String getTitle(){
                    return this.title;
                }
                public void setContent(String content){
                    this.content = content;
                }
                public String getContent(){
                    return this.content;
                }
            }
        }
    }
}


















