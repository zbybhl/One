package com.zhixing.staffid.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.zhixing.staffid.dao.DaoMaster;
import com.zhixing.staffid.dao.DaoSession;

public class StaffIDApplication extends Application {

    private static final String dbName = "faceAuthentication_db";
    private DaoMaster.DevOpenHelper openHelper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private volatile static StaffIDApplication dbInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        dbInstance = this;
        initDatabase();
    }

    public static StaffIDApplication getDbInstance() {
        if (dbInstance == null) {
            synchronized (StaffIDApplication.class) {
                if (dbInstance == null) {
                    dbInstance = new StaffIDApplication();
                }
            }
        }
        return dbInstance;
    }

    private void initDatabase() {
        openHelper = new DaoMaster.DevOpenHelper(this, dbName, null);
        db = openHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
