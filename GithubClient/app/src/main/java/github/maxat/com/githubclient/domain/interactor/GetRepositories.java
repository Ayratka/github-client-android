package github.maxat.com.githubclient.domain.interactor;

import java.util.List;

import github.maxat.com.githubclient.domain.model.Repository;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by ajrat on 18.09.17.
 */

public class GetRepositories extends UseCase< List<Repository>, Void> {



    public GetRepositories(Scheduler front, Scheduler back) {
        super(front, back);
    }

    @Override
    Observable<List<Repository>> buildUseCaseObservable(Void aVoid) {
        return null;
    }
}
