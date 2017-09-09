package github.maxat.com.githubclient.data.repository.datastore;

import android.support.annotation.NonNull;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.RestApi;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public class CloudAccessorDataStore implements AccessorDataStore {

    final RestApi restApi;

    Cache accessorCache;


    public CloudAccessorDataStore(@NonNull RestApi restApi, @NonNull Cache accessorCache){
        this.restApi  = restApi;
        this.accessorCache = accessorCache;
    }
    @Override
    public Observable<AccessorEntity> accessorEntity() {
        return null;
    }
}
