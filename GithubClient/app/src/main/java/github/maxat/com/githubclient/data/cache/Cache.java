package github.maxat.com.githubclient.data.cache;

import java.util.List;

import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.domain.model.Accessor;
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

    boolean isCached(final int id);

    boolean isExpired();

    void evictAll();



}
