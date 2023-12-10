package HTWBerlin.ShoppingList.Registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String encodedPassword);
    User findByEmail(String email);
}
