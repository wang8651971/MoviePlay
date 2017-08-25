package wang.xiaop.movieplay.network;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import wang.xiaop.movieplay.utils.Base64Util;

/**
 * Created by 王攀 on 2017/8/25.
 */

public class Net {

    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;
    }

    public static void request() {
        String url = Base64Util.encode("http://apicloud.mob.com/ucache/put?key=20239ada8b4f3&&table=movie&k=aaa&v={\"name\": \"《七龙珠》\"}");

        Request request = new Request.Builder().url(url).build();
        getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.w("tag", response.body().string());
            }
        });
    }
}
