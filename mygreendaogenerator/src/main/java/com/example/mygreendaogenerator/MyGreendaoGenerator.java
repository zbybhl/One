package com.example.mygreendaogenerator;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;



/**
 * Created by zhaobiying on 2018/3/31.
 */

public class MyGreendaoGenerator  {
    public static void main(String[] args) throws Exception {


        Schema schema = new Schema(1, "com.zhixing.staffid.entity");
        schema.setDefaultJavaPackageDao("com.zhixing.staffid.dao");
        addNote(schema);

        new DaoGenerator().generateAll(schema,"./app/src/main/java/");
    }
    private static void addNote(Schema schema) {
        // 一个实体（类）就关联到数据库中的一张表，此处表名为「Note」（既类名）
        Entity note = schema.addEntity("Note");
        // 你也可以重新给表命名
        // note.setTableName("NODE");

        // greenDAO 会自动根据实体类的属性值来创建表字段，并赋予默认值
        // 接下来你便可以设置表中的字段：
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        // 与在 Java 中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        // For example, a property called “creationDate” will become a database column “CREATION_DATE”.
        note.addStringProperty("comment");
        note.addDateProperty("date");
    }
}
