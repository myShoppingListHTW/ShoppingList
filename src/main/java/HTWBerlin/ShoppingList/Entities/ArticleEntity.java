package HTWBerlin.ShoppingList.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 20)
    @NotBlank
    private  String name;
    private boolean empty;
    @Enumerated(value = EnumType.STRING)
    private Category category;

    public ArticleEntity(){}

    public ArticleEntity(String name, boolean empty, Category category){
        this.name=name;
        this.empty=empty;
        this.category=category;
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
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

}
