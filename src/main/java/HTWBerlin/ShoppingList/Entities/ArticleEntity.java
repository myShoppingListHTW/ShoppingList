package HTWBerlin.ShoppingList.Entities;


import HTWBerlin.ShoppingList.Objects.User;
import HTWBerlin.ShoppingList.enums.Category;
import HTWBerlin.ShoppingList.enums.Unit;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId;
    private  String name;
    private boolean empty;
    private String picID;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Enumerated(value = EnumType.STRING)
    private Unit unit;
    @OneToMany(mappedBy = "articleEntity")
    Set<ListEntity> list;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_article", referencedColumnName = "userid")
    private UserEntity userArticle;

    public ArticleEntity(){}

    public ArticleEntity(String name, boolean empty, Category category, Unit unit){
        this.name=name;
        this.empty=empty;
        this.picID= "string of the default pic";
        this.category=category;
        this.unit=unit;
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
    public UserEntity getUserArticle() {
        return userArticle;
    }
    public void setUserArticle(UserEntity userArticle) {
        this.userArticle = userArticle;
    }

}
