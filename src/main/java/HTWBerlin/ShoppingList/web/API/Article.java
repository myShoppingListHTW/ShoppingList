package HTWBerlin.ShoppingList.web.API;


public class Article {

    private long id;
    private String name;
    private boolean empty;
    private String userArticle;
    private String picID;
    private enum category {Fruit, Vegetable, Meat, Fish, Dairy, Bread, Sweets, Drinks, Other};
    private enum unit {kg, g, l, ml, piece};

    public Article(long id, String name, boolean empty) {
        this.id = id;
        this.name = name;
        this.empty = empty;
    }

    public String getUserArticle() {
        return userArticle;
    }

    public void setUserArticle(String userArticle) {
        this.userArticle = userArticle;
    }

    public String getPicID() {
        return picID;
    }

    public void setPicID(String picID) {
        this.picID = picID;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
