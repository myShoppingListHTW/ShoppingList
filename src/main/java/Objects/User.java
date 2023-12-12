package Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class User {
    private Long userId;
    private String name;
    private String email;
    private String password;

    public User(Long userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public @Email @NotEmpty String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public @NotEmpty String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
