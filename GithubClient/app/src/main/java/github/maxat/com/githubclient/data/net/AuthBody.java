package github.maxat.com.githubclient.data.net;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ajrat on 10.09.17.
 */

public class AuthBody {


    List<String> scopes;

    String note;

	final String client_id = "d91bbf0288ebe87426bb";

	final String client_secret = "a2cc73d39039b1347d6a7c91003c7bcea27de1fd";


    public void setScopes(String ... args) {
        if (args == null)
            return;
        this.scopes = new ArrayList<>();

        for (String arg: args){
            this.scopes.add(arg);
        }
    }


    public void setNote(String note) {
        this.note = note;
    }


	public static AuthBody newInstance() {
		AuthBody authBody = new AuthBody();
		authBody.setScopes("gist", "user", "repo");
		authBody.setNote("Android Client");
		return authBody;
	}
}
