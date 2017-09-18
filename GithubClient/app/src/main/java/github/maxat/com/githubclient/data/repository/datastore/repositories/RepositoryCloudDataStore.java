package github.maxat.com.githubclient.data.repository.datastore.repositories;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.RepositoryEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.datastore.RepositoryDataStore;
import github.maxat.com.githubclient.domain.model.Repository;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by ajrat on 18.09.17.
 */

public class RepositoryCloudDataStore implements RepositoryDataStore {

    RestApi restApi;

    Cache<AccessorEntity> accessorCache;

    Cache<RepositoryEntity> repositoryEntityCache;


    public RepositoryCloudDataStore(@NonNull RestApi restApi, Cache<AccessorEntity> accessorCache, Cache<RepositoryEntity> repositoryEntityCache ){
        this.restApi  = restApi;
        this.accessorCache = accessorCache;
        this.repositoryEntityCache  = repositoryEntityCache;
    }

    @Override
    public Observable<RepositoryEntity> readRepositoryEntity() {
        throw new ExceptionInInitializerError("The method does not implement");
    }

    @Override
    public Observable<List<RepositoryEntity>> readRepositoriesEntity() {
         return accessorCache.get(Collections.emptyList()).flatMap(new Func1<AccessorEntity, Observable<List<RepositoryEntity>>>() {
             @Override
             public Observable<List<RepositoryEntity>> call(AccessorEntity entity) {

                 Map<String, String> map  = new HashMap<>();
                 map.put(ApiService.ACCESS_TOKEN, entity.getToken());
                 return restApi.getOwnRepositories(map);
             }
         }).doOnNext(repositoryEntities -> {

             for (RepositoryEntity repositoryEntity: repositoryEntities){

                 repositoryEntity.setOwner(true);
                 repositoryEntityCache.put(repositoryEntity);

             }
         });
    }
}
