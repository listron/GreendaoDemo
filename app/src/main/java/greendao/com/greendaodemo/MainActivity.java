package greendao.com.greendaodemo;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Shop> shops = new ArrayList<>();
        for(int i =0;i<100;i++){
            Shop shop = new Shop();
            shop.setAddress("tianjin");
            shop.setId(Long.valueOf(i));
            shop.setName("Name"+i);
            shop.setImage_url("http://");
            shop.setPrice("123");
            if(i%10 == 0){
                shop.setType(Shop.TYPE_LOVE);
            }else{
                shop.setType(Shop.TYPE_CART);
            }
            shops.add(shop);
        }

        //插入数据
        LoveDao.insertOrReplaceLoves(shops);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                //获取全部数据
                List<Shop> shops =  LoveDao.queryAll();
                Iterator<Shop> iterator = shops.iterator();
                while (iterator.hasNext()){
                    Shop shop1 = iterator.next();
                    Log.d("shop",shop1.getAddress()+"\n");
                    Log.d("shop",shop1.getName()+ "\n");
                    Log.d("shop",shop1.getPrice() + "\n");
                }

                //获取全部数据Shop.TYPE_LOVE的数据
                List<Shop> shops1 = LoveDao.queryLove();
                Iterator<Shop>  iterator1 = shops.iterator();
                while (iterator1.hasNext()){
                    Shop shop1 = iterator1.next();
                    Log.d("shop",shop1.getAddress()+"\n");
                    Log.d("shop",shop1.getName()+ "\n");
                    Log.d("shop",shop1.getPrice() + "\n");
                }
            }
        },2000);
    }
}
