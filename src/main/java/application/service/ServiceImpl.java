package application.service;

import application.dao.UserDAO;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.transaction.Transaction;

import java.util.List;

@Service
public class ServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public ServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void cleanUsersTable() {
        userDAO.cleanUsersTable();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        userDAO.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
