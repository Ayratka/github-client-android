package github.maxat.com.githubclient.domain.interactor;

import github.maxat.com.githubclient.data.utils.AppNumeric;
import github.maxat.com.githubclient.domain.model.User;
import github.maxat.com.githubclient.domain.repository.UserRepository;
import rx.Observable;
import rx.Scheduler;

/**
 * Created by ajrat on 15.09.17.
 */

public class GetUser extends UseCase<User, Long>{


    UserRepository userRepository;

    public GetUser(UserRepository userRepository, Scheduler front, Scheduler back) {
        super(front, back);
        this.userRepository = userRepository;
    }

    @Override
    Observable<User> buildUseCaseObservable(Long id) {
        return userRepository.read(id);
    }
}
