package HTWBerlin.ShoppingList.Registration;

import HTWBerlin.ShoppingList.Registration.Login.Login;
import HTWBerlin.ShoppingList.Registration.Login.LoginMesage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements LoginService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String addUser(User user ) {

        User employee = new User(

                user.getUserId(),
                user.getUserName(),
                user.getEmail(),

                this.passwordEncoder.encode(user.getPassword())
        );

        userRepo.save(user);

        return "0";
    }
    User user;

    @Override
    public LoginMesage loginUser(Login login) {
        String msg = "";
        User user1 = userRepo.findByEmail(login.getEmail());
        if (user1 != null) {
            String password = login.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                if (true) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {

                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }


    }

}
