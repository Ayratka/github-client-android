package github.maxat.com.githubclient.presentation;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import io.realm.Realm;

/**
 * Created by ayrat on 07.09.17.
 */
public class AndroidApplication extends MultiDexApplication {


	@Override
	public void onCreate() {
		super.onCreate ();
		Realm.init(this);
	}

}
