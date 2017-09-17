package github.maxat.com.githubclient.presentation.presenter;

import android.content.Context;
import android.util.Log;

import github.maxat.com.githubclient.data.cache.Cache;
import github.maxat.com.githubclient.data.cache.CacheImpl;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.data.entity.mapper.AccessorDataMapper;
import github.maxat.com.githubclient.data.entity.mapper.UserDataMapper;
import github.maxat.com.githubclient.data.repository.AccessorDataRepository;
import github.maxat.com.githubclient.data.repository.UserDataRepository;
import github.maxat.com.githubclient.data.repository.datastore.AccessorDataStore;
import github.maxat.com.githubclient.data.repository.datastore.UserDataStore;
import github.maxat.com.githubclient.data.repository.datastore.accessor.AccessorDataStoreFactory;
import github.maxat.com.githubclient.data.repository.datastore.user.UserDataStoreFactory;
import github.maxat.com.githubclient.data.utils.AppNumeric;
import github.maxat.com.githubclient.domain.interactor.GetUser;
import github.maxat.com.githubclient.domain.interactor.LogIn;
import github.maxat.com.githubclient.domain.interactor.LogOut;
import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.model.User;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import github.maxat.com.githubclient.domain.repository.UserRepository;
import github.maxat.com.githubclient.presentation.Navigator;
import github.maxat.com.githubclient.presentation.mapper.UserModelMapper;
import github.maxat.com.githubclient.presentation.model.UserModel;
import github.maxat.com.githubclient.presentation.view.activity.AbsActivity;
import github.maxat.com.githubclient.presentation.view.kinds.UserPageDataView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ayrat on 11.09.17.
 */
public class UserPagePresenter implements Presenter<UserPageDataView> {

	UserPageDataView userPageDataView;

	Context context;

	public UserPagePresenter(Context context){
		this.context  = context;
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
	public void attach(UserPageDataView userPageDataView) {
		this.userPageDataView = userPageDataView;
	}



	public void actionLogOut() {


		LogOut logOut  = new LogOut(AndroidSchedulers.mainThread(), Schedulers.computation());
		logOut.execute( isSucess -> {

			AbsActivity absActivity = userPageDataView.getAbsActivity();
			Navigator.toWebPage(absActivity);


		}, Throwable::printStackTrace, null );


	}

	public void selfUser() {

		Cache accessorCache = new CacheImpl(AccessorEntity.class);

		Cache userCache = new CacheImpl(UserEntity.class);

		UserDataStoreFactory factory = new UserDataStoreFactory(accessorCache, userCache);

		factory.create(userDataStore -> {


            UserRepository userRepository = new UserDataRepository(userDataStore, new UserDataMapper());


            GetUser getUser = new GetUser(userRepository, AndroidSchedulers.mainThread(), Schedulers.computation());

            getUser.execute(user -> {


				if (user!=null) {
					UserModelMapper userModelMapper = new UserModelMapper();
					UserModel userModel = userModelMapper.transform(user);


					userPageDataView.showLogin(userModel.getLogin());
					userPageDataView.showAvatar(userModel.getAvatar_url());
					userPageDataView.showPublicRep(userModel.getPublic_repos());
				}


            }, t -> {

				t.printStackTrace();

			}, (long) AppNumeric.UNKNOWN);



        }, AppNumeric.UNKNOWN);


	}

}
