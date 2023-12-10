package HTWBerlin.ShoppingList.Entities;

import HTWBerlin.ShoppingList.Registration.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ListEntity {
    @Id
    private ListEntityID id;
    private Long articleId;
    private Long userId;
    private int amount;

    @ManyToOne
    @JoinColumn(referencedColumnName = "articleId")
    private ArticleEntity articleEntity;


    @ManyToOne
    @JoinColumn(referencedColumnName = "userId")
    private User user;

    public ListEntity() {}

    public ListEntity(Long articleId, Long userId, int amount) {
        this.articleId = articleId;
        this.userId = userId;
        this.amount = amount;
        this.articleEntity = articleEntity;
        this.user = user;
    }

    public ListEntityID getId() {
        return id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



