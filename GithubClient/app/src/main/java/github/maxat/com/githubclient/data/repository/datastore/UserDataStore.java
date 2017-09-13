package github.maxat.com.githubclient.data.repository.datastore;

import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import rx.Observable;

/**
 * Created by ayrat on 14.09.17.
 */
public interface UserDataStore {

	Observable<UserEntity> readUserEntity();

}
