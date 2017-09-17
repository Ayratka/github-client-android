package github.maxat.com.githubclient.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.presentation.presenter.Presenter;
import github.maxat.com.githubclient.presentation.presenter.UserPagePresenter;
import github.maxat.com.githubclient.presentation.view.activity.AbsActivity;
import github.maxat.com.githubclient.presentation.view.kinds.UserPageDataView;

/**
 * Created by ayrat on 11.09.17.
 */
public class UserPageFragment extends AbsFragment implements UserPageDataView{



	AbsActivity absActivity;

	UserPagePresenter userPagePresenter;

	public void setAbsActivity(AbsActivity absActivity) {
		this.absActivity = absActivity;
	}



	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		userPagePresenter = new UserPagePresenter (getContext());
		userPagePresenter.attach (this);
		if (absActivity == null)
			absActivity = (AbsActivity) getActivity();
	}


	public static UserPageFragment newInstance(Bundle args) {
		UserPageFragment fragment = new UserPageFragment ();
		fragment.setArguments (args);
		return fragment;
	}


	View content;

	@BindView (R.id.tvName)
	TextView tvName;


	@BindView(R.id.ivAvatar)
	ImageView ivAvatar;

	@BindView(R.id.tvPublicRepo)
	TextView tvPublicRepo;

	@BindView(R.id.btnRepositories)
	AppCompatButton btnRepositories;


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		content = inflater.inflate (R.layout.fragment_user_page, container, false);
		ButterKnife.bind (this, content);
		return content;
	}


	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated (view, savedInstanceState);
		userPagePresenter.selfUser();
		userPagePresenter.selfRepositories();
	}

	@OnClick(R.id.btnRepositories)
	public void onClickRepositories(){

		if (absActivity!=null) {
			RepositoriesFragment repositoriesFragment = RepositoriesFragment.newInstance(Bundle.EMPTY);
			repositoriesFragment.setAbsActivity(absActivity);
			absActivity.switchFragmentAddStack(repositoriesFragment);
		}


	}

	@OnClick(R.id.btnLogOut)
	public void onClickLogOut(){
		userPagePresenter.actionLogOut( );
	}


	@Override
	public Presenter getPresenter() {
		return userPagePresenter;
	}

	@Override
	public View getContent() {
		return content;
	}


	@Override
	public AbsActivity getAbsActivity() {
		return absActivity.getAbsActivity();
	}

	@Override
	public void showLogin(String login) {
		tvName.setText(login);
	}

	@Override
	public void showAvatar(String url) {
		Picasso.with(getContext())
				.load(url)
				.error(android.R.drawable.stat_notify_error)
				.into(ivAvatar);
	}

	@Override
	public void showPublicRep(int repo) {
		tvPublicRepo.setText(String.valueOf(repo));
	}
}
