package HTWBerlin.ShoppingList.Repos;

import HTWBerlin.ShoppingList.Entities.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends CrudRepository<ListEntity, Long> { }

