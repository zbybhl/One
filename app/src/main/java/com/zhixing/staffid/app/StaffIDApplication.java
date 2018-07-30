package com.zhixing.staffid.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.zhixing.staffid.dao.DaoMaster;
import com.zhixing.staffid.dao.DaoSession;
import com.zhixing.staffid.util.SystemUtil;

public class StaffIDApplication extends Application {

    private static final String dbName = "faceAuthentication_db";
    private DaoMaster.DevOpenHelper openHelper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public static String channel;
    public static String version;
    public static String uuid;
    public static String platform = "android";

    private volatile static StaffIDApplication dbInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        initDatabase();
        dbInstance=this;
        setSystemParameter();
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
        openHelper.onUpgrade(db, 0, 1);
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public DaoSession getSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    private void setSystemParameter() {
        String TAG = "系统参数：";
        channel = SystemUtil.getDeviceBrand().substring(4, 6);
        Log.e(TAG, "手机厂商：" + channel);
        version = SystemUtil.getSystemVersion();
        Log.e(TAG, "Android系统版本号：" + version);
        uuid = SystemUtil.getUUID(getApplicationContext());
        Log.e(TAG, "手机uuid：" + uuid);
    }

}
