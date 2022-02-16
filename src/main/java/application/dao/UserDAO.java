package application.dao;

import application.model.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);
    void removeUserById(long id);
    List<User> getAllUsers();
    User getUserById(long id);
    void updateUser (User user);
}
