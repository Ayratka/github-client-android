package github.maxat.com.githubclient.data.cache;

import java.util.List;

import github.maxat.com.githubclient.data.repository.Specification;
import io.realm.RealmObject;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public interface Cache<T>{


    Observable<T> get(Specification specification);

    Observable<T> get(List<Specification> specifications);

    Observable<List<T>> getList(List<Specification> specifications);

    Observable<List<T>> getList(Specification specification);


    Observable<Void> put(T object);

    Observable<Boolean> isCached(final long id);

    Observable<Boolean> isExpired(final long id);

    Observable<Void> evictAll();




}
