package github.maxat.com.githubclient.data.cache;

import java.util.List;

import github.maxat.com.githubclient.data.entity.AccessorEntity;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public class CacheImpl implements Cache<RealmObject>{

    Class<RealmObject> clazz;

    public CacheImpl(Class<RealmObject> clazz){
        this.clazz = clazz;
    }


    @Override
    public Observable<RealmObject> get(Specification specification) {
        Realm realm = Realm.getDefaultInstance();
        final String field = specification.getField();
        Object value = specification.getValue();
        RealmQuery realmQuery   =   null;
        if (value instanceof Long){
            realmQuery = realm.where(clazz).equalTo(field, (Long) value);
        }
        if (value instanceof String){
            realmQuery = realm.where(clazz).equalTo(field, (String) value);
        }
        if (value instanceof Boolean){
            realmQuery = realm.where(clazz).equalTo(field, (Boolean) value);
        }
        if (value instanceof Float){
            realmQuery = realm.where(clazz).equalTo(field, (Float) value);
        }
        if (value instanceof Double){
            realmQuery = realm.where(clazz).equalTo(field, (Double) value);
        }
        if (value instanceof Integer){
            realmQuery = realm.where(clazz).equalTo(field, (Integer) value);
        }
        if (realmQuery!=null)
             return Observable.just((RealmObject) realmQuery.findFirst());
        else
            return  Observable.just(null);
    }

    @Override
    public Observable<RealmObject> get(List<Specification> specifications) {
        return null;
    }

    @Override
    public Observable<List<RealmObject>> getList(List<Specification> specifications) {
        return null;
    }

    @Override
    public Observable<List<RealmObject>> getList(Specification specification) {
        return null;
    }

    @Override
    public void put(RealmObject object) {

    }

    @Override
    public boolean isCached(int id) {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void evictAll() {

    }
}
