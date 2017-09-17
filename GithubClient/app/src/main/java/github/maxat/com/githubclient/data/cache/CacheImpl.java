package github.maxat.com.githubclient.data.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import github.maxat.com.githubclient.data.cache.realm.RealmObservable;
import github.maxat.com.githubclient.data.entity.ICommonAction;
import github.maxat.com.githubclient.data.repository.BaseSpecification;
import github.maxat.com.githubclient.data.repository.Specification;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by ajrat on 09.09.17.
 */

public class CacheImpl implements Cache<RealmObject>{

    private final static String ID  =   "id";

    Class<? extends RealmObject> clazz;

    private static final long EXPIRATION_TIME = 60 * 10 * 1000;


    public  CacheImpl(Class<? extends RealmObject> clazz){
        this.clazz = clazz;
    }


    @Override
    public Observable<RealmObject> get(Specification specification) {

        return RealmObservable.object(realm -> {

            RealmQuery realmQuery =  getQuery(realm, specification);

            return (RealmObject) realmQuery.findFirst();

        });

    }


    @Override
    public Observable<RealmObject> get(List<Specification> specifications) {

        if (specifications == null || specifications.isEmpty())

             return RealmObservable.object(new Func1<Realm, RealmObject>() {
                 @Override
                 public RealmObject call(Realm realm) {
                     RealmObject realmObject =  realm.where(clazz).findFirst();
                     return realmObject!=null? realmObject: null;
                 }
             });
        else
        {

            return RealmObservable.object(realm -> {

                RealmQuery realmQuery = getQuery(realm, specifications);

                return (RealmObject) realmQuery.findFirst();
            });

        }





    }

    @Override
    public Observable<List<RealmObject>> getList(List<Specification> specifications) {

        return RealmObservable.object(realm -> {

            RealmQuery realmQuery = getQuery(realm, specifications);

            RealmResults realmObjects = realmQuery.findAll();

            Iterator iterator = realmObjects.iterator();

            List<RealmObject> objects = new ArrayList<>();

            while (iterator.hasNext()){

                RealmObject realmObject = (RealmObject) iterator.next();

                objects.add(realmObject);
            }

            return objects;
        });


    }

    @Override
    public Observable<List<RealmObject>> getList(Specification specification) {

        return RealmObservable.object(realm -> {


            RealmQuery realmQuery = getQuery(realm, specification);

            RealmResults realmObjects = realmQuery.findAll();

            Iterator iterator = realmObjects.iterator();

            List<RealmObject> objects = new ArrayList<>();

            while (iterator.hasNext()){

                RealmObject realmObject = (RealmObject) iterator.next();

                objects.add(realmObject);
            }

            return  objects;

        });

    }

    @Override
    public Observable<Void> put(RealmObject object) {

        return RealmObservable.object(new Func1<Realm, Void>() {
            @Override
            public Void call(Realm realm) {


                if (object instanceof ICommonAction){

                    ((ICommonAction) object).setLast_cache_update_time (System.currentTimeMillis());

                }

                realm.copyToRealmOrUpdate(object);

                return null;
            }
        });


    }

    @Override
    public Observable<Boolean> isCached(final long id) {

        return RealmObservable.object(realm -> {

            RealmQuery realmQuery = getQuery(realm, new BaseSpecification (ID, id));

            return realmQuery.findFirst()!=null;
        });



    }

    @Override
    public Observable<Boolean> isExpired(final long id) {

        return RealmObservable.object(new Func1<Realm, Boolean>() {
            @Override
            public Boolean call(Realm realm) {

                long currentTime = System.currentTimeMillis();

                RealmQuery realmQuery = getQuery(realm, new BaseSpecification(ID, id));

                RealmModel entity = (RealmModel) realmQuery.findFirst();

                long lastUpdateTime;

                if (entity instanceof ICommonAction){


                    lastUpdateTime  = ((ICommonAction)entity).getLast_cache_update_time();

                    return ((currentTime - lastUpdateTime) > EXPIRATION_TIME);


                }
                else
                {
                    return false;
                }

            }
        });

    }

    @Override
    public Observable<Void> evictAll() {

        return RealmObservable.object(new Func1<Realm, Void>() {
            @Override
            public Void call(Realm realm) {

                RealmQuery realmQuery = getQuery(realm, Collections.emptyList());

                RealmResults results = realmQuery.findAll();

                results.deleteAllFromRealm();

                return null;
            }
        });


    }



	private RealmQuery getQuery(Realm realm, Specification specification){


        RealmQuery realmQuery = realm.where(clazz);

        if (specification!=null)
            realmQuery = getBySpecification(realmQuery, specification);

        return realmQuery;
    }


    private RealmQuery getQuery(Realm realm, List<Specification> specifications){

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


}
