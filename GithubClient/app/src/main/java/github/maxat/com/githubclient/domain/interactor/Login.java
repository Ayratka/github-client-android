package github.maxat.com.githubclient.domain.interactor;

import java.util.HashMap;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AbsEntity;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStoreFactory;
import github.maxat.com.githubclient.data.utils.AppNumeric;
import github.maxat.com.githubclient.domain.model.Accessor;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

/**
 * Created by ayrat on 08.09.17.
 */
public class Login extends UseCase<Boolean, Login.Params> {



	public Login(Scheduler front, Scheduler back) {
		super (front, back);
	}


	@Override
	Observable<Boolean> buildUseCaseObservable(Params params) {

		Cache<AbsEntity> cache = new CacheImpl(AbsEntity.class);

		AccessorDataStoreFactory factory = new AccessorDataStoreFactory(cache);

		AccessorDataStore dataStore;

		if (params!=null)
			dataStore = factory.createCloudDataStore(params.login, params.password);
		else
			dataStore = factory.create(AppNumeric.UNKNOWN);

		return dataStore.accessorEntity().map(entity -> entity!=null);

	}

	public static Params buildParams(final String strLogin, final String strPass){
		return new Params(strLogin, strPass);
	}

	public static class Params{

		String login;

		String password;

		public Params(String strLogin, String strPass){

			this.login  = strLogin;
			this.password = strPass;
		}


	}


}
