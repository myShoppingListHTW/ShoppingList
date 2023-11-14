package HTWBerlin.ShoppingList.web;

import HTWBerlin.ShoppingList.Entities.ArticleEntity;
import HTWBerlin.ShoppingList.web.API.Article;
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
