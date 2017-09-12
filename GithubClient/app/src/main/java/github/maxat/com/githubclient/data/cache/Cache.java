package github.maxat.com.githubclient.data.cache;

import java.util.List;

import github.maxat.com.githubclient.data.repository.Specification;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public interface Cache<T>{


    Observable<T> get(Specification specification);

    Observable<T> get(List<Specification> specifications);

    Observable<List<T>> getList(List<Specification> specifications);

    Observable<List<T>> getList(Specification specification);


    void put(T object);

    boolean isCached(final long id);

    boolean isExpired(final long id);

    void evictAll();

	boolean evict();



}
