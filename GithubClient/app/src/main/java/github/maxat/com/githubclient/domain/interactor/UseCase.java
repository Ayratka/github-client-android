package github.maxat.com.githubclient.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ayrat on 08.09.17.
 */
public abstract class UseCase <T, Params>{


	Scheduler front;

	Scheduler back;

	Subscription subscription;


	public UseCase(Scheduler front, Scheduler back){
		this.front = front;
		this.back = back;
	}


	abstract Observable<T> buildUseCaseObservable(Params params);



	public void execute(Action1<? super T> action, Action1<Throwable> throwable, Params params) {
		subscription = this.buildUseCaseObservable(params)
				.subscribeOn(back)
				.unsubscribeOn (back)
				.observeOn(front)
				.subscribe (action, throwable);
	}


	public void dispose(){
		if (subscription!=null){
			subscription.unsubscribe ();
		}
		subscription    =   null;
	}


}
