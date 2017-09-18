package github.maxat.com.githubclient.domain.interactor;

import java.util.ArrayList;
import java.util.List;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.domain.model.Accessor;
import io.realm.RealmObject;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

/**
 * Created by ajrat on 17.09.17.
 */

public class LogOut extends UseCase<Boolean, Void> {

    List<Cache> cacheList;

    public LogOut(Scheduler front, Scheduler back) {
        super(front, back);
        this.cacheList = new ArrayList<>();
        this.cacheList.add(new CacheImpl(AccessorEntity.class));
        this.cacheList.add(new CacheImpl(UserEntity.class));
    }

    @Override
    Observable<Boolean> buildUseCaseObservable(Void aVoid) {

        return Observable.just(cacheList).map(new Func1<List<Cache>, Boolean>() {
            @Override
            public Boolean call(List<Cache> caches) {

                for (Cache cache: caches){

                    cache.evictAll().subscribe();

                }

                return true;
            }
        });

    }
}
