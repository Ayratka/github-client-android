package github.maxat.com.githubclient.domain.repository;

import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.model.User;
import rx.Observable;

/**
 * Created by ajrat on 15.09.17.
 */

public interface UserRepository {

    public Observable<User> read(final  long id);
}
