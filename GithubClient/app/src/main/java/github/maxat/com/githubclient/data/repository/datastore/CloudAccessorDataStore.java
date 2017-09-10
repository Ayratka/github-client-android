package github.maxat.com.githubclient.data.repository.datastore;

import android.support.annotation.NonNull;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AbsEntity;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by ajrat on 09.09.17.
 */

public class CloudAccessorDataStore implements AccessorDataStore {

    final RestApi restApi;

    Cache<AbsEntity> accessorCache;


    public CloudAccessorDataStore(@NonNull RestApi restApi, @NonNull Cache<AbsEntity> accessorCache){
        this.restApi  = restApi;
        this.accessorCache = accessorCache;
    }
    @Override
    public Observable<AccessorEntity> accessorEntity() {
        return restApi.getAccessorEntity(null)
                .doOnNext(entity -> accessorCache.put(entity));
    }
}
