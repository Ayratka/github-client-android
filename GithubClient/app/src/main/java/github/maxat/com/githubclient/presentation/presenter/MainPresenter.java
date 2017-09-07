package github.maxat.com.githubclient.presentation.presenter;

import github.maxat.com.githubclient.presentation.view.kinds.BaseDataView;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ayrat on 07.09.17.
 */
public class MainPresenter implements Presenter<BaseDataView> {

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
	public void attach(BaseDataView mainDataView) {
		this.baseDataView = mainDataView;
	}
}
