package HTWBerlin.ShoppingList.Repos;

import HTWBerlin.ShoppingList.Entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> { }
