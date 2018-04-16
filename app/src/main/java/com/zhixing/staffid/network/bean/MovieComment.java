package com.zhixing.staffid.network.bean;

import java.util.Date;
import java.util.List;

public class MovieComment {

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

            private String quote;

            private String content;

            private int praisenum;

            private String device_token;

            private String del_flag;

            private String reviewed;

            private String user_info_id;

            private Date input_date;

            private Date created_at;

            private Date updated_at;

            private User user;

            private Touser touser;

            private String score;

            private int type;

            public void setId(String id){
                this.id = id;
            }
            public String getId(){
                return this.id;
            }
            public void setQuote(String quote){
                this.quote = quote;
            }
            public String getQuote(){
                return this.quote;
            }
            public void setContent(String content){
                this.content = content;
            }
            public String getContent(){
                return this.content;
            }
            public void setPraisenum(int praisenum){
                this.praisenum = praisenum;
            }
            public int getPraisenum(){
                return this.praisenum;
            }
            public void setDevice_token(String device_token){
                this.device_token = device_token;
            }
            public String getDevice_token(){
                return this.device_token;
            }
            public void setDel_flag(String del_flag){
                this.del_flag = del_flag;
            }
            public String getDel_flag(){
                return this.del_flag;
            }
            public void setReviewed(String reviewed){
                this.reviewed = reviewed;
            }
            public String getReviewed(){
                return this.reviewed;
            }
            public void setUser_info_id(String user_info_id){
                this.user_info_id = user_info_id;
            }
            public String getUser_info_id(){
                return this.user_info_id;
            }
            public void setInput_date(Date input_date){
                this.input_date = input_date;
            }
            public Date getInput_date(){
                return this.input_date;
            }
            public void setCreated_at(Date created_at){
                this.created_at = created_at;
            }
            public Date getCreated_at(){
                return this.created_at;
            }
            public void setUpdated_at(Date updated_at){
                this.updated_at = updated_at;
            }
            public Date getUpdated_at(){
                return this.updated_at;
            }
            public void setUser(User user){
                this.user = user;
            }
            public User getUser(){
                return this.user;
            }
            public void setTouser(Touser touser){
                this.touser = touser;
            }
            public Touser getTouser(){
                return this.touser;
            }
            public void setScore(String score){
                this.score = score;
            }
            public String getScore(){
                return this.score;
            }
            public void setType(int type){
                this.type = type;
            }
            public int getType(){
                return this.type;
            }

            public class User
            {
                private String user_id;

                private String user_name;

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
                public void setWeb_url(String web_url){
                    this.web_url = web_url;
                }
                public String getWeb_url(){
                    return this.web_url;
                }
            }

            public class Touser
            {
                private String user_id;

                private String user_name;

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


