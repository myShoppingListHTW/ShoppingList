package Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Set;


@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @OneToMany(mappedBy = "userEntity")
    Set<ListEntity> list;
    @OneToOne(mappedBy = "userArticle")
    private ArticleEntity articleEntity;
    public UserEntity(String name, String email, String password) {
        this.name = name;
        this.email=email;
        this.password=password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ListEntity> getList() {
        return list;
    }

    public void setList(Set<ListEntity> list) {
        this.list = list;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }
}

