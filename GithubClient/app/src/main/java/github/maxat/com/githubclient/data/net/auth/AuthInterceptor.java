package github.maxat.com.githubclient.data.net.auth;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by ayrat on 13.09.17.
 */
public abstract class AuthInterceptor implements Interceptor {

	protected final String AUTHORIZATION	=	"Authorization";

	protected String credentials;


	@Override
	public Response intercept(Chain chain) throws IOException {
		throw new ExceptionInInitializerError ("The method does not implement abstract class");
	}
}
