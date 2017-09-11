package github.maxat.com.githubclient.presentation.mapper;

import java.util.List;

/**
 * Created by ajrat on 12.09.17.
 */

public interface ViewMapper<From, To> {

    public To transform (From from);

    public List<To> transforms(List<From> fromList);
}
