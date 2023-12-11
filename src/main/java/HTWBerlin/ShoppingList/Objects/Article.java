package HTWBerlin.ShoppingList.Objects;


import HTWBerlin.ShoppingList.Entities.ListEntity;
import HTWBerlin.ShoppingList.enums.Category;
import HTWBerlin.ShoppingList.enums.Unit;
import jakarta.persistence.OneToMany;
import java.util.Set;

public class Article {

    private long articleId;
    private String name;
    private boolean empty;
    private String userArticle;
    private String picID;
    private Category category;
    private Unit unit ;


    public Article(long articleId, String name, boolean empty, String picID, Category category, Unit unit) {
        this.articleId = articleId;
        this.name = name;
        this.empty = empty;
        this.userArticle = userArticle;
        this.picID = picID;
        this.category = category;
        this.unit = unit;
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
        return articleId;
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
