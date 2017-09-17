package github.maxat.com.githubclient.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import github.maxat.com.githubclient.Constants;
import github.maxat.com.githubclient.data.net.ApiService;
import github.maxat.com.githubclient.presentation.view.activity.AbsActivity;
import github.maxat.com.githubclient.presentation.view.activity.LoginActivity;
import github.maxat.com.githubclient.presentation.view.activity.MainActivity;

/**
 * Created by ajrat on 10.09.17.
 */

public class Navigator {




    public static void toMainPage(AbsActivity context){
        Intent intent  = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        context.finish();

    }

    public static void toWebPage(AbsActivity context){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(Constants.GITHUB_APP));
        context.startActivity(intent);
    }

    public static void toLoginPage(AbsActivity context) {
        Intent intent  = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        context.finish();

    }
}
