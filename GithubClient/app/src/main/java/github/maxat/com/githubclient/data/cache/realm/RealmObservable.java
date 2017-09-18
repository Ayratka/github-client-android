package github.maxat.com.githubclient.data.cache.realm;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by ajrat on 17.09.17.
 */

public final class RealmObservable {

    private RealmObservable() {}

    public static <T> Observable<T> object(final Func1<Realm, T> function) {
        return Observable.create(new OnSubscribeRealm<T>() {
            @Override
            public T get(Realm realm) {
                return function.call(realm);
            }
        });
    }




}
