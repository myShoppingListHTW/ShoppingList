package HTWBerlin.ShoppingList.web;

import HTWBerlin.ShoppingList.Entities.ArticleEntity;
import HTWBerlin.ShoppingList.Objects.Article;
import org.springframework.stereotype.Service;

@Service
public class ArticleTransformer {

    public Article transformEntity(ArticleEntity articleEntity) {
        return new Article(
                articleEntity.getId(),
                articleEntity.getName(),
                articleEntity.isEmpty(),
                articleEntity.getPicID(),
                articleEntity.getCategory(),
                articleEntity.getUnit()
        );
        }
}
