package github.maxat.com.githubclient.data.entity;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ayrat on 11.09.17.
 */
public class UserEntity extends RealmObject {

    @PrimaryKey
    long id;


    long last_cache_update_time;


    public long getLast_cache_update_time() {
        return last_cache_update_time;
    }

    public void setLast_cache_update_time(long last_cache_update_time) {
        this.last_cache_update_time = last_cache_update_time;
    }


}
