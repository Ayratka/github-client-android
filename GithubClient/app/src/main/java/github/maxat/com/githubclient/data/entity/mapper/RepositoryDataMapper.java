package github.maxat.com.githubclient.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import github.maxat.com.githubclient.data.entity.RepositoryEntity;
import github.maxat.com.githubclient.domain.model.Repository;

/**
 * Created by ajrat on 18.09.17.
 */

public class RepositoryDataMapper implements Mapper<RepositoryEntity, Repository> {




    @Override
    public Repository transform(RepositoryEntity repositoryEntity) {

        Repository repository = new Repository();
        repository.setName(repositoryEntity.getName());
        repository.setDescription(repositoryEntity.getDescription());
        repository.setFull_name(repositoryEntity.getFull_name());
        repository.setHtml_url(repositoryEntity.getHtml_url());
        repository.setLanguage(repositoryEntity.getLanguage());

        return repository;
    }

    @Override
    public List<Repository> transforms(List<RepositoryEntity> repositoryEntities) {
        if (repositoryEntities == null)
            return new ArrayList<>();
        List<Repository> repositories = new ArrayList<>();
        for (RepositoryEntity entity: repositoryEntities){
            repositories.add(transform(entity));
        }
        return repositories;
    }
}
