package github.maxat.com.githubclient.presentation.view.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.presentation.presenter.LoginPresenter;
import github.maxat.com.githubclient.presentation.view.kinds.LoginDataView;

/**
 * Created by ayrat on 07.09.17.
 */
public class LoginActivity extends AbsActivity implements LoginDataView {



	LoginPresenter loginPresenter;

	@BindView (R.id.editLogin)
	AppCompatEditText editLogin;

	@BindView (R.id.editPass)
	AppCompatEditText editPass;

	@BindView (R.id.btnOk)
	AppCompatButton btnOk;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_login);
		ButterKnife.bind(this);
		loginPresenter = new LoginPresenter (getBaseContext(), this);
	}

	@OnClick(R.id.btnOk)
	public void onClickLogin() {
		final String login = editLogin.getText ().toString ();
		final String pass = editPass.getText ().toString ();
		loginPresenter.actionLogin(login, pass);
	}


	@Override
	protected void onResume() {
		super.onResume ();
		loginPresenter.resume ();
	}

	@Override
	protected void onPause() {
		super.onPause ();
		loginPresenter.pause ();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy ();
		loginPresenter.destroy ();
	}







}
