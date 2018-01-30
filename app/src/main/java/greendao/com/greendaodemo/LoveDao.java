package greendao.com.greendaodemo;

import java.util.List;

/**
 * Created by zhangqiang on 2018/1/30.
 */

public class LoveDao {

    /**
     * 添加数据，如果有重复则覆盖
     *
     * @param shop
     */
    public static void insertLove(Shop shop) {
        GreenDaoApplication.getDaoInstant().getShopDao().insertOrReplace(shop);
    }

    /**
     * 添加数据
     *
     * @param shops
     */
    public static void insertLoves(List<Shop> shops) {
        GreenDaoApplication.getDaoInstant().getShopDao().deleteAll();
        GreenDaoApplication.getDaoInstant().getShopDao().insertInTx(shops);
    }

    /**
     * 添加数据
     *
     * @param shops
     */
    public static void insertOrReplaceLoves(List<Shop> shops) {
        GreenDaoApplication.getDaoInstant().getShopDao().deleteAll();
        GreenDaoApplication.getDaoInstant().getShopDao().insertOrReplaceInTx(shops);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteLove(long id) {
        GreenDaoApplication.getDaoInstant().getShopDao().deleteByKey(id);
    }

    /**
     * 删除数据
     *
     * @param shop
     */
    public static void deleteLove(Shop shop) {
        GreenDaoApplication.getDaoInstant().getShopDao().delete(shop);
    }

    /**
     * 删除数据
     *
     * @param shops
     */
    public static void deleteLoves(List<Shop> shops) {
        GreenDaoApplication.getDaoInstant().getShopDao().deleteInTx(shops);
    }
    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(Shop shop) {
        GreenDaoApplication.getDaoInstant().getShopDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Shop> queryLove() {
        return GreenDaoApplication.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
    }

    /**
     * 查询全部数据
     */
    public static List<Shop> queryAll() {
        return GreenDaoApplication.getDaoInstant().getShopDao().loadAll();
    }

}
