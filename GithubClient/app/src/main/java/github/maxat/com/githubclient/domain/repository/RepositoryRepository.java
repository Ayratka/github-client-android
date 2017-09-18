package github.maxat.com.githubclient.domain.repository;

import java.util.List;

import github.maxat.com.githubclient.domain.model.Repository;
import github.maxat.com.githubclient.domain.model.User;
import rx.Observable;

/**
 * Created by ajrat on 18.09.17.
 */

public interface RepositoryRepository {

    public Observable<Repository> read(final  long id);

    public Observable<List<Repository>> readOwner();

}
