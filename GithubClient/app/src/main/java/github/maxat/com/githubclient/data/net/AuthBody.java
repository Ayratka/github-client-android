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



	String note_url;

	String client_id;

	String client_secret;

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}

    public void setScopes(String ... args) {
        if (args == null)
            return;
        this.scopes = new ArrayList<>();

        for (String arg: args){
            this.scopes.add(arg);
        }
    }

	public void setNote_url(String note_url) {
		this.note_url = note_url;
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
