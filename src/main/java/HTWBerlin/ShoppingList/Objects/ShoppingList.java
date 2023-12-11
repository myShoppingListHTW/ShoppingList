package HTWBerlin.ShoppingList.Objects;

import HTWBerlin.ShoppingList.Entities.ListEntityID;


public class ShoppingList {

    private ListEntityID listID;
    private Article article;
    private User user;
    private int amount;

    public ShoppingList(ListEntityID listID, Article article, User user, int amount) {
        this.listID = listID;
        this.article = article;
        this.user = user;
        this.amount = amount;
    }
    public ShoppingList() {
    }

    public ListEntityID getListID() {
        return listID;
    }

    public void setListID(ListEntityID listID) {
        this.listID = listID;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}