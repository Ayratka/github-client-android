package github.maxat.com.githubclient.data.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Created by ajrat on 10.09.17.
 */

public class AppNumeric {

    public final static int UNKNOWN =   -1;


    public final static String compoundKey(@NonNull String ... args){

        String key  =   "";
        for (String arg: args){
            key = key.concat(arg);
        }
        return key;
    }
}
