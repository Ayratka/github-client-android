package github.maxat.com.githubclient.presentation.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.repository.AccessorDataRepository;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStoreFactory;
import github.maxat.com.githubclient.domain.interactor.Login;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import github.maxat.com.githubclient.presentation.Navigator;
import github.maxat.com.githubclient.presentation.view.kinds.LoginDataView;
import io.realm.RealmModel;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ayrat on 07.09.17.
 */
public class LoginPresenter implements Presenter<LoginDataView> {

	Context context;

	LoginDataView loginDataView;


	public LoginPresenter(Context context, @NonNull LoginDataView loginDataView){
		this.context = context;
		this.loginDataView = loginDataView;
	}


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
	public void attach(LoginDataView loginDataView) {
		this.loginDataView = loginDataView;
	}



	public void actionLogin(String strLogin, String strPass) {

		if (strLogin.isEmpty() || strPass.isEmpty())
			loginDataView.showMessage(R.string.error_login_or_pass_empty);

		Cache cache  = new CacheImpl(AccessorEntity.class);

		AccessorDataStoreFactory factory = new AccessorDataStoreFactory(cache);

		AccessorDataStore dataStore = factory.createCloudDataStore(strLogin, strPass);

		AccessorRepository repository = new AccessorDataRepository(dataStore, AccessorDataMapper.newInstance());

		Login login  = new Login (repository, AndroidSchedulers.mainThread (), Schedulers.io ());

		login.execute ( this::isSuccess, isBad -> { loginDataView.showMessage (R.string.error_login_or_pass_incorrect); }, null);
	}




	private void isSuccess(Accessor entity) {
		if (entity!=null) {
			Navigator.toMainPage(context);
		}
		else
			loginDataView.showMessage (R.string.error_extract_accessor);
	}


}
