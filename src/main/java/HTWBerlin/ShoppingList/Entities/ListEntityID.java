package HTWBerlin.ShoppingList.Entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ListEntityID implements Serializable {
    private Long articleId;
    private Long userId;
}