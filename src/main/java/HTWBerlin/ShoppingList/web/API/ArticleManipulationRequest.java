package HTWBerlin.ShoppingList.web.API;


import HTWBerlin.ShoppingList.Entities.Category;
import HTWBerlin.ShoppingList.Entities.Unit;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class  ArticleManipulationRequest {

    @Size(min = 2, message = "Name must be at least 2 characters long")
    private String name;
    private boolean empty;
    private String userArticle;
    @Pattern(
            regexp = "FRUIT|VEGETABLE|MEAT|FISH|DAIRY|BAKERY|SWEETS|DRINKS|ALCOHOL|OTHER",
            message = "please choose a Category for your new Item"
    )
    private Category category;
    @Pattern(
            regexp = "KILOGRAM|GRAM|LITER|MILLILITER|PIECE|PACK|BOTTLE|CAN|BOX|BAG|OTHER",
            message = "please choose a Category for your new Item"
    )
    private Unit unit;

    public String getUserArticle() {
        return userArticle;
    }

    public void setUserArticle(String userArticle) {
        this.userArticle = userArticle;
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
