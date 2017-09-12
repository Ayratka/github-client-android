package github.maxat.com.githubclient.data.cache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import github.maxat.com.githubclient.data.repository.BaseSpecification;
import github.maxat.com.githubclient.data.repository.Specification;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by ajrat on 09.09.17.
 */

public class CacheImpl implements Cache<RealmObject >{

    private final static String ID  =   "id";

    Class<? extends RealmObject> clazz;

    private static final long EXPIRATION_TIME = 60 * 10 * 1000;


    public  CacheImpl(Class<? extends RealmObject> clazz){
        this.clazz = clazz;
    }


    @Override
    public Observable<RealmObject> get(Specification specification) {

        RealmQuery realmQuery =  getQuery(specification);

        return Observable.just((RealmObject) realmQuery.findFirst());

    }


    @Override
    public Observable<RealmObject> get(List<Specification> specifications) {

        if (specifications  ==  null)

            return Observable.empty();

        RealmQuery realmQuery = getQuery(specifications);

        return Observable.just((RealmObject)realmQuery.findFirst());

    }

    @Override
    public Observable<List<RealmObject>> getList(List<Specification> specifications) {


        RealmQuery realmQuery = getQuery(specifications);

        RealmResults realmObjects = realmQuery.findAll();

        Iterator iterator = realmObjects.iterator();

        List<RealmObject> objects = new ArrayList<>();

        while (iterator.hasNext()){

            RealmObject realmObject = (RealmObject) iterator.next();

            objects.add(realmObject);
        }
        return Observable.just(objects);
    }

    @Override
    public Observable<List<RealmObject>> getList(Specification specification) {


        RealmQuery realmQuery = getQuery(specification);

        RealmResults realmObjects = realmQuery.findAll();

        Iterator iterator = realmObjects.iterator();

        List<RealmObject> objects = new ArrayList<>();

        while (iterator.hasNext()){

            RealmObject realmObject = (RealmObject) iterator.next();

            objects.add(realmObject);
        }
        return Observable.just(objects);
    }

    @Override
    public void put(RealmObject object) {

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

//        object.setLast_cache_update_time(System.currentTimeMillis());

        realm.copyToRealmOrUpdate(object);

        realm.commitTransaction();

    }

    @Override
    public boolean isCached(final long id) {

        RealmQuery realmQuery = getQuery(new BaseSpecification (ID, id));

        return realmQuery.findFirst()!=null;


    }

    @Override
    public boolean isExpired(final long id) {

        long currentTime = System.currentTimeMillis();

        RealmQuery realmQuery = getQuery(new BaseSpecification(ID, id));

        RealmModel entity = (RealmModel) realmQuery.findFirst();

//        long lastUpdateTime = entity.getLast_cache_update_time();

//        boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);
//
//        if (expired) {
//            this.evictAll();
//        }
//
//        return expired;
        return false;
    }

    @Override
    public void evictAll() {

        RealmQuery realmQuery = getQuery(Collections.emptyList());

        RealmResults results = realmQuery.findAll();

        results.deleteAllFromRealm();

    }

	@Override
	public boolean evict() {
		return false;
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


}
