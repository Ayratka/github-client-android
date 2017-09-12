package github.maxat.com.githubclient.data.repository.datastore;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.AuthBody;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.BaseSpecification;
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
        this.accessorCache = (Cache<AccessorEntity>) accessorCache;
    }



    @Override
    public Observable<AccessorEntity> readAccessorEntity() {

        AuthBody authBody = new AuthBody();
        authBody.setScopes("gist", "read:user", "repo");
        authBody.setNote("Android Client");
        return restApi.getAccessorEntity(authBody).
		        doOnNext(entity -> accessorCache.put(entity));
    }

	@Override
	public Observable<Boolean> deleteAccessorEntity() {

		return accessorCache.get (Collections.emptyList ())
				.doOnNext (entity -> {

					if (entity!=null) {
						Map<String, String> options = new HashMap<> ();
						options.put ("access_token", entity.getToken ());
						restApi.deleteAccessorEntity (entity.getId (), options);

						accessorCache.evict ();
					}

				}).map (entity -> entity!=null);



	}


}
