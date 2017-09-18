package github.maxat.com.githubclient.presentation.presenter;

import android.content.Context;

import github.maxat.com.githubclient.presentation.view.kinds.RepoDataView;
import github.maxat.com.githubclient.presentation.view.kinds.UserPageDataView;

/**
 * Created by ajrat on 18.09.17.
 */

public class RepositoriesPresenter  implements Presenter<RepoDataView>  {

    Context context;

    RepoDataView repoDataView;

    public  RepositoriesPresenter(Context context){
        this.context = context;
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
    public void attach(RepoDataView repoDataView) {
        this.repoDataView = repoDataView;
    }

    public void userRepositories() {


    }
}
