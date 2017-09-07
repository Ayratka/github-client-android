package github.maxat.com.githubclient.presentation.view;

import android.app.Fragment;
import android.os.Bundle;

import butterknife.ButterKnife;
import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.presentation.presenter.MainPresenter;

public class MainActivity extends AbsActivity{


	MainPresenter mainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);
		ButterKnife.bind (this);
		mainPresenter = new MainPresenter ();
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
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment (fragment);
		mainPresenter.attach (this);
	}




}