package github.maxat.com.githubclient.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import github.maxat.com.githubclient.data.entity.AbsEntity;
import github.maxat.com.githubclient.data.entity.AccessorEntity;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public class CacheImpl implements Cache<AbsEntity>{

    private final static String ID  =   "id";

    Class<? extends RealmModel> clazz;

    private static final long EXPIRATION_TIME = 60 * 10 * 1000;


    public CacheImpl(Class<? extends RealmModel> clazz){
        this.clazz = clazz;
    }


    @Override
    public Observable<AbsEntity> get(Specification specification) {

        RealmQuery realmQuery =  getQuery(specification);

        return Observable.just((AbsEntity) realmQuery.findFirst());

    }


    @Override
    public Observable<AbsEntity> get(List<Specification> specifications) {

        if (specifications  ==  null)

            return Observable.empty();

        RealmQuery realmQuery = getQuery(specifications);

        return Observable.just((AbsEntity) realmQuery.findFirst());

    }

    @Override
    public Observable<List<AbsEntity>> getList(List<Specification> specifications) {


        RealmQuery realmQuery = getQuery(specifications);

        RealmResults realmObjects = realmQuery.findAll();

        Iterator iterator = realmObjects.iterator();

        List<AbsEntity> objects = new ArrayList<>();

        while (iterator.hasNext()){

            AbsEntity realmObject = (AbsEntity) iterator.next();

            objects.add(realmObject);
        }
        return Observable.just(objects);
    }

    @Override
    public Observable<List<AbsEntity>> getList(Specification specification) {


        RealmQuery realmQuery = getQuery(specification);

        RealmResults realmObjects = realmQuery.findAll();

        Iterator iterator = realmObjects.iterator();

        List<AbsEntity> objects = new ArrayList<>();

        while (iterator.hasNext()){

            AbsEntity realmObject = (AbsEntity) iterator.next();

            objects.add(realmObject);
        }
        return Observable.just(objects);
    }

    @Override
    public void put(AbsEntity object) {

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        object.setLast_cache_update_time(System.currentTimeMillis());

        realm.copyToRealmOrUpdate(object);

        realm.commitTransaction();

    }

    @Override
    public boolean isCached(final long id) {

        RealmQuery realmQuery = getQuery(new BaseSpecification(ID, id));

        return realmQuery.findFirst()!=null;


    }

    @Override
    public boolean isExpired(final long id) {

        long currentTime = System.currentTimeMillis();

        RealmQuery realmQuery = getQuery(new BaseSpecification(ID, id));

        AbsEntity entity = (AbsEntity) realmQuery.findFirst();

        long lastUpdateTime = entity.getLast_cache_update_time();

        boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

        if (expired) {
            this.evictAll();
        }

        return expired;
    }

    @Override
    public void evictAll() {

        RealmQuery realmQuery = getQuery(Collections.emptyList());

        RealmResults results = realmQuery.findAll();

        results.deleteAllFromRealm();

    }


    private RealmQuery getQuery(Specification specification){

        Realm realm = Realm.getDefaultInstance();

        RealmQuery realmQuery = realm.where(clazz);

        if (specification!=null)
            realmQuery = getBySpecification(realmQuery, specification);

        return realmQuery;
    }


    private RealmQuery getQuery(List<Specification> specifications){


        Realm realm = Realm.getDefaultInstance();

        RealmQuery realmQuery = realm.where(clazz);

        if (specifications!=null && !specifications.isEmpty()) {
            for (Specification specification : specifications) {
                realmQuery = getBySpecification(realmQuery, specification);
            }
        }

        return realmQuery;
    }





    private RealmQuery getBySpecification(RealmQuery realmQuery, Specification specification) {

        final String field = specification.getField();

        Object value = specification.getValue();

        if (value instanceof Long){
            realmQuery = realmQuery.equalTo(field, (Long) value);
        }
        if (value instanceof String){
            realmQuery = realmQuery.equalTo(field, (String) value);
        }
        if (value instanceof Boolean){
            realmQuery = realmQuery.equalTo(field, (Boolean) value);
        }
        if (value instanceof Float){
            realmQuery = realmQuery.equalTo(field, (Float) value);
        }
        if (value instanceof Double){
            realmQuery = realmQuery.equalTo(field, (Double) value);
        }
        if (value instanceof Integer){
            realmQuery = realmQuery.equalTo(field, (Integer) value);
        }

        return realmQuery;
    }


    public class BaseSpecification implements Specification{

        String field;

        Object value;

        public BaseSpecification(final String field, Object value){
            this.field = field;
            this.value = value;

        }

        @Override
        public String getField() {
            return field;
        }

        @Override
        public Object getValue() {
            return value;
        }
    }
}
