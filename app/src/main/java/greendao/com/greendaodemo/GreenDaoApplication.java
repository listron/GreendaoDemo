package greendao.com.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by zhangqiang on 2018/1/30.
 */

public class GreenDaoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化greenDao
        setupDatabase();
    }

    public GreenDaoApplication() {
        super();
    }


    private static DaoSession daoSession;
    /**
     * 配置数据库
     */
    private void setupDatabase() {
        //创建数据库shop.db"
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        //获取可写数据库
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }

    public ShopDao getShopDao(){
        ShopDao dao = daoSession.getShopDao();
        return dao;
    }
}
