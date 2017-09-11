package github.maxat.com.githubclient.presentation;

import android.content.Context;
import android.content.Intent;

import github.maxat.com.githubclient.presentation.view.activity.MainActivity;

/**
 * Created by ajrat on 10.09.17.
 */

public class Navigator {




    public static void toMainPage(Context context){
        Intent intent  = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);


    }
}
