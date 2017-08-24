package wang.xiaop.movieplay.network.http;


import rx.Observable;
import rx.Subscriber;
import wang.xiaop.movieplay.network.entity.ListDayDiscount;

/**
 * Created by hjzhang on 2016/7/26.
 */
public class APIFactory extends RetrofitHttpUtil{

    public static APIFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }
    private static class SingletonHolder {
        private static final APIFactory INSTANCE = new APIFactory();
    }

    public void getDayDiscount(Subscriber<ListDayDiscount> subscriber, String param){
        Observable observable = apiService.getDayDiscount(param)
                .map(new HttpResultFunc<ListDayDiscount>());
        toSubscribe(observable, subscriber);
    }
    public void getDayDiscountPost(Subscriber<ListDayDiscount> subscriber, String param){
        Observable observable = apiService.getDayDiscountPost(param)
                .map(new HttpResultFunc<ListDayDiscount>());
        toSubscribe(observable, subscriber);
    }
}
