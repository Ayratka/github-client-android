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

	String hashed_token;

	String note;

	String note_url;



	public void setToken(String token) {
		this.token = token;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setHashed_token(String hashed_token) {
		this.hashed_token = hashed_token;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setNote_url(String note_url) {
		this.note_url = note_url;
	}

}
