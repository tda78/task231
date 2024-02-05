package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiseImpl implements UserService {


    private UserDao dao;

    public UserServiseImpl() {
    }

    @Autowired
    public UserServiseImpl(UserDao dao) {
        this.dao = dao;
    }


    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public User getUser(long id) {
        return dao.getUserByID(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        dao.deleteUser(id);
    }
}
