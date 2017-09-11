package github.maxat.com.githubclient.data.repository.datastore;

import android.support.annotation.NonNull;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.AuthBody;
import github.maxat.com.githubclient.data.net.RestApi;
import rx.Observable;
import rx.functions.Action1;

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
    public Observable<AccessorEntity> accessorEntity() {

        AuthBody authBody = new AuthBody();
        authBody.setScopes("gist", "read:user", "repo");
        authBody.setNote("Android Client");
        return restApi.getAccessorEntity(authBody).doOnNext(new Action1<AccessorEntity>() {
            @Override
            public void call(AccessorEntity entity) {

                try {
                    accessorCache.put(entity);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


}
