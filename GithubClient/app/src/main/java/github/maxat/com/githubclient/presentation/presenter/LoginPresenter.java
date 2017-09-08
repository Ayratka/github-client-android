package github.maxat.com.githubclient.presentation.presenter;

import android.os.Handler;
import android.util.Log;

import github.maxat.com.githubclient.domain.interactor.Login;
import github.maxat.com.githubclient.presentation.view.kinds.BaseDataView;
import github.maxat.com.githubclient.presentation.view.kinds.LoginDataView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ayrat on 07.09.17.
 */
public class LoginPresenter implements Presenter<LoginDataView> {


	LoginDataView loginDataView;


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

		Login login  = new Login (AndroidSchedulers.mainThread (), Schedulers.io ());
		login.execute ( isSuccess -> {}, throwable -> {}, null);
	}


}
