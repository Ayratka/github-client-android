package github.maxat.com.githubclient.presentation.view.kinds;

import android.support.annotation.NonNull;

/**
 * Created by ayrat on 11.09.17.
 */
public interface UserPageDataView extends BaseDataView{

    public void showLogin(final String login);

    public void showAvatar(final String url);

    public void showPublicRep(final int repo);

}
