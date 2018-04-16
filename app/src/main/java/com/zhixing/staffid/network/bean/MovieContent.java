package com.zhixing.staffid.network.bean;

import java.util.Date;
import java.util.List;

public class MovieContent {

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
        private int count;

        private List<DataSecond> data;

        public void setCount(int count){
            this.count = count;
        }
        public int getCount(){
            return this.count;
        }
        public void setData(List<DataSecond> data){
            this.data = data;
        }
        public List<DataSecond> getData(){
            return this.data;
        }

        public class DataSecond
        {
            private String id;

            private String movie_id;

            private String title;

            private String content;

            private String sort;

            private int praisenum;

            private Date input_date;

            private String story_type;

            private String summary;

            private String audio;

            private String anchor;

            private String copyright;

            private User user;

            private String charge_edt;

            private String editor_email;

            private List<Author_list> author_list;

            public void setId(String id){
                this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setMovie_id(String movie_id){
                this.movie_id = movie_id;
            }
            public String getMovie_id(){
                return this.movie_id;
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
            public void setSort(String sort){
                this.sort = sort;
            }
            public String getSort(){
                return this.sort;
            }
            public void setPraisenum(int praisenum){
                this.praisenum = praisenum;
            }
            public int getPraisenum(){
                return this.praisenum;
            }
            public void setInput_date(Date input_date){
                this.input_date = input_date;
            }
            public Date getInput_date(){
                return this.input_date;
            }
            public void setStory_type(String story_type){
                this.story_type = story_type;
            }
            public String getStory_type(){
                return this.story_type;
            }
            public void setSummary(String summary){
                this.summary = summary;
            }
            public String getSummary(){
                return this.summary;
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
            public void setCopyright(String copyright){
                this.copyright = copyright;
            }
            public String getCopyright(){
                return this.copyright;
            }
            public void setUser(User user){
                this.user = user;
            }
            public User getUser(){
                return this.user;
            }
            public void setCharge_edt(String charge_edt){
                this.charge_edt = charge_edt;
            }
            public String getCharge_edt(){
                return this.charge_edt;
            }
            public void setEditor_email(String editor_email){
                this.editor_email = editor_email;
            }
            public String getEditor_email(){
                return this.editor_email;
            }
            public void setAuthor_list(List<Author_list> author_list){
                this.author_list = author_list;
            }
            public List<Author_list> getAuthor_list(){
                return this.author_list;
            }

            public class User
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
}


