package HTWBerlin.ShoppingList.web;

import HTWBerlin.ShoppingList.Entities.ListEntity;
import HTWBerlin.ShoppingList.web.API.ShoppingList;
import org.springframework.stereotype.Service;

@Service
public class ListTransformer {
    public ShoppingList transformEntity(ListEntity list) {
        return new ShoppingList(
                list.getId(),
                list.getArticleId(),
                list.getUserId(),
                list.getAmount()
        );
    }
}
