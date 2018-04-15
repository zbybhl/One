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
        // һ��ʵ�壨�ࣩ�͹��������ݿ��е�һ�ű��˴�����Ϊ��Note������������
        Entity note = schema.addEntity("Note");
        // ��Ҳ�������¸�������
        // note.setTableName("NODE");

        // greenDAO ���Զ�����ʵ���������ֵ���������ֶΣ�������Ĭ��ֵ
        // ���������������ñ��е��ֶΣ�
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        // ���� Java ��ʹ���շ���������ͬ��Ĭ�����ݿ��е�������ʹ�ô�д���»������ָ�ʵġ�
        // For example, a property called ��creationDate�� will become a database column ��CREATION_DATE��.
        note.addStringProperty("comment");
        note.addDateProperty("date");
    }
}
