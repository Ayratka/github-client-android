package github.maxat.com.githubclient.data.repository.datastore.user;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.datastore.UserDataStore;
import github.maxat.com.githubclient.domain.model.Accessor;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

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


	public void create(CreatedUserDataStore createdUserDataStore, final long id){

		Observable.zip(cache.isCached(id), cache.isExpired(id),

				(isCached, isExpired) -> isCached && !isExpired).observeOn(AndroidSchedulers.mainThread())

			.observeOn(AndroidSchedulers.mainThread())
		    .subscribeOn(Schedulers.computation())
				.unsubscribeOn(Schedulers.computation())
				.subscribe( isOffline -> {

					UserDataStore userDataStore;

					if (isOffline)
						userDataStore = new UserDiskDataStore (accessorCache, cache);
					else {
						RestApi restApi = ApiService.create ();
						userDataStore = new UserCloudDataStore (restApi, accessorCache, cache);
					}

					createdUserDataStore.postUserDataStore(userDataStore);


				}, throwable -> {

					RestApi restApi = ApiService.create ();

					UserDataStore userDataStore = new UserCloudDataStore (restApi, accessorCache, cache);

					createdUserDataStore.postUserDataStore(userDataStore);


				});



	}


	public interface CreatedUserDataStore{

		public void postUserDataStore(UserDataStore userDataStore);
	}
}
