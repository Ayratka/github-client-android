package github.maxat.com.githubclient.data.repository;

import android.util.Log;

import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import rx.Observable;
import rx.functions.Func1;

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
	public Observable<Accessor> read() {
		return dataStore.readAccessorEntity ().map(new Func1<AccessorEntity, Accessor>() {
            @Override
            public Accessor call(AccessorEntity entity) {
                return dataMapper.transform(entity);
            }
        });

	}

}
