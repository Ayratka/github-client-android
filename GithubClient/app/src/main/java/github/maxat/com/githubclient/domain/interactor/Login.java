package github.maxat.com.githubclient.domain.interactor;

import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by ayrat on 08.09.17.
 */
public class LogIn extends UseCase<Accessor, Void> {


	AccessorRepository accessorRepository;

	public LogIn(AccessorRepository accessorRepository, Scheduler front, Scheduler back) {
		super (front, back);
		this.accessorRepository = accessorRepository;
	}


	@Override
	Observable<Accessor> buildUseCaseObservable(Void unused) {
		return accessorRepository.readAccessor ();

	}

}
