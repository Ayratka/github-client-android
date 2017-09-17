package github.maxat.com.githubclient.domain.interactor;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.repository.AccessorDataRepository;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.data.repository.datastore.accessor.AccessorDataStoreFactory;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ayrat on 08.09.17.
 */
public class LogIn extends UseCase<Boolean, Void> {


	AccessorRepository accessorRepository;

	public LogIn(AccessorRepository accessorRepository, Scheduler front, Scheduler back) {
		super (front, back);
		this.accessorRepository = accessorRepository;
	}


	@Override
	Observable<Boolean> buildUseCaseObservable(Void unused) {
		return accessorRepository.read().map(accessor -> accessor!=null && accessor.getId()>0);

	}

	public static LogIn newInstance() {


		Cache<RealmObject> cache = new CacheImpl(AccessorEntity.class);

		AccessorDataStoreFactory factory = new AccessorDataStoreFactory(cache);

		AccessorDataStore accessorDataStore = factory.createDiskDataStore ();

		AccessorRepository repository = new AccessorDataRepository(accessorDataStore, AccessorDataMapper.newInstance());

		return new LogIn (repository, AndroidSchedulers.mainThread(), Schedulers.io());

	}
}
