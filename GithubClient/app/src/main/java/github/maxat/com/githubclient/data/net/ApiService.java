package github.maxat.com.githubclient.data.net;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;

import github.maxat.com.githubclient.BuildConfig;
import github.maxat.com.githubclient.data.net.auth.AuthInterceptor;
import github.maxat.com.githubclient.data.net.auth.BasicAuthInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ayrat on 07.09.17.
 */
public class ApiService {


	private final static String BASE_URL = "https://api.github.com/";

	public final static String  GITHUB_APP = "https://github.com/settings/applications";


	public static RestApi create(@NonNull AuthInterceptor authInterceptor)
	{


		OkHttpClient client = new OkHttpClient.Builder()
				.addInterceptor(authInterceptor)
				.build();


		if (BuildConfig.DEBUG) {
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor ();
			logging.setLevel (HttpLoggingInterceptor.Level.HEADERS);
		}

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder ().serializeNulls().create()))
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.client(client)
				.build();


		return retrofit.create(RestApi.class);

	}


	public static RestApi create( )
	{

		OkHttpClient client = new OkHttpClient.Builder().build();


		if (BuildConfig.DEBUG) {
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor ();
			logging.setLevel (HttpLoggingInterceptor.Level.HEADERS);
		}

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com/")
				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder ().serializeNulls().create()))
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.client(client)
				.build();


		return retrofit.create(RestApi.class);

	}


}
