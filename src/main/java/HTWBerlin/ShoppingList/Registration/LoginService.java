package HTWBerlin.ShoppingList.Registration;

import HTWBerlin.ShoppingList.Registration.Login.Login;
import HTWBerlin.ShoppingList.Registration.Login.LoginMesage;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    String addUser(User user);
   LoginMesage loginUser(Login login);
}
