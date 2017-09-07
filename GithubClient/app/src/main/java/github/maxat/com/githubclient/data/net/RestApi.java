package github.maxat.com.githubclient.data.net;

import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by ayrat on 07.09.17.
 */
public interface RestApi {



//	@POST("commands.json")
//	Observable<List<Object>> postCommandsDebug(@QueryMap Map<String, String> maps, @Body BodyCommands commands);


	@GET("mobile/get_user_details.json")
	Observable<Object> getAccessorEntity(@QueryMap Map<String, String> options);
}
