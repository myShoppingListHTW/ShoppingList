package HTWBerlin.ShoppingList.Entities;


import HTWBerlin.ShoppingList.enums.Category;
import HTWBerlin.ShoppingList.enums.Unit;
import jakarta.persistence.*;

@Entity
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name;
    private boolean empty;
    private String userArticle;
    private String picID;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Enumerated(value = EnumType.STRING)
    private Unit unit;


    public ArticleEntity(){}

    public ArticleEntity(String name, boolean empty, String userArticle, Category category, Unit unit){
        this.name=name;
        this.empty=empty;
        this.picID= "string of the defulat pic";
        this.userArticle= userArticle;
        this.category=category;
        this.unit=unit;
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
    public String getPicID() {
        return picID;
    }
    public void setPicID(String picID) {
        this.picID = picID;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Unit getUnit() {
        return unit;
    }
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    public String isUserArticle() {
        return userArticle;
    }
    public void setUserArticle(String userArticle) {
        this.userArticle = userArticle;
    }
}
