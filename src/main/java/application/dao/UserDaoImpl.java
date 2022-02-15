package application.dao;

import application.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDAO{

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void cleanUsersTable() {
        entityManager.createNativeQuery("truncate table user");
    }
}
