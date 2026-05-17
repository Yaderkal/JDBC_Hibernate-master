package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoHibernateImpl();
    @Override
    public void createUsersTable() throws  SQLException {
        this.userDao.createUsersTable();
        System.out.println("Таблица создана");
    }
    @Override
    public void dropUsersTable() throws SQLException {
        this.userDao.dropUsersTable();
        System.out.println("удалена таблица");
    }
    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        this.userDao.saveUser(name, lastName, age);
        System.out.println("сохранен пользователь " + name + " " + lastName + " " + age);
    }
    @Override
    public void removeUserById(long id) {
        System.out.println("пользователь с id " + id + " удален");
        this.userDao.removeUserById(id);
    }
    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users =  this.userDao.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (User user : users) {
            System.out.println(user);
        }
        return this.userDao.getAllUsers();
    }
    @Override
    public void cleanUsersTable() {
        this.userDao.cleanUsersTable();
        System.out.println("Таблица очищена");
    }
}
