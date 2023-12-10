package HTWBerlin.ShoppingList.Entities;

import jakarta.persistence.*;

@Entity
public class ListEntity {
    @Id
    private Long id;
    private Long articleId;
    private Long userId;
    private int amount;

    @ManyToOne
    @JoinColumn(name = "articleID")
    private ArticleEntity articleEntity;

    /**
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;**/
}



