package github.maxat.com.githubclient.data.repository.datastore.user;

import android.support.annotation.NonNull;

import java.util.Collections;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.BaseSpecification;
import github.maxat.com.githubclient.data.repository.Specification;
import github.maxat.com.githubclient.data.repository.datastore.UserDataStore;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by ayrat on 14.09.17.
 */
public class UserDiskDataStore implements UserDataStore {


	Cache<AccessorEntity> accessorCache;

	Cache<UserEntity> userCache;

	public UserDiskDataStore(Cache<AccessorEntity> accessorCache, Cache<UserEntity> userCache){
		this.accessorCache = accessorCache;
		this.userCache = userCache;
	}

	@Override
	public Observable<UserEntity> readUserEntity() {
		return accessorCache.get (Collections.emptyList ()).flatMap (entity -> {
			Specification specification = new BaseSpecification (UserEntity.FIELD_ID, entity.getId ());
			return userCache.get (specification);
		});
	}
}
