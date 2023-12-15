package HTWBerlin.ShoppingList.web.API;


import HTWBerlin.ShoppingList.Entities.Category;

public class Article {

    private long id;
    private String name;
    private boolean empty;
    private Category category;

    public Article(long id, String name, boolean empty, Category category) {
        this.id = id;
        this.name = name;
        this.empty = empty;
        this.category = category;
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
}
