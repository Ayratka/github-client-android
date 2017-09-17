package github.maxat.com.githubclient.data.repository.datastore.accessor;

import android.support.annotation.NonNull;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.AuthBody;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public class CloudAccessorDataStore  implements AccessorDataStore {

    final RestApi restApi;

    Cache accessorCache;


    public CloudAccessorDataStore(@NonNull RestApi restApi, @NonNull Cache  accessorCache){
        this.restApi  = restApi;
        this.accessorCache = accessorCache;
    }



    @Override
    public Observable<AccessorEntity> readAccessorEntity() {

        AuthBody authBody = AuthBody.newInstance();

        return restApi.getAccessorEntity(authBody).doOnNext(
                entity -> {

                    accessorCache.put(entity).subscribe();

                }  );
    }




}
