package HTWBerlin.ShoppingList.Repos;

import HTWBerlin.ShoppingList.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
