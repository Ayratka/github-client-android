package github.maxat.com.githubclient.domain.model;

/**
 * Created by ajrat on 12.09.17.
 */

public class User {



	long id;

	String login;

	String avatar_url;

	int public_repos;


	public String getLogin() {
		return login;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public int getPublic_repos() {
		return public_repos;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public void setPublic_repos(int public_repos) {
		this.public_repos = public_repos;
	}

}
