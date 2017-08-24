package wang.xiaop.movieplay.network.http;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import wang.xiaop.movieplay.network.entity.HttpResult;
import wang.xiaop.movieplay.network.entity.ListDayDiscount;

/**
 * Created by hjzhang on 2016/7/26.
 */
public interface APIService {
    @GET("GetDayDiscountList")
    Observable<HttpResult<ListDayDiscount>> getDayDiscount(@Query("param") String param);

    @FormUrlEncoded
    @POST("GetDayDiscountList")
    Observable<HttpResult<ListDayDiscount>> getDayDiscountPost(@Field("param") String param);
}
