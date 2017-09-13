package github.maxat.com.githubclient.data.repository.datastore;

import android.support.annotation.NonNull;

import java.util.Collections;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public class DiskAccessorDataStore  implements AccessorDataStore {


    private final Cache<AccessorEntity> accessorCache;


    public DiskAccessorDataStore(@NonNull Cache<AccessorEntity> accessorCache){
        this.accessorCache = (Cache<AccessorEntity>) accessorCache;
    }

    @Override
    public Observable<AccessorEntity> readAccessorEntity() {
        return accessorCache.get(Collections.emptyList());
    }

	@Override
	public Observable<Void> deleteAccessorEntity() {
		Observable.just (accessorCache.evict ());
		return Observable.empty ();
	}
}
