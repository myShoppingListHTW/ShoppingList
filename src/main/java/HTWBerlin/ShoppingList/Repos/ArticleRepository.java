package HTWBerlin.ShoppingList.Repos;
import HTWBerlin.ShoppingList.Entities.ArticleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> { }

