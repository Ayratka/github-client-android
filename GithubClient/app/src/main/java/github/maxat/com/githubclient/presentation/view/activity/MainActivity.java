package github.maxat.com.githubclient.presentation.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.Collection;
import java.util.Collections;

import butterknife.ButterKnife;
import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.cache.realm.RealmObservable;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.repository.AccessorDataRepository;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.data.repository.datastore.accessor.AccessorDataStoreFactory;
import github.maxat.com.githubclient.domain.interactor.LogIn;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import github.maxat.com.githubclient.presentation.Navigator;
import github.maxat.com.githubclient.presentation.presenter.MainPresenter;
import github.maxat.com.githubclient.presentation.view.fragment.UserPageFragment;
import github.maxat.com.githubclient.presentation.view.kinds.MainDataView;
import io.realm.Realm;
import io.realm.RealmObject;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AbsActivity implements MainDataView {


	MainPresenter mainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);
		ButterKnife.bind (this);
		mainPresenter = new MainPresenter (this);
		mainPresenter.attach(this);

		mainPresenter.checkAuth();




	}




	@Override
	protected void onResume() {
		super.onResume ();
		mainPresenter.resume ();
	}

	@Override
	protected void onPause() {
		super.onPause ();
		mainPresenter.pause ();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy ();
		mainPresenter.destroy ();
	}



	@Override
	public void toFragmentPage(Fragment fragment) {
		super.switchFragment(fragment);
	}
}
