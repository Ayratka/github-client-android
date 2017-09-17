package github.maxat.com.githubclient.data.repository.datastore.accessor;

import android.support.annotation.NonNull;

import java.util.Collections;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.net.auth.BasicAuthInterceptor;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;

/**
 * Created by ajrat on 09.09.17.
 */

public class AccessorDataStoreFactory {


    private  Cache accessorCache;



    public AccessorDataStoreFactory(@NonNull Cache accessorCache) {
        this.accessorCache = accessorCache;

    }


    public void createCloudDataStore(@NonNull CreatedStore createdStore) {

	     accessorCache.get (Collections.emptyList ())
			    .doOnNext (entity -> {

				    RestApi restApi = ApiService.create();
					createdStore.postAccessorDataStore (new CloudAccessorDataStore(restApi, accessorCache));

			    }).subscribe ();

    }

    public AccessorDataStore createCloudDataStore(String user, String password) {
        RestApi restApi = ApiService.create(new BasicAuthInterceptor (user, password));
        return new CloudAccessorDataStore(restApi, accessorCache);
    }

	public AccessorDataStore createDiskDataStore() {
		return new DiskAccessorDataStore (accessorCache);
	}


	public interface CreatedStore{
		public void postAccessorDataStore(AccessorDataStore accessorDataStore);
	}
}
