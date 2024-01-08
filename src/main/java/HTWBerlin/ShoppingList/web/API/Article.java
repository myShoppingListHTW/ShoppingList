package HTWBerlin.ShoppingList.web.API;


import HTWBerlin.ShoppingList.Entities.Category;

public class Article {

    private long id;
    private String name;
    private boolean empty;
    private Category category;

    private String owner;

    public Article(long id, String name, boolean empty, Category category, String owner) {
        this.id = id;
        this.name = name;
        this.empty = empty;
        this.category = category;
        this.owner = owner;
    }
    public Article() {    }
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

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
