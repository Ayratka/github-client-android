package github.maxat.com.githubclient.presentation.presenter;

import github.maxat.com.githubclient.presentation.view.kinds.UserPageDataView;

/**
 * Created by ayrat on 11.09.17.
 */
public class UserPagePresenter implements Presenter<UserPageDataView> {

	UserPageDataView userPageDataView;


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

	public void getUser() {

	}

	public void actionLogOut() {


	}
}
