package github.maxat.com.githubclient.data.entity;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ayrat on 11.09.17.
 */
public class UserEntity extends RealmObject implements ICommonAction{



	@PrimaryKey
    long id;

	String login;

	String avatar_url;

	int public_repos;

	String url;


	int public_gists;

	int followers;

	int following;

	String created_at;

	String updated_at;


	 long last_cache_update_time;



	public long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public int getPublic_repos() {
		return public_repos;
	}


	@Override
	public void setLast_cache_update_time(long time) {
		this.last_cache_update_time = time;
	}

	@Override
	public long getLast_cache_update_time() {
		return last_cache_update_time;
	}
}
