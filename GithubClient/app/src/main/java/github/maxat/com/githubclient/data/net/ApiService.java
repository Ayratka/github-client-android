package github.maxat.com.githubclient.data.net;

import com.google.gson.GsonBuilder;

import github.maxat.com.githubclient.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ayrat on 07.09.17.
 */
public class ApiService {



	public static RestApi create()
	{

		OkHttpClient client = new OkHttpClient.Builder()
				.build();

		OkHttpClient okHttpClient = new OkHttpClient.Builder ().build ();


		if (BuildConfig.DEBUG) {
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor ();
			logging.setLevel (HttpLoggingInterceptor.Level.HEADERS);
		}

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://api.github.com/")

				// Data converter
				.addConverterFactory(GsonConverterFactory.create(new GsonBuilder ().serializeNulls().create()))
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.client(okHttpClient)
				.build();


		return retrofit.create(RestApi.class);

	}
}
