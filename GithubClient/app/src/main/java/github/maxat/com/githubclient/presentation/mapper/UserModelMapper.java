package github.maxat.com.githubclient.presentation.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import github.maxat.com.githubclient.domain.model.User;
import github.maxat.com.githubclient.presentation.model.UserModel;

/**
 * Created by ajrat on 12.09.17.
 */

public class UserModelMapper implements ViewMapper<User, UserModel> {

    @Override
    public UserModel transform(User user) {
        UserModel userModel = new UserModel();
        userModel.setName(user.getName());
        return userModel;
    }

    @Override
    public List<UserModel> transforms(List<User> users) {
        if (users == null)
            return Collections.synchronizedList(Collections.emptyList());
        List<UserModel> userModels = new ArrayList<>();
        for (User user: users){
            userModels.add(transform(user));
        }
        return userModels;
    }
}
