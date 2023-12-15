package HTWBerlin.ShoppingList.Entities;

import jakarta.persistence.*;

@Entity
public class ListEntity {
    @Id
    private Long id;
    private Long articleId;
    private int amount;




}



