package HTWBerlin.ShoppingList.Entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListEntityID implements Serializable {
    private Long articleId;
    private Long userId;

    public ListEntityID(Long articleId, Long userId) {
        this.articleId = articleId;
        this.userId = userId;
    }

    public ListEntityID() {

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListEntityID that = (ListEntityID) o;

        if (!Objects.equals(articleId, that.articleId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = articleId != null ? articleId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}