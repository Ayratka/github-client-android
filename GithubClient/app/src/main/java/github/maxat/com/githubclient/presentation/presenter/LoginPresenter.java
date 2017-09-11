package github.maxat.com.githubclient.presentation.presenter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.domain.interactor.Login;
import github.maxat.com.githubclient.presentation.Navigator;
import github.maxat.com.githubclient.presentation.view.kinds.BaseDataView;
import github.maxat.com.githubclient.presentation.view.kinds.LoginDataView;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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

		Login login  = new Login (AndroidSchedulers.mainThread (), Schedulers.io ());

		login.execute ( this::isSuccess,
					    isBad -> { loginDataView.showMessage (R.string.error_login_or_pass_incorrect); },
						Login.buildParams (strLogin, strPass));
	}




	private void isSuccess(AccessorEntity entity) {
		if (entity!=null)
			Navigator.toMainPage (context);
		else
			loginDataView.showMessage (R.string.error_extract_accessor);
	}


}
