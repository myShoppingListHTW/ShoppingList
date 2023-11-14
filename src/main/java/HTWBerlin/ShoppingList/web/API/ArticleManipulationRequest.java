package HTWBerlin.ShoppingList.web.API;


import jakarta.validation.constraints.Size;

public class ArticleManipulationRequest {

    @Size(min = 2, message = "Name must be at least 2 characters long")
    private String name;
    private boolean empty;

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
}
