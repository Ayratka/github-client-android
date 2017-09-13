package github.maxat.com.githubclient.presentation.model;

/**
 * Created by ajrat on 12.09.17.
 */

public class UserModel {


	String login;

	String avatar_url;

	int public_repos;


	public void setPublic_repos(int public_repos) {
		this.public_repos = public_repos;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}


}
