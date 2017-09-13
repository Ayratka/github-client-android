package github.maxat.com.githubclient.data.net.auth;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ayrat on 13.09.17.
 */
public class TokenAuthInterceptor extends AuthInterceptor{


	public TokenAuthInterceptor(String token){
		credentials = String.format ("token: %s", token);
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
		Request authenticatedRequest = request.newBuilder().header(AUTHORIZATION, credentials).build();
		return chain.proceed(authenticatedRequest);
	}
}
