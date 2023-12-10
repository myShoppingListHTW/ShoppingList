package HTWBerlin.ShoppingList.web.API;

import HTWBerlin.ShoppingList.Entities.ListEntityID;

public class ShoppingList {

    private ListEntityID id;
    private Long articleId;
    private Long userId;
    private int amount;

    public ListEntityID  getId() {
        return id;
    }
    public ShoppingList(ListEntityID id, long articleId, long userId, int amount) {
        this.id = id;
        this.articleId = articleId;
        this.userId = userId;
        this.amount = amount;
    }

    public long getArticle() {
        return articleId;
    }

    public void setArticle(long articleId) {
        this.articleId = articleId;
    }

    public long getUser() {
        return userId;
    }

    public void setUser(long userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
