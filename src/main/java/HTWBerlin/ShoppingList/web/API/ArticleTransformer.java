package HTWBerlin.ShoppingList.web.API;

import HTWBerlin.ShoppingList.persistence.ArticleEntity;
import org.springframework.stereotype.Service;

@Service
public class ArticleTransformer {

    public Article transformEntity(ArticleEntity articleEntity) {
        return new Article(
                articleEntity.getId(),
                articleEntity.getName(),
                articleEntity.isEmpty()
        );
        }
}
