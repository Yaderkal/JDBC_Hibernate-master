package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl extends Util implements UserService  {
    UserDao userDao = new UserDaoJDBCImpl();

    public void createUsersTable() {
        this.userDao.createUsersTable();
        System.out.println("Таблица создана");
    }

    public void dropUsersTable() throws SQLException {
        this.userDao.dropUsersTable();
        System.out.println("удалена таблица");
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        this.userDao.saveUser(name, lastName, age);
        System.out.println("сохранен пользователь " + name + " " + lastName + " " + age);
    }

    public void removeUserById(long id) {
        this.userDao.removeUserById(id);
        System.out.println("пользователь с id " + id + " удален");
    }

    public List<User> getAllUsers() throws SQLException {
        System.out.println(this.userDao.getAllUsers());
        return this.userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        this.userDao.cleanUsersTable();
        System.out.println("Таблица очищена");
    }
}
