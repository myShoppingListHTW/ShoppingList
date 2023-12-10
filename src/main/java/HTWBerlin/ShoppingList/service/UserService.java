package HTWBerlin.ShoppingList.service;

import HTWBerlin.ShoppingList.Entities.User;
import HTWBerlin.ShoppingList.web.API.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
