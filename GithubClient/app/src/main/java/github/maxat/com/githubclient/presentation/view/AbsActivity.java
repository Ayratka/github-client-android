package github.maxat.com.githubclient.presentation.view;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import github.maxat.com.githubclient.presentation.view.kinds.BaseDataView;

/**
 * Created by ayrat on 07.09.17.
 */
public abstract class AbsActivity extends AppCompatActivity implements BaseDataView {

	@Override
	public void showMessage(String message) {
		Toast.makeText (this, message, Toast.LENGTH_SHORT).show ();
	}

	@Override
	public void showMessage(@StringRes int messageRes) {
		this.showMessage( getString(messageRes)) ;
	}
}
