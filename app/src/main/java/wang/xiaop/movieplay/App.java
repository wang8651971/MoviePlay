package wang.xiaop.movieplay;

import android.app.Application;

/**
 * Created by 王攀 on 2017/8/24.
 */

public class App extends Application {
    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //初始化网络请求工具
//        APIFactory.getInstance().init(this);
    }
}
