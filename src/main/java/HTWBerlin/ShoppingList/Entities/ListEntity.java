package HTWBerlin.ShoppingList.Entities;

import jakarta.persistence.*;

@Entity
public class ListEntity {
    @EmbeddedId
    private ListEntityID id;
    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    private ArticleEntity articleEntity;
    @ManyToOne
    @MapsId("userid")
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    private int amount;

    public ListEntity() {
    }

    public ListEntity(ArticleEntity articleEntity, UserEntity userEntity) {
        this.articleEntity = articleEntity;
        this.userEntity = userEntity;
    }

    public ListEntityID getId() {
        return id;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}



