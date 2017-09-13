package github.maxat.com.githubclient.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import github.maxat.com.githubclient.data.entity.UserEntity;
import github.maxat.com.githubclient.domain.model.User;

/**
 * Created by ayrat on 14.09.17.
 */
public class UserDataMapper implements Mapper<UserEntity, User> {


	@Override
	public User transform(UserEntity userEntity) {

		User user = new User ();
		user.setId (userEntity.getId ());
		user.setAvatar_url (userEntity.getAvatar_url ());
		user.setLogin (userEntity.getLogin ());
		user.setPublic_repos (userEntity.getPublic_repos ());

		return user;
	}

	@Override
	public List<User> transforms(List<UserEntity> userEntities) {
		if (userEntities == null)
			return Collections.synchronizedList (Collections.emptyList ());
		List<User> users = new ArrayList<> ();
		for (UserEntity userEntity: userEntities){

			User user = transform (userEntity);
			users.add (user);
		}
		return users;
	}
}
