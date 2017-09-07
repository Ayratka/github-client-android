package github.maxat.com.githubclient.presentation.presenter;

import github.maxat.com.githubclient.presentation.view.kinds.BaseDataView;

/**
 * Created by ayrat on 07.09.17.
 */
public class LoginPresenter implements Presenter<BaseDataView> {


	BaseDataView baseDataView;

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
	public void attach(BaseDataView baseDataView) {
		this.baseDataView = baseDataView;
	}



	public void login(String login, String pass) {

	}


}
