package github.maxat.com.githubclient.data.repository.datastore.accessor;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Collections;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.realm.RealmObservable;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.domain.model.Accessor;
import io.realm.Realm;
import io.realm.RealmObject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ajrat on 09.09.17.
 */

public class DiskAccessorDataStore  implements AccessorDataStore {


    Cache accessorCache;


    public DiskAccessorDataStore(@NonNull Cache<RealmObject> accessorCache){
        this.accessorCache = accessorCache;
    }

    @Override
    public Observable<AccessorEntity> readAccessorEntity() {

        return accessorCache.get(Collections.emptyList());

    }

}
