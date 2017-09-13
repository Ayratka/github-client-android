package github.maxat.com.githubclient.data.repository.datastore.user;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.datastore.UserDataStore;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by ayrat on 14.09.17.
 */
public class UserCloudDataStore implements UserDataStore {

	RestApi restApi;

	Cache<AccessorEntity> accessorCache;


	public UserCloudDataStore(@NonNull RestApi restApi,  Cache<AccessorEntity> accessorCache){
		this.restApi  = restApi;
		this.accessorCache = accessorCache;
	}

	@Override
	public Observable<UserEntity> readUserEntity() {
		return accessorCache.get (Collections.emptyList ()).flatMap (entity -> {

			Map<String, String> options = new HashMap<String, String> ();
			options.put ("access_token",  entity.getToken ());
			return restApi.getUser (options);
		});

	}
}
