package github.maxat.com.githubclient.presentation.presenter;

import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.repository.AccessorDataRepository;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStoreFactory;
import github.maxat.com.githubclient.data.utils.AppNumeric;
import github.maxat.com.githubclient.domain.interactor.LogIn;
import github.maxat.com.githubclient.domain.interactor.LogOut;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import github.maxat.com.githubclient.presentation.view.kinds.UserPageDataView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ayrat on 11.09.17.
 */
public class UserPagePresenter implements Presenter<UserPageDataView> {

	UserPageDataView userPageDataView;


	@Override
	public void resume() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void attach(UserPageDataView userPageDataView) {
		this.userPageDataView = userPageDataView;
	}

	public void getUser() {

		Cache cache = new CacheImpl(AccessorEntity.class);

		AccessorDataStoreFactory factory = new AccessorDataStoreFactory(cache);

		AccessorDataStore accessorDataStore = factory.createDiskDataStore ();

		AccessorRepository repository = new AccessorDataRepository(accessorDataStore, AccessorDataMapper.newInstance());

		LogIn login = new LogIn (repository, AndroidSchedulers.mainThread(), Schedulers.io());

		login.execute(this::getUserInfo, Throwable::printStackTrace, null);

	}

	private void getUserInfo(Accessor entity) {





	}

	public void actionLogOut() {

		Cache cache  = new CacheImpl(AccessorEntity.class);

		AccessorDataStoreFactory factory = new AccessorDataStoreFactory(cache);


		factory.createCloudDataStore (dataStore -> {


			AccessorRepository repository = new AccessorDataRepository(dataStore, AccessorDataMapper.newInstance());

			LogOut logOut  = new LogOut (repository, AndroidSchedulers.mainThread (), Schedulers.io ());

			logOut.execute( isSuccess -> {}, isBad -> {}, null);


		});





	}
}
