package github.maxat.com.githubclient.data.net;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import github.maxat.com.githubclient.Constants;

/**
 * Created by ajrat on 10.09.17.
 */

public class AuthBody {

    private final static String UNIQUE_NAME = "Android Client";

    private final static String GIST = "gist";

    private final static String USER = "user";

    private final static String REPO = "repo";

    List<String> scopes;

    String note;

    final String client_id = Constants.oath_client_id;

    final String client_secret = Constants.oath_client_secret;


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
		authBody.setScopes(GIST, USER, REPO);
		authBody.setNote(UNIQUE_NAME);
		return authBody;
	}
}
