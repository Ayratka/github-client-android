package github.maxat.com.githubclient.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import github.maxat.com.githubclient.data.entity.AccessorEntity;
import github.maxat.com.githubclient.domain.model.Accessor;

/**
 * Created by ajrat on 11.09.17.
 */

public class AccessorDataMapper implements Mapper<AccessorEntity, Accessor> {


    public static AccessorDataMapper newInstance() {
        return new AccessorDataMapper();
    }

    @Override
    public Accessor transform(AccessorEntity entity) {

        Accessor accessor = new Accessor();

        if (entity == null)
            return accessor;

        accessor.setToken(entity.getToken());
        accessor.setId(entity.getId());


        return accessor;
    }

    @Override
    public List<Accessor> transforms(List<AccessorEntity> accessorEntities) {
        if (accessorEntities == null)
            return Collections.synchronizedList(Collections.emptyList());
        List<Accessor> accessors = new ArrayList<>();
        for (AccessorEntity entity: accessorEntities){
            Accessor accessor  = transform(entity);
            accessors.add(accessor);
        }
        return accessors;
    }


}
