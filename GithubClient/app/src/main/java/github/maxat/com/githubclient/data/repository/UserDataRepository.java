package github.maxat.com.githubclient.data.repository;

import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.entity.mapper.UserDataMapper;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.data.repository.datastore.UserDataStore;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.model.User;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import github.maxat.com.githubclient.domain.repository.UserRepository;
import rx.Observable;

/**
 * Created by ajrat on 15.09.17.
 */

public class UserDataRepository implements UserRepository {


    UserDataStore dataStore;

    UserDataMapper dataMapper;


    public UserDataRepository(UserDataStore dataStore, UserDataMapper mapper){
        this.dataStore = dataStore;
        this.dataMapper = mapper;
    }


    @Override
    public Observable<User> read(long id) {
        return dataStore.readUserEntity ().map(dataMapper::transform);

    }
}
