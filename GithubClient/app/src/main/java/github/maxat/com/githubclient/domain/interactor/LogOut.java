package github.maxat.com.githubclient.domain.interactor;

import github.maxat.com.githubclient.domain.model.Accessor;
import github.maxat.com.githubclient.domain.repository.AccessorRepository;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by ayrat on 12.09.17.
 */
public class LogOut  extends UseCase<Boolean, Void>  {

	AccessorRepository accessorRepository;

	public LogOut(AccessorRepository accessorRepository, Scheduler front, Scheduler back) {
		super (front, back);
		this.accessorRepository = accessorRepository;
	}

	@Override
	Observable<Boolean> buildUseCaseObservable(Void aVoid) {
		return this.accessorRepository.deleteAccessor ();
	}
}
