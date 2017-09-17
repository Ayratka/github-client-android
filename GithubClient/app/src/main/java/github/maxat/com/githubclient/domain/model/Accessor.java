package github.maxat.com.githubclient.domain.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ayrat on 08.09.17.
 */
public class Accessor {



	long id;

	String token;


	public void setToken(String token) {
		this.token = token;
	}

	public void setId(long id) {
		this.id = id;
	}


	public long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

}
