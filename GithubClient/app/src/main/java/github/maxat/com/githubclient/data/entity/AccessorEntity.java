package github.maxat.com.githubclient.data.entity;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ayrat on 08.09.17.
 */
public class AccessorEntity extends RealmObject {


	@PrimaryKey
	long id;

	String token;

	String hashed_token;

	String note;

	String note_url;



}
