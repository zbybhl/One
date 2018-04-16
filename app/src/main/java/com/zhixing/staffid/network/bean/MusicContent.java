package com.zhixing.staffid.network.bean;

import java.util.Date;
import java.util.List;

public class MusicContent {

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

        private String title;

        private String cover;

        private String isfirst;

        private String story_title;

        private String story;

        private String lyric;

        private String info;

        private String platform;

        private String music_id;

        private String charge_edt;

        private String related_to;

        private String web_url;

        private int praisenum;

        private String hide_flag;

        private String sort;

        private Date maketime;

        private Date last_update_date;

        private String read_num;

        private String story_summary;

        private String audio;

        private String anchor;

        private String editor_email;

        private String related_musics;

        private String album;

        private String start_video;

        private String media_type;

        private String copyright;

        private Author author;

        private Story_author story_author;

        private List<Author_list> author_list;

        private int next_id;

        private String previous_id;

        private int sharenum;

        private int commentnum;

        public void setId(String id){
            this.id = id;
        }
        public String getId(){
            return this.id;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setCover(String cover){
            this.cover = cover;
        }
        public String getCover(){
            return this.cover;
        }
        public void setIsfirst(String isfirst){
            this.isfirst = isfirst;
        }
        public String getIsfirst(){
            return this.isfirst;
        }
        public void setStory_title(String story_title){
            this.story_title = story_title;
        }
        public String getStory_title(){
            return this.story_title;
        }
        public void setStory(String story){
            this.story = story;
        }
        public String getStory(){
            return this.story;
        }
        public void setLyric(String lyric){
            this.lyric = lyric;
        }
        public String getLyric(){
            return this.lyric;
        }
        public void setInfo(String info){
            this.info = info;
        }
        public String getInfo(){
            return this.info;
        }
        public void setPlatform(String platform){
            this.platform = platform;
        }
        public String getPlatform(){
            return this.platform;
        }
        public void setMusic_id(String music_id){
            this.music_id = music_id;
        }
        public String getMusic_id(){
            return this.music_id;
        }
        public void setCharge_edt(String charge_edt){
            this.charge_edt = charge_edt;
        }
        public String getCharge_edt(){
            return this.charge_edt;
        }
        public void setRelated_to(String related_to){
            this.related_to = related_to;
        }
        public String getRelated_to(){
            return this.related_to;
        }
        public void setWeb_url(String web_url){
            this.web_url = web_url;
        }
        public String getWeb_url(){
            return this.web_url;
        }
        public void setPraisenum(int praisenum){
            this.praisenum = praisenum;
        }
        public int getPraisenum(){
            return this.praisenum;
        }
        public void setHide_flag(String hide_flag){
            this.hide_flag = hide_flag;
        }
        public String getHide_flag(){
            return this.hide_flag;
        }
        public void setSort(String sort){
            this.sort = sort;
        }
        public String getSort(){
            return this.sort;
        }
        public void setMaketime(Date maketime){
            this.maketime = maketime;
        }
        public Date getMaketime(){
            return this.maketime;
        }
        public void setLast_update_date(Date last_update_date){
            this.last_update_date = last_update_date;
        }
        public Date getLast_update_date(){
            return this.last_update_date;
        }
        public void setRead_num(String read_num){
            this.read_num = read_num;
        }
        public String getRead_num(){
            return this.read_num;
        }
        public void setStory_summary(String story_summary){
            this.story_summary = story_summary;
        }
        public String getStory_summary(){
            return this.story_summary;
        }
        public void setAudio(String audio){
            this.audio = audio;
        }
        public String getAudio(){
            return this.audio;
        }
        public void setAnchor(String anchor){
            this.anchor = anchor;
        }
        public String getAnchor(){
            return this.anchor;
        }
        public void setEditor_email(String editor_email){
            this.editor_email = editor_email;
        }
        public String getEditor_email(){
            return this.editor_email;
        }
        public void setRelated_musics(String related_musics){
            this.related_musics = related_musics;
        }
        public String getRelated_musics(){
            return this.related_musics;
        }
        public void setAlbum(String album){
            this.album = album;
        }
        public String getAlbum(){
            return this.album;
        }
        public void setStart_video(String start_video){
            this.start_video = start_video;
        }
        public String getStart_video(){
            return this.start_video;
        }
        public void setMedia_type(String media_type){
            this.media_type = media_type;
        }
        public String getMedia_type(){
            return this.media_type;
        }
        public void setCopyright(String copyright){
            this.copyright = copyright;
        }
        public String getCopyright(){
            return this.copyright;
        }
        public void setAuthor(Author author){
            this.author = author;
        }
        public Author getAuthor(){
            return this.author;
        }
        public void setStory_author(Story_author story_author){
            this.story_author = story_author;
        }
        public Story_author getStory_author(){
            return this.story_author;
        }
        public void setAuthor_list(List<Author_list> author_list){
            this.author_list = author_list;
        }
        public List<Author_list> getAuthor_list(){
            return this.author_list;
        }
        public void setNext_id(int next_id){
            this.next_id = next_id;
        }
        public int getNext_id(){
            return this.next_id;
        }
        public void setPrevious_id(String previous_id){
            this.previous_id = previous_id;
        }
        public String getPrevious_id(){
            return this.previous_id;
        }
        public void setSharenum(int sharenum){
            this.sharenum = sharenum;
        }
        public int getSharenum(){
            return this.sharenum;
        }
        public void setCommentnum(int commentnum){
            this.commentnum = commentnum;
        }
        public int getCommentnum(){
            return this.commentnum;
        }

        public class Author
        {
            private String user_id;

            private String user_name;

            private String desc;

            private String wb_name;

            private String is_settled;

            private String settled_type;

            private String summary;

            private String fans_total;

            private String web_url;

            public void setUser_id(String user_id){
                this.user_id = user_id;
            }
            public String getUser_id(){
                return this.user_id;
            }
            public void setUser_name(String user_name){
                this.user_name = user_name;
            }
            public String getUser_name(){
                return this.user_name;
            }
            public void setDesc(String desc){
                this.desc = desc;
            }
            public String getDesc(){
                return this.desc;
            }
            public void setWb_name(String wb_name){
                this.wb_name = wb_name;
            }
            public String getWb_name(){
                return this.wb_name;
            }
            public void setIs_settled(String is_settled){
                this.is_settled = is_settled;
            }
            public String getIs_settled(){
                return this.is_settled;
            }
            public void setSettled_type(String settled_type){
                this.settled_type = settled_type;
            }
            public String getSettled_type(){
                return this.settled_type;
            }
            public void setSummary(String summary){
                this.summary = summary;
            }
            public String getSummary(){
                return this.summary;
            }
            public void setFans_total(String fans_total){
                this.fans_total = fans_total;
            }
            public String getFans_total(){
                return this.fans_total;
            }
            public void setWeb_url(String web_url){
                this.web_url = web_url;
            }
            public String getWeb_url(){
                return this.web_url;
            }
        }

        public class Story_author
        {
            private String user_id;

            private String user_name;

            private String desc;

            private String wb_name;

            private String is_settled;

            private String settled_type;

            private String summary;

            private String fans_total;

            private String web_url;

            public void setUser_id(String user_id){
                this.user_id = user_id;
            }
            public String getUser_id(){
                return this.user_id;
            }
            public void setUser_name(String user_name){
                this.user_name = user_name;
            }
            public String getUser_name(){
                return this.user_name;
            }
            public void setDesc(String desc){
                this.desc = desc;
            }
            public String getDesc(){
                return this.desc;
            }
            public void setWb_name(String wb_name){
                this.wb_name = wb_name;
            }
            public String getWb_name(){
                return this.wb_name;
            }
            public void setIs_settled(String is_settled){
                this.is_settled = is_settled;
            }
            public String getIs_settled(){
                return this.is_settled;
            }
            public void setSettled_type(String settled_type){
                this.settled_type = settled_type;
            }
            public String getSettled_type(){
                return this.settled_type;
            }
            public void setSummary(String summary){
                this.summary = summary;
            }
            public String getSummary(){
                return this.summary;
            }
            public void setFans_total(String fans_total){
                this.fans_total = fans_total;
            }
            public String getFans_total(){
                return this.fans_total;
            }
            public void setWeb_url(String web_url){
                this.web_url = web_url;
            }
            public String getWeb_url(){
                return this.web_url;
            }
        }

        public class Author_list
        {
            private String user_id;

            private String user_name;

            private String desc;

            private String wb_name;

            private String is_settled;

            private String settled_type;

            private String summary;

            private String fans_total;

            private String web_url;

            public void setUser_id(String user_id){
                this.user_id = user_id;
            }
            public String getUser_id(){
                return this.user_id;
            }
            public void setUser_name(String user_name){
                this.user_name = user_name;
            }
            public String getUser_name(){
                return this.user_name;
            }
            public void setDesc(String desc){
                this.desc = desc;
            }
            public String getDesc(){
                return this.desc;
            }
            public void setWb_name(String wb_name){
                this.wb_name = wb_name;
            }
            public String getWb_name(){
                return this.wb_name;
            }
            public void setIs_settled(String is_settled){
                this.is_settled = is_settled;
            }
            public String getIs_settled(){
                return this.is_settled;
            }
            public void setSettled_type(String settled_type){
                this.settled_type = settled_type;
            }
            public String getSettled_type(){
                return this.settled_type;
            }
            public void setSummary(String summary){
                this.summary = summary;
            }
            public String getSummary(){
                return this.summary;
            }
            public void setFans_total(String fans_total){
                this.fans_total = fans_total;
            }
            public String getFans_total(){
                return this.fans_total;
            }
            public void setWeb_url(String web_url){
                this.web_url = web_url;
            }
            public String getWeb_url(){
                return this.web_url;
            }
        }
    }
}





