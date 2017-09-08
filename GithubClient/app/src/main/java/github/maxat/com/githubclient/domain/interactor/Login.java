package github.maxat.com.githubclient.domain.interactor;

import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.data.net.RestApi;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by ayrat on 08.09.17.
 */
public class Login extends UseCase<Boolean, Object> {



	public Login(Scheduler front, Scheduler back) {
		super (front, back);
	}


	@Override
	Observable<Boolean> buildUseCaseObservable(Object o) {
		RestApi api = ApiService.create ();
		return api.getAccessorEntity ()
	}



}
