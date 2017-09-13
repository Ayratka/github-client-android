package github.maxat.com.githubclient.data.net.auth;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ajrat on 10.09.17.
 */

public class BasicAuthInterceptor extends AuthInterceptor {



    public BasicAuthInterceptor(String user, String password) {
        credentials = Credentials.basic(user, password);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder().header(AUTHORIZATION, credentials).build();
        return chain.proceed(authenticatedRequest);
    }
}
