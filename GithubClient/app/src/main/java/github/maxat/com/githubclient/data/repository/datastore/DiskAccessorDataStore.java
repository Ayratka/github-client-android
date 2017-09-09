package github.maxat.com.githubclient.data.repository.datastore;

import android.support.annotation.NonNull;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public class DiskAccessorDataStore implements AccessorDataStore {


    private final Cache accessorCache;


    public DiskAccessorDataStore(@NonNull Cache accessorCache){
        this.accessorCache = accessorCache;
    }

    @Override
    public Observable<AccessorEntity> accessorEntity() {
        return null;
    }
}
