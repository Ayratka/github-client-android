package github.maxat.com.githubclient.data.repository.datastore;

import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.domain.model.Accessor;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public interface AccessorDataStore {

    Observable<AccessorEntity> accessorEntity();

}
