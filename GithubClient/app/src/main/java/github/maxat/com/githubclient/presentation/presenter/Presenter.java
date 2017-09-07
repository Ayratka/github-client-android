package github.maxat.com.githubclient.presentation.presenter;

/**
 * Created by ayrat on 07.09.17.
 */
public interface Presenter<T> {


	void resume();

	void pause();

	void destroy();

	void attach(T t);

}
