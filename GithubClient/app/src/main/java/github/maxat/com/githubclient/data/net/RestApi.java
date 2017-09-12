package github.maxat.com.githubclient.data.net;

import java.util.List;
import java.util.Map;

import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.domain.model.Accessor;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by ayrat on 07.09.17.
 */
public interface RestApi {


	@POST("authorizations")
	Observable<AccessorEntity> getAccessorEntity(@Body AuthBody authBody);


	@POST("authorizations")
	Observable<AccessorEntity> getAccessorEntity(@QueryMap Map<String, String> options, @Body AuthBody authBody);


	@DELETE("authorizations/{id}")
	Observable<Object> deleteAccessorEntity(@Path("id") long id, @QueryMap Map<String, String> options);


	@GET("user")
	Observable<UserEntity> getUser(@QueryMap Map<String, String> options);



}
