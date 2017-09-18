package github.maxat.com.githubclient.data.repository.datastore.repositories;

import java.util.List;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.RepositoryEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.data.repository.BaseSpecification;
import github.maxat.com.githubclient.data.repository.Specification;
import github.maxat.com.githubclient.data.repository.datastore.RepositoryDataStore;
import github.maxat.com.githubclient.domain.model.Repository;
import github.maxat.com.githubclient.domain.repository.UserRepository;
import rx.Observable;

/**
 * Created by ajrat on 18.09.17.
 */

public class RepositoryDiskDataStore implements RepositoryDataStore {


    Cache<AccessorEntity> accessorCache;

    Cache<RepositoryEntity> repositoryEntityCache;

    Cache<UserEntity> userEntityCache;

    public RepositoryDiskDataStore(Cache<AccessorEntity> accessorCache,
                                   Cache<UserEntity> userEntityCache,
                                   Cache<RepositoryEntity> repositoryEntityCache){

        this.accessorCache = accessorCache;
        this.userEntityCache = userEntityCache;
        this.repositoryEntityCache = repositoryEntityCache;
    }



    @Override
    public Observable<RepositoryEntity> readRepositoryEntity() {
        throw new ExceptionInInitializerError("this method does not implemented");
    }

    @Override
    public Observable<List<RepositoryEntity>> readRepositoriesEntity() {
        Specification specification = new BaseSpecification(RepositoryEntity.FIELD_LOCAL_IS_OWNER, true);
        return repositoryEntityCache.getList(specification);
    }
}
