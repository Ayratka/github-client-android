package github.maxat.com.githubclient.presentation.presenter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.repository.AccessorDataRepository;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.data.repository.datastore.accessor.AccessorDataStoreFactory;
import github.maxat.com.githubclient.domain.interactor.LogIn;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import github.maxat.com.githubclient.presentation.Navigator;
import github.maxat.com.githubclient.presentation.view.activity.AbsActivity;
import github.maxat.com.githubclient.presentation.view.fragment.UserPageFragment;
import github.maxat.com.githubclient.presentation.view.kinds.BaseDataView;
import github.maxat.com.githubclient.presentation.view.kinds.MainDataView;
import io.realm.RealmObject;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ayrat on 07.09.17.
 */
public class MainPresenter implements Presenter<MainDataView> {

	MainDataView mainDataView;

	Context context;

	public MainPresenter(Context context){
		this.context = context;
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
	public void attach(MainDataView mainDataView) {
		this.mainDataView = mainDataView;
	}

	public void checkAuth() {



		LogIn login = LogIn.newInstance();

		login.execute(this::action, throwable -> { action(false); }, null);

	}

	private void action(boolean isSuccess) {

		AbsActivity absActivity = mainDataView.getAbsActivity();

		if (isSuccess){

			UserPageFragment userPageFragment = UserPageFragment.newInstance(Bundle.EMPTY);
			userPageFragment.setAbsActivity(absActivity);
			mainDataView.toFragmentPage(userPageFragment);
		}

		else
		{

			Navigator.toLoginPage(absActivity);
		}
	}
}
