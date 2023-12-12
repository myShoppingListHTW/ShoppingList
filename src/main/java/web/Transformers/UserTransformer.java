package web.Transformers;

import Entities.UserEntity;
import Objects.User;

public class UserTransformer {

    public User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword()
        );
    }

    public UserEntity transformToEntity(User user) {
        return new UserEntity(
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
