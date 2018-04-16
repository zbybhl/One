package com.zhixing.staffid.network.bean;

import java.util.Date;
import java.util.List;

public class OneWeekChineseContent {

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
        private String content_id;

        private String hp_title;

        private String sub_title;

        private String hp_author;

        private String auth_it;

        private String hp_author_introduce;

        private String hp_content;

        private Date hp_makettime;

        private String hide_flag;

        private String wb_name;

        private String wb_img_url;

        private Date last_update_date;

        private String web_url;

        private String guide_word;

        private String audio;

        private String anchor;

        private String editor_email;

        private String top_media_type;

        private String top_media_file;

        private String top_media_image;

        private String start_video;

        private String copyright;

        private List<Author> author;

        private Date maketime;

        private List<Author_list> author_list;

        private String next_id;

        private String previous_id;

        private int praisenum;

        private int sharenum;

        private int commentnum;

        public void setContent_id(String content_id){
            this.content_id = content_id;
        }
        public String getContent_id(){
            return this.content_id;
        }
        public void setHp_title(String hp_title){
            this.hp_title = hp_title;
        }
        public String getHp_title(){
            return this.hp_title;
        }
        public void setSub_title(String sub_title){
            this.sub_title = sub_title;
        }
        public String getSub_title(){
            return this.sub_title;
        }
        public void setHp_author(String hp_author){
            this.hp_author = hp_author;
        }
        public String getHp_author(){
            return this.hp_author;
        }
        public void setAuth_it(String auth_it){
            this.auth_it = auth_it;
        }
        public String getAuth_it(){
            return this.auth_it;
        }
        public void setHp_author_introduce(String hp_author_introduce){
            this.hp_author_introduce = hp_author_introduce;
        }
        public String getHp_author_introduce(){
            return this.hp_author_introduce;
        }
        public void setHp_content(String hp_content){
            this.hp_content = hp_content;
        }
        public String getHp_content(){
            return this.hp_content;
        }
        public void setHp_makettime(Date hp_makettime){
            this.hp_makettime = hp_makettime;
        }
        public Date getHp_makettime(){
            return this.hp_makettime;
        }
        public void setHide_flag(String hide_flag){
            this.hide_flag = hide_flag;
        }
        public String getHide_flag(){
            return this.hide_flag;
        }
        public void setWb_name(String wb_name){
            this.wb_name = wb_name;
        }
        public String getWb_name(){
            return this.wb_name;
        }
        public void setWb_img_url(String wb_img_url){
            this.wb_img_url = wb_img_url;
        }
        public String getWb_img_url(){
            return this.wb_img_url;
        }
        public void setLast_update_date(Date last_update_date){
            this.last_update_date = last_update_date;
        }
        public Date getLast_update_date(){
            return this.last_update_date;
        }
        public void setWeb_url(String web_url){
            this.web_url = web_url;
        }
        public String getWeb_url(){
            return this.web_url;
        }
        public void setGuide_word(String guide_word){
            this.guide_word = guide_word;
        }
        public String getGuide_word(){
            return this.guide_word;
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
        public void setTop_media_type(String top_media_type){
            this.top_media_type = top_media_type;
        }
        public String getTop_media_type(){
            return this.top_media_type;
        }
        public void setTop_media_file(String top_media_file){
            this.top_media_file = top_media_file;
        }
        public String getTop_media_file(){
            return this.top_media_file;
        }
        public void setTop_media_image(String top_media_image){
            this.top_media_image = top_media_image;
        }
        public String getTop_media_image(){
            return this.top_media_image;
        }
        public void setStart_video(String start_video){
            this.start_video = start_video;
        }
        public String getStart_video(){
            return this.start_video;
        }
        public void setCopyright(String copyright){
            this.copyright = copyright;
        }
        public String getCopyright(){
            return this.copyright;
        }
        public void setAuthor(List<Author> author){
            this.author = author;
        }
        public List<Author> getAuthor(){
            return this.author;
        }
        public void setMaketime(Date maketime){
            this.maketime = maketime;
        }
        public Date getMaketime(){
            return this.maketime;
        }
        public void setAuthor_list(List<Author_list> author_list){
            this.author_list = author_list;
        }
        public List<Author_list> getAuthor_list(){
            return this.author_list;
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
        public void setPraisenum(int praisenum){
            this.praisenum = praisenum;
        }
        public int getPraisenum(){
            return this.praisenum;
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
