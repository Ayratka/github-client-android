package github.maxat.com.githubclient.data.repository;

import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import rx.Observable;

/**
 * Created by ajrat on 11.09.17.
 */

public class AccessorDataRepository implements AccessorRepository {

    AccessorDataStore dataStore;

    AccessorDataMapper dataMapper;


    public AccessorDataRepository(AccessorDataStore dataStore, AccessorDataMapper mapper){
        this.dataStore = dataStore;
        this.dataMapper = mapper;
    }

	@Override
	public Observable<Accessor> readAccessor() {
		return dataStore.readAccessorEntity ().map(dataMapper::transform);

	}

	@Override
	public Observable<Void> deleteAccessor() {
		return dataStore.deleteAccessorEntity ();
	}

}
