package github.maxat.com.githubclient.data.entity;

import io.realm.RealmObject;

/**
 * Created by ajrat on 10.09.17.
 */

public abstract class AbsEntity extends RealmObject{



    protected long last_cache_update_time;


    public long getLast_cache_update_time() {
        return last_cache_update_time;
    }

    public void setLast_cache_update_time(long last_cache_update_time) {
        this.last_cache_update_time = last_cache_update_time;
    }


}
