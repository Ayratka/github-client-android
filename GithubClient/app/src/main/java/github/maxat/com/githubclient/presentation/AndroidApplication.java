package github.maxat.com.githubclient.presentation;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ayrat on 07.09.17.
 */
public class AndroidApplication extends MultiDexApplication {

	private final static String STORAGE_NAME = "GihubRealm";


	@Override
	public void onCreate() {
		super.onCreate ();

		Realm.init(this);
		RealmConfiguration config = new RealmConfiguration.Builder().name(STORAGE_NAME).build();
		Realm.setDefaultConfiguration(config);

	}

}
