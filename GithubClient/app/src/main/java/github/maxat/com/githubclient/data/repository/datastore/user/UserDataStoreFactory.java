package github.maxat.com.githubclient.data.repository.datastore.user;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.datastore.UserDataStore;
import github.maxat.com.githubclient.domain.model.Accessor;

/**
 * Created by ayrat on 14.09.17.
 */
public class UserDataStoreFactory {


	Cache<UserEntity> cache;


	Cache<AccessorEntity> accessorCache;


	public UserDataStoreFactory(Cache<AccessorEntity> accessorCache,  Cache<UserEntity> cache){
		this.cache = cache;
		this.accessorCache = accessorCache;
	}


	public UserDataStore create(final long id){

		UserDataStore userDataStore;
		if (cache.isCached (id) && !cache.isExpired (id)){
			userDataStore = new UserDiskDataStore (accessorCache, cache);
		}
		else
		{
			RestApi restApi = ApiService.create ();
			userDataStore = new UserCloudDataStore (restApi, accessorCache);
		}
		return userDataStore;
	}
}
