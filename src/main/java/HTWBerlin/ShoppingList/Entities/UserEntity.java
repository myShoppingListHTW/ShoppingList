package HTWBerlin.ShoppingList.Entities;

import HTWBerlin.ShoppingList.Objects.User;
import jakarta.persistence.*;
import java.util.Set;


@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private  String name;
    @OneToMany(mappedBy = "userEntity")
    Set<ListEntity> list;
    @OneToOne(mappedBy = "userArticle")
    private ArticleEntity articleEntity;
    public UserEntity(String name) {
        this.name = name;
    }

    public UserEntity() {
    }

    public long getId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}

