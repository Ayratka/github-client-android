package github.maxat.com.githubclient.data.entity.mapper;

import java.util.List;

/**
 * Created by ajrat on 11.09.17.
 */

public interface Mapper<From, To> {

    public To transform(From from);

    public List<To> transforms(List<From> fromList);
}
