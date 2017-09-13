package github.maxat.com.githubclient.data.repository.datastore.accessor;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.AuthBody;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.BaseSpecification;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import io.realm.Realm;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by ajrat on 09.09.17.
 */

public class CloudAccessorDataStore  implements AccessorDataStore {

    final RestApi restApi;

    Cache<AccessorEntity> accessorCache;


    public CloudAccessorDataStore(@NonNull RestApi restApi, @NonNull Cache<AccessorEntity> accessorCache){
        this.restApi  = restApi;
        this.accessorCache = accessorCache;
    }



    @Override
    public Observable<AccessorEntity> readAccessorEntity() {

        AuthBody authBody = AuthBody.newInstance();
        return restApi.getAccessorEntity(authBody).doOnNext(
		        entity -> {accessorCache.put(entity);}

        );
    }

	@Override
	public Observable<Void> deleteAccessorEntity() {

//		accessorCache.get (Collections.emptyList ())
//				.doOnNext (entity -> {
//
//				})
//				.map (entity -> {
//					return Observable.just (entity!=null);
//				})
//				.subscribe ();


		return Observable.empty ();
	}


}
