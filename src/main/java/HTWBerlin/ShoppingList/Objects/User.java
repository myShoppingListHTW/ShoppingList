package HTWBerlin.ShoppingList.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class User {
    private Long userId;
    private String name;

    public User(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
