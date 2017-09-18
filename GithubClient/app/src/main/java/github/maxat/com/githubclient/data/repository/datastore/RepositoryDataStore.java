package github.maxat.com.githubclient.data.repository.datastore;

import java.util.List;

import github.maxat.com.githubclient.data.entity.RepositoryEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import rx.Observable;

/**
 * Created by ajrat on 18.09.17.
 */

public interface RepositoryDataStore {


    Observable<RepositoryEntity> readRepositoryEntity();

    Observable<List<RepositoryEntity>> readRepositoriesEntity();


}
