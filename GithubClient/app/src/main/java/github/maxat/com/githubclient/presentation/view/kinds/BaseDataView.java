package github.maxat.com.githubclient.presentation.view.kinds;

import android.support.annotation.StringRes;

/**
 * Created by ayrat on 07.09.17.
 */
public interface BaseDataView {

	public void showMessage(String message);

	public void showMessage(@StringRes int messageRes);


}
