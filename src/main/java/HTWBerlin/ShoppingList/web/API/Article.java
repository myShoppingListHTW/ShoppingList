package HTWBerlin.ShoppingList.web.API;


public class Article {

    private long id;
    private String name;
    private boolean empty;

    public Article(long id, String name, boolean empty) {
        this.id = id;
        this.name = name;
        this.empty = empty;
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
