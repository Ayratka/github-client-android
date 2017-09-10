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


}
