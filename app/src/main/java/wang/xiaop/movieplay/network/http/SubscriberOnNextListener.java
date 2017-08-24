package wang.xiaop.movieplay.network.http;

/**
 * Created by liukun on 16/3/10.
 */
public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onError(int code, String message);
}
