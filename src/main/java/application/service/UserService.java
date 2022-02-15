package application.service;

import application.model.User;

import java.util.List;

public interface UserService {
    void cleanUsersTable();
    void saveUser(User user);
    void removeUserById(long id);
    List<User> getAllUsers();
    User getUserById(long id);
    void updateUser (User user);
}
