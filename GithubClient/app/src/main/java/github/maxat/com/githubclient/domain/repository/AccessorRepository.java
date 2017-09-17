package github.maxat.com.githubclient.domain.repository;


import github.maxat.com.githubclient.domain.model.Accessor;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public interface AccessorRepository {

    public Observable<Accessor> read();

}
