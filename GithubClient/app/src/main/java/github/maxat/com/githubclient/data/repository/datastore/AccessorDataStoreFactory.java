package github.maxat.com.githubclient.data.repository.datastore;

import android.support.annotation.NonNull;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;

/**
 * Created by ajrat on 09.09.17.
 */

public class AccessorDataStoreFactory {




    private final Cache accessorCache;


    public AccessorDataStoreFactory(@NonNull Cache accessorCache) {
        this.accessorCache = accessorCache;
    }



    public AccessorDataStore create(int accessorId) {

        AccessorDataStore accessorDataStore;

        if (!this.accessorCache.isExpired() && this.accessorCache.isCached(accessorId)) {
            accessorDataStore = new DiskAccessorDataStore(this.accessorCache);
        } else {
            accessorDataStore = createCloudDataStore();
        }

        return accessorDataStore;
    }


    public AccessorDataStore createCloudDataStore() {
        final RestApi restApi = ApiService.create();
        return new CloudAccessorDataStore(restApi, this.accessorCache);
    }
}
