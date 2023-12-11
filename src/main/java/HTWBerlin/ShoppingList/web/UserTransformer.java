package HTWBerlin.ShoppingList.web;

import HTWBerlin.ShoppingList.Entities.UserEntity;
import HTWBerlin.ShoppingList.Objects.User;

public class UserTransformer {

    public User transformEntity(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName()
        );
    }
}
