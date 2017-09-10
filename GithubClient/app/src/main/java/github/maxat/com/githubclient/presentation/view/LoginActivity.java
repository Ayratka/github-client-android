package github.maxat.com.githubclient.presentation.view;

import android.app.Fragment;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
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
	AppCompatEditText btnOk;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_login);
		ButterKnife.bind (this);
		loginPresenter = new LoginPresenter (this);
	}



	@OnClick(R.id.btnOk)
	protected void onClickLogin(){
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

	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment (fragment);
		loginPresenter.attach (this);
	}





}
