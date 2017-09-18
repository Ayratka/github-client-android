package github.maxat.com.githubclient.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.presentation.presenter.Presenter;
import github.maxat.com.githubclient.presentation.presenter.RepositoriesPresenter;
import github.maxat.com.githubclient.presentation.presenter.UserPagePresenter;
import github.maxat.com.githubclient.presentation.view.activity.AbsActivity;
import github.maxat.com.githubclient.presentation.view.kinds.RepoDataView;

/**
 * Created by ajrat on 18.09.17.
 */

public class RepositoriesFragment extends AbsFragment implements RepoDataView {





    AbsActivity absActivity;

    RepositoriesPresenter repositoriesPresenter;


    public void setAbsActivity(AbsActivity absActivity) {
        this.absActivity = absActivity;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        repositoriesPresenter = new RepositoriesPresenter (getContext());
        repositoriesPresenter.attach (this);
        if (absActivity == null){
            absActivity = (AbsActivity) getActivity();
        }
    }


    public static RepositoriesFragment newInstance(Bundle args) {
        RepositoriesFragment fragment = new RepositoriesFragment ();
        fragment.setArguments (args);
        return fragment;
    }

    View content;

    @BindView(R.id.listView)
    ListView listView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        content = inflater.inflate (R.layout.fragment_user_repositories, container, false);
        ButterKnife.bind (this, content);
        return content;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repositoriesPresenter.userRepositories();
    }

    @Override
    public Presenter getPresenter() {
        return repositoriesPresenter;
    }

    @Override
    public View getContent() {
        return content;
    }

    @Override
    public AbsActivity getAbsActivity() {
        return absActivity;
    }
}
