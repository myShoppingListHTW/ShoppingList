package HTWBerlin.ShoppingList.web.API;


import HTWBerlin.ShoppingList.Entities.Category;
import jakarta.validation.constraints.Size;

public class  ArticleManipulationRequest {

    @Size(min = 2, max = 20, message = "Name must be at least 2 characters long")
    private String name;
    private boolean empty;
    private Category category;

    private String owner;


    public ArticleManipulationRequest(String name, boolean empty, Category category, String owner) {
        this.name = name;
        this.empty = empty;
        this.category = category;
        this.owner = owner;
    }

    public ArticleManipulationRequest() {}

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

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}
