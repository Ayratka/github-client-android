package github.maxat.com.githubclient.presentation.view.fragment;

import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import github.maxat.com.githubclient.presentation.presenter.Presenter;
import github.maxat.com.githubclient.presentation.view.kinds.BaseDataView;

/**
 * Created by ayrat on 11.09.17.
 */
public abstract class AbsFragment extends Fragment implements BaseDataView{



	public abstract Presenter getPresenter();

	public abstract View getContent();


	@Override
	public void showMessage(String message) {
		View view = getContent ();
		if (view!=null)
			Snackbar.make (view, message, Snackbar.LENGTH_SHORT).show ();
	}

	@Override
	public void showMessage(@StringRes int messageRes) {
		showMessage (getString (messageRes));
	}

	@Override
	public void onPause() {
		super.onPause ();
		Presenter presenter = getPresenter ();
		if (presenter!=null)
			presenter.pause ();
	}


	@Override
	public void onResume() {
		super.onResume ();
		Presenter presenter = getPresenter ();
		if (presenter!=null){
			presenter.resume ();
		}
	}


	@Override
	public void onDestroy() {
		super.onDestroy ();
		Presenter presenter = getPresenter ();
		if (presenter!=null){
			presenter.destroy ();

		}
	}
}
