package com.zhixing.staffid.network.bean;

import java.util.Date;
import java.util.List;

public class MoviePicture {

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

        private String indexcover;

        private String detailcover;

        private String video;

        private String verse;

        private String verse_en;

        private String score;

        private String revisedscore;

        private String review;

        private String keywords;

        private String movie_id;

        private String info;

        private String officialstory;

        private String hide_flag;

        private String charge_edt;

        private String web_url;

        private int praisenum;

        private String sort;

        private Date releasetime;

        private Date scoretime;

        private Date maketime;

        private Date last_update_date;

        private String read_num;

        private String directors;

        private String editor_email;

        private String related;

        private String directors_id;

        private String start_video;

        private String media_type;

        private String poster;

        private List<String> photo;

        private String next_id;

        private String previous_id;

        private int sharenum;

        private int commentnum;

        private int servertime;

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
        public void setIndexcover(String indexcover){
            this.indexcover = indexcover;
        }
        public String getIndexcover(){
            return this.indexcover;
        }
        public void setDetailcover(String detailcover){
            this.detailcover = detailcover;
        }
        public String getDetailcover(){
            return this.detailcover;
        }
        public void setVideo(String video){
            this.video = video;
        }
        public String getVideo(){
            return this.video;
        }
        public void setVerse(String verse){
            this.verse = verse;
        }
        public String getVerse(){
            return this.verse;
        }
        public void setVerse_en(String verse_en){
            this.verse_en = verse_en;
        }
        public String getVerse_en(){
            return this.verse_en;
        }
        public void setScore(String score){
            this.score = score;
        }
        public String getScore(){
            return this.score;
        }
        public void setRevisedscore(String revisedscore){
            this.revisedscore = revisedscore;
        }
        public String getRevisedscore(){
            return this.revisedscore;
        }
        public void setReview(String review){
            this.review = review;
        }
        public String getReview(){
            return this.review;
        }
        public void setKeywords(String keywords){
            this.keywords = keywords;
        }
        public String getKeywords(){
            return this.keywords;
        }
        public void setMovie_id(String movie_id){
            this.movie_id = movie_id;
        }
        public String getMovie_id(){
            return this.movie_id;
        }
        public void setInfo(String info){
            this.info = info;
        }
        public String getInfo(){
            return this.info;
        }
        public void setOfficialstory(String officialstory){
            this.officialstory = officialstory;
        }
        public String getOfficialstory(){
            return this.officialstory;
        }
        public void setHide_flag(String hide_flag){
            this.hide_flag = hide_flag;
        }
        public String getHide_flag(){
            return this.hide_flag;
        }
        public void setCharge_edt(String charge_edt){
            this.charge_edt = charge_edt;
        }
        public String getCharge_edt(){
            return this.charge_edt;
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
        public void setSort(String sort){
            this.sort = sort;
        }
        public String getSort(){
            return this.sort;
        }
        public void setReleasetime(Date releasetime){
            this.releasetime = releasetime;
        }
        public Date getReleasetime(){
            return this.releasetime;
        }
        public void setScoretime(Date scoretime){
            this.scoretime = scoretime;
        }
        public Date getScoretime(){
            return this.scoretime;
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
        public void setDirectors(String directors){
            this.directors = directors;
        }
        public String getDirectors(){
            return this.directors;
        }
        public void setEditor_email(String editor_email){
            this.editor_email = editor_email;
        }
        public String getEditor_email(){
            return this.editor_email;
        }
        public void setRelated(String related){
            this.related = related;
        }
        public String getRelated(){
            return this.related;
        }
        public void setDirectors_id(String directors_id){
            this.directors_id = directors_id;
        }
        public String getDirectors_id(){
            return this.directors_id;
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
        public void setPoster(String poster){
            this.poster = poster;
        }
        public String getPoster(){
            return this.poster;
        }
        public void setPhoto(List<String> photo){
            this.photo = photo;
        }
        public List<String> getPhoto(){
            return this.photo;
        }
        public void setNext_id(String next_id){
            this.next_id = next_id;
        }
        public String getNext_id(){
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
        public void setServertime(int servertime){
            this.servertime = servertime;
        }
        public int getServertime(){
            return this.servertime;
        }
    }

}


