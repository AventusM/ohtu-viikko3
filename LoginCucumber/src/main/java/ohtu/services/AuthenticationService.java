package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        //Tehtävän 7 ensimmäinen ehto tarkistettu tässä
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        boolean usernameAlphabetic = Pattern.matches("[a-z]+", username);
        boolean userlengthOK = username.length() >= 3;
        boolean passlengthOK = password.length() >= 8;
        boolean passwordOK = !Pattern.matches("[A-Za-z]+", password);
        return !(usernameAlphabetic && userlengthOK && passlengthOK && passwordOK);
    }
}
