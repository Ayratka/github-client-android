package github.maxat.com.githubclient.data.repository.datastore;

import android.support.annotation.NonNull;

import java.util.List;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.Specification;
import github.maxat.com.githubclient.data.entity.AbsEntity;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.utils.AppNumeric;

/**
 * Created by ajrat on 09.09.17.
 */

public class AccessorDataStoreFactory {


    private final Cache<AbsEntity> accessorCache;


    public AccessorDataStoreFactory(@NonNull Cache<AbsEntity> accessorCache) {
        this.accessorCache = accessorCache;

    }


    public AccessorDataStore create(int accessorId) {

        AccessorDataStore accessorDataStore;

        if (accessorId!= AppNumeric.UNKNOWN && !this.accessorCache.isExpired(accessorId) && this.accessorCache.isCached(accessorId)) {
            accessorDataStore = new DiskAccessorDataStore(this.accessorCache);
        } else {
            accessorDataStore = createCloudDataStore();
        }
        return accessorDataStore;
    }

    private AccessorDataStore createCloudDataStore() {
        RestApi restApi = ApiService.create();
        return new CloudAccessorDataStore(restApi, accessorCache);
    }

    public AccessorDataStore createCloudDataStore(String user, String password) {
        RestApi restApi = ApiService.create(user, password);
        return new CloudAccessorDataStore(restApi, accessorCache);
    }
}
