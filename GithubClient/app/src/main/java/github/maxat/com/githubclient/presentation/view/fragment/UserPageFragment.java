package github.maxat.com.githubclient.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.maxat.com.githubclient.R;
import github.maxat.com.githubclient.presentation.presenter.Presenter;
import github.maxat.com.githubclient.presentation.presenter.UserPagePresenter;
import github.maxat.com.githubclient.presentation.view.kinds.UserPageDataView;

/**
 * Created by ayrat on 11.09.17.
 */
public class UserPageFragment extends AbsFragment implements UserPageDataView{


	UserPagePresenter userPagePresenter;



	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		userPagePresenter = new UserPagePresenter ();
		userPagePresenter.attach (this);
	}


	public static UserPageFragment newInstance(Bundle args) {
		UserPageFragment fragment = new UserPageFragment ();
		fragment.setArguments (args);
		return fragment;
	}


	View content;

	@BindView (R.id.tvName)
	TextView tvName;

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
		userPagePresenter.getUser();
	}


	@OnClick(R.id.btnLogOut)
	public void onClickLogOut(){
		userPagePresenter.actionLogOut();
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
	public void onAttachFragment(Fragment childFragment) {
		super.onAttachFragment (childFragment);
		userPagePresenter.attach (this);
	}
}
