package web.Transformers;

import Entities.ListEntity;
import Objects.ShoppingList;
import org.springframework.stereotype.Service;

@Service
public class ListTransformer {
    ArticleTransformer articleTransformer = new ArticleTransformer();
    UserTransformer userTransformer = new UserTransformer();
    public ShoppingList transformEntity(ListEntity list) {
        return new ShoppingList(
                list.getId(),
                articleTransformer.transformEntity(list.getArticleEntity()),
                userTransformer.transformEntity(list.getUserEntity()),
                list.getAmount()
        );
    }
}


