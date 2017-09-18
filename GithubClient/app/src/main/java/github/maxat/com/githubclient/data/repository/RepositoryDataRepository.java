package github.maxat.com.githubclient.data.repository;

import java.util.List;

import github.maxat.com.githubclient.data.entity.mapper.RepositoryDataMapper;
import github.maxat.com.githubclient.data.entity.mapper.UserDataMapper;
import github.maxat.com.githubclient.data.repository.datastore.RepositoryDataStore;
import github.maxat.com.githubclient.data.repository.datastore.UserDataStore;
import github.maxat.com.githubclient.domain.model.Repository;
import github.maxat.com.githubclient.domain.model.User;
import github.maxat.com.githubclient.domain.repository.RepositoryRepository;
import rx.Observable;

/**
 * Created by ajrat on 18.09.17.
 */

public class RepositoryDataRepository implements RepositoryRepository {



    RepositoryDataStore dataStore;

    RepositoryDataMapper dataMapper;


    public RepositoryDataRepository(RepositoryDataStore dataStore, RepositoryDataMapper mapper){
        this.dataStore = dataStore;
        this.dataMapper = mapper;
    }


    @Override
    public Observable<Repository> read(long id) {
        return dataStore.readRepositoryEntity ().map(dataMapper::transform);

    }

    @Override
    public Observable<List<Repository>> readOwner() {
        return dataStore.readRepositoriesEntity().map(dataMapper::transforms);
    }
}
