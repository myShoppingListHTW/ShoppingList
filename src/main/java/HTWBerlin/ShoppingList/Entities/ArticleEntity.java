package HTWBerlin.ShoppingList.Entities;


import jakarta.persistence.*;

@Entity
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name;
    boolean empty;

    public ArticleEntity(){}

    public ArticleEntity(String name, boolean empty){
        this.name=name;
        this.empty=empty;
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
