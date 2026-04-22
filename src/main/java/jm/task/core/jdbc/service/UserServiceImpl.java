package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoJDBCImpl();

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
        System.out.println("Таблица создана");
    }

    @Override
    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
        System.out.println("удалена таблица");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDao.saveUser(name, lastName, age);
        System.out.println("сохранен пользователь " + name + " " + lastName + " " + age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        System.out.println("пользователь с id " + id + " удален");
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users =  userDao.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (User user : users) {
            System.out.println(user);
        }
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
        System.out.println("Таблица очищена");
    }
}
